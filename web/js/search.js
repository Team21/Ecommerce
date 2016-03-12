/* 
 used to search in DB for user,product,category or any thing
 */
//author : islam

$(document).ready(function () {

    $("#searchbtn").click(function () {

        var searchText = $("#searchText").val();
        var searchValue = $("#selectMenu").val();
        //window.alert(searchValue);

        if (searchValue == 0) {

            window.alert('Please Choose What you want to search for ???');
            $("#chooseError").html("Please Choose What you want to search for ???");

        }

       else if (searchValue == 1) //search by user
        {

            $.post("searchServlet",
                    {//el json object
                        "searchValue": $("#searchText").val()
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt == "success") {

                    if (responseTxt == 3) {
                        $("#resultArea").val("please type something to search for");
                        // window.alert("You didn't enter a name to search for");
                        $("#searchText").focus();
                    }
                    else if (responseTxt[0] == 2) {

                        $("#resultArea").val("user not found");
                        //window.alert("not found");
                    }
                    else {
                        // var user = window.alert(responseTxt);
                        //var str = JSON.stringify(responseTxt, undefined, 4);
                        var jsonUser = JSON.parse(responseTxt);
                        $("#resultArea").val("id = " + jsonUser["id"] + "\n"
                                + "username = " + jsonUser["userName"]
                                + "\n" + "first name = " + jsonUser["fName"]
                                + "\n" + "email = " + jsonUser["email"]

                                );

                    }
                    /*
                     * {
                     "id": 1,
                     "email": "asdioha@asd.com",
                     "fName": "eslam",
                     "userName": "eslam",
                     "paypal": 0,
                     "permissionId": 0
                     }
                     * 
                     */
//                                
//                                if (responseTxt[0] == 1) {
//
//                                    //window.location = "chat.html";
//                                    window.alert("found");
//                                }



                }
                //$("#error").html($(uname));
                // window.alert(responseTxt);
                //window.alert("External content loaded successfully!");
                if (statusTxt == "error") {

                }
                // window.alert("Error: " + xhr.status + ": " + xhr.statusText);
            }
            );

        }




        //searching for product

        else if (searchValue == 2) {
            ///searchServletProduct
            $.post("searchServletProduct",
                    {//el json object
                        "searchValue": $("#searchText").val()
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt == "success") {

                    if (responseTxt == 3) {
                        $("#resultArea").val("please type something to search for");
                        // window.alert("You didn't enter a name of product to search for");
                        $("#searchText").focus();
                    }
                    else if (responseTxt[0] == 2) {

                        $("#resultArea").val("product not found");
                        // window.alert("not found");
                    }
                    else {
                        // var product = window.alert(responseTxt);
                        var jsonProduct = JSON.parse(responseTxt);

                        $("#resultArea").val("id = " + jsonProduct["id"] + "\n"
                                + "Product name = " + jsonProduct["name"]
                                + "\n" + "Price = " + jsonProduct["price"]
                                + "\n" + "Quantity = " + jsonProduct["quantity"]
                                + "\n" + "Category ID = " + jsonProduct["categoryId"]

                                );
                        // {"id":1,"name":"product1","quantity":3,"price":50,"categoryId":1}

                    }
                }

                if (statusTxt == "error") {
                }

            }
            );

        }


        //search for category
        else if (searchValue == 3) {
            ///searchServletCategory
            $.post("searchServletCategory",
                    {//el json object
                        "searchValue": $("#searchText").val()
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt == "success") {

                    if (responseTxt == 3) {
                        $("#resultArea").val("please type something to search for");
                        //  window.alert("You didn't enter a name of Category to search for");
                        //  $("#resultArea").val("");
                        $("#searchText").focus();
                    }
                    else if (responseTxt == 2) {

                        $("#resultArea").val("CAtegory not found");
                        //  window.alert("not found");
                    }

                    // var cateogry = window.alert(responseTxt);
                    $("#resultArea").val(responseTxt);



                }

                if (statusTxt == "error") {
                }

            }
            );





        }



    });

});






