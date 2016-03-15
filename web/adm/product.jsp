<%-- 
    Document   : home
    Created on : Mar 13, 2016, 5:15:15 PM
    Author     : Ahmad Moawad <ahmadmoawad3@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script> 
        <script>
            window.onload = function () {

                $.post("product", {op: getAll}, function (data, status) {
                    var cat = data.cat;
                    for (var i = 0; i < cat.length; i++) {
                        $("#catSelect").append("<option></option>")
                                .attr("value", data[i])
                    }

                });

            }
        </script>

    </head>
    <body>
        <table style="width:100%; height: auto;" class="table">
            <tr>
                <td colspan="2">
                    <nav class="navbar navbar-inverse">
                        <div class="container-fluid">
                            <div class="navbar-header">
                                <a class="navbar-brand" href="#">ECommerce</a>
                            </div>
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="home.jsp">Home</a></li>

                                <li><a href="user.jsp">User</a></li>
                                <li><a href="product.jsp">Product</a></li>
                                <li><a href="profile.jsp">Profile</a></li>
                                <li><a href="logout">Logout</a></li>
                            </ul>
                        </div>
                    </nav>                
                </td>
            </tr>
            <tr>
                <td>


                    <table class="table table-bordered table-striped">
                        <tr>
                            <td>
                                <input type="text" name="productName" required=""  placeholder=""/>
                            </td>
                        </tr>
                    </table>
                </td>
                <td>

                    <table class="table table-bordered table-striped">
                        <tr>
                            <td>
                                <select id="catSelect">

                                </select>

                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>

                </td>
            </tr>
        </table>
    </body>
</html>
