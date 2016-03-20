/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#addProductDiv").hide();
    $(".infoDiv").hide();
    $("#prods").change(function () {

        $(".infoDiv").hide();
    });
});
function enableBtns() {

    $.post("product", {
        op: "edit",
        id: $("#prods option:selected").val()
    }, function (data, status) {

        var quantity = data.quantity;
        var price = data.price;
        var catId = data.categoryId;
        var desc = data.description;
        $("#newDesc").val(desc);
        $("#newQuantity").val(quantity);
        $("#newPrice").val(price);
        $("#newCats").val(catId);
        $(".infoDiv").hide();
        var prod = $("#prods option:selected").text();
        $("#newProdName").val(prod);
        //editable
        $("#newProdName").prop("readonly", false);
        $("#newPrice").prop("readonly", false);
        $("#newQuantity").prop("readonly", false);
        $("#newDesc").prop("readonly", false);
        //enable
        $("#newDesc").prop("disabled", false);
        $("#newProdName").prop("disabled", false);
        $("#newPrice").prop("disabled", false);
        $("#newQuantity").prop("disabled", false);
        $("#newCats").prop('disabled', false);
        $("#updateBtn").prop('disabled', false);
        $("#deleteBtn").prop('disabled', false);
        $("#newProdImg").prop('disabled', false);
    });
}

function addProduct() {
    var data = new FormData();
//    data.append("img", $('#prodImg')[0]);
    data.append("op", "add");
    data.append("catId", $("#cats option:selected").val());
    data.append("quantity", $("#quantity").val());
    data.append("desc", $("#desc").val());
    data.append("name", $("#prodName").val());
    data.append("price", $("#price").val());
    jQuery.ajax({
        url: 'product',
        data: data,
        type: 'POST',
        success: function (data) {
            notify("saved");
            refreshProducts();
        }
    });
//    
//                   } else {
//                    notify("doesn't insert into database");
//                }
    $(".infoDiv").show();
    return false;
}
function toggleDiv(param) {

    if (param == "add") {
        $("#editProductDiv").hide();
        $("#addProductDiv").show();
    } else if (param == "edit") {

        $("#addProductDiv").hide();
        $("#editProductDiv").show();
    }
    $(".infoDiv").hide();
}
function updateProduct() {
    $.post("product",
            {
                op: "update",
                id: $("#prods option:selected").val(),
                catId: $("#newCats option:selected").val(),
                name: $("#newProdName").val(),
                desc: $("#newDesc").val(),
                quantity: $("#newQuantity").val(),
                price: $("#newPrice").val()
            }, function (data, status) {
        if (data == "success") {

            notify("updated")
            refreshProducts();
        } else {
            notify("doesn't update");
        }
        $(".infoDiv").show();
    });
}

function deleteProduct() {


    $.post("product",
            {
                op: "delete",
                id: $("#prods option:selected").val()
            }, function (data, status) {

        if (data == "success") {

            notify("deleted")
            refreshProducts();
        } else {
            notify("doesn't delete")
        }
        $(".infoDiv").show();
    });
}
function refreshProducts() {
    $.get("product?op=refresh", function (data, status) {
        $("#prods").empty();
        for (var i = 0; i < data.length; i++) {
            $("#prods").append($("<option value='" + data[i].id + "'>" + data[i].name + "</option>"));
        }

    });
}
function notify(text) {

    $(".infoText").html(text);
}