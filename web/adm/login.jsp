<%-- 
    Document   : login
    Created on : Mar 13, 2016, 5:15:02 PM
    Author     : Ahmad Moawad <ahmadmoawad3@gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login </title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#erroInfo").hide();
            });
            function login() {

                $.post("adminLogin", {
                    username: $("#username").val(),
                    password: $("#password").val()
                }, function (data, status) {

                    if (data == "success") {

                        window.location = "index.jsp";
                    } else {

                        $("#erroInfo").show();
                    }

                });

                return false;
            }
        </script>
    </head>
    <body class="well-large">

        <div class="alert alert-error" id="erroInfo" style="text-align: center; color:red; background: whitesmoke">
            <button type="button" class="close" data-dismiss="alert">&times;</button>

            <h4>
                error in username or password
            </h4>
        </div>
        <form method="post" action="adminLogin" onsubmit="return login();">

            <table class="table table-bordered table-striped" style="width:100%; text-align: center;">
                <tr>
                    <td>
                        <input type="text" name="username" placeholder="enter your username" style="width:50%;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="password" name="password" placeholder="enter your password" style="width:50%;"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="login" class="btn btn-primary"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
