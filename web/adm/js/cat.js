/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function enableBtns() {

    var cat = $("#cats option:selected").text();
    $("#newCat").val(cat);
    $("#newCat").prop("readonly", false);
    $("#newCat").css("text-align", "left");
    $("#newCat").css("color", "red");
    $("#newCat").focus().select();
    $("#updateBtn").prop('disabled', false);
    $("#deleteBtn").prop('disabled', false);

}

$(document).ready(function () {
    $("#erroInfo").hide();

});
function addCat() {
    console.log("trace");
    console.log($("#catName").val());
    $.post("category",
            {
                op: "add",
                name: $("#catName").val()
            }, function (data, status) {

        if (data == "success") {

            $("#infoResp").text("saved");
        } else {
            $("#infoResp").text("doesn't insert into database");

        }
        $("#erroInfo").show();

    });
}