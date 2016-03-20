/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#addCatDiv").hide();
    $(".infoDiv").hide();
    $("#cats").change(function () {

        $(".infoDiv").hide();
    });

});
function enableBtns() {

    $(".infoDiv").hide();
    var cat = $("#cats option:selected").text();
    $("#newCat").val(cat);
    $("#newCat").prop("readonly", false);
    $("#newCat").css("text-align", "left");
    $("#newCat").css("color", "red");
    $("#newCat").focus().select();
    $("#updateBtn").prop('disabled', false);
    $("#deleteBtn").prop('disabled', false);
    $("#newCatImg").prop('disabled', false);
}

function addCat() {
    $.post("category",
            {
                op: "add",
                name: $("#catName").val()
            }, function (data, status) {

        if (data == "success") {

            notify("saved");
            refreshCats();
        } else {
            notify("doesn't insert into database");
        }
        $(".infoDiv").show();
    });
    return false;
}
function toggleDiv(param) {

    if (param == "add") {
        $("#editCatDiv").hide();
        $("#addCatDiv").show();
    } else if (param == "edit") {

        $("#addCatDiv").hide();
        $("#editCatDiv").show();

    }
    $(".infoDiv").hide();

}
function updateCat() {

    $.post("category",
            {
                op: "update",
                id: $("#cats option:selected").val(),
                name: $("#newCat").val()
            }, function (data, status) {

        if (data == "success") {

            notify("updated");
            refreshCats();
        } else {
            notify("doesn't update into database");
        }
        $(".infoDiv").show();
    });
}

function deleteCat() {


    $.post("category",
            {
                op: "delete",
                id: $("#cats option:selected").val()
            }, function (data, status) {

        console.log(data);
        if (data == "success") {

            notify("deleted")
            refreshCats();
        } else {
            notify("doesn't delete")
        }
        $(".infoDiv").show();
    });
}
function refreshCats() {
    $.get("category?op=refresh", function (data, status) {
        $("#cats").empty();
        for (var i = 0; i < data.length; i++) {
            $("#cats").append($("<option value='" + data[i].id + "'>" + data[i].name + "</option>"));

        }

    });
}
function notify(text) {

    $(".infoText").html(text);


}