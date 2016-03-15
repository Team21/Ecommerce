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
        <title>Admin</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script>
        
    </head>
    <body>
        <div class="well">
            <form method="post" action="login">
                <table class='table table-border table-striped'>
                    <tr>
                        <td>
                            <input type="text" name="username" placeholder="enter your username"/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="password" name="passwd" placeholder="enter your password"/>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="login" class='btn btn-primary'/>
                            <input type='reset' value="clear" class="btn btn-danger"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
