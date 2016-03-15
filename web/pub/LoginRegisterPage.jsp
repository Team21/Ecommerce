<%-- 
    Document   : LoginRegisterPage
    Created on : Mar 11, 2016, 5:02:45 PM
    Author     : Hossam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="LoginSignUpPageStyle.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    </head>
    <body>
        <header>
            <div id="header">
                Email          : <input type="email" id="Email" name="Email" required>
                Password  : <input type="password" id="Password" name="Password" required>
                <button name="login" id="login">Login</button>
            </div>
            <div id="messageDiv" style="display:none;"></div>
        </header>

        <table border="0" cellspacing="4" cellpadding="5">
            <tr>
                <td>
                    <div style="width: 733px;"></div>
                </td>
                <td>
                    <div class="login-block">
                        First Name: <input type="text" id="FirstName" required ><br>
                        Last Name: <input type="text" id="LastName" required><br>
                        Username : <input type="text" id="Userame" required><br>
                        Email          : <input type="email" id="E-mail"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required><br>
                        Password  : <input type="password" id="Passwd" required><br>  <!--pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"-->
                        Address      : <input type="text" id="Address" required><br>
                        Paypal        : <input type="text" id="Paypal" required><br>
                        Phone        : <input type="text" id="Phone"><br>
                        Birthday     : <input type="date" id="Birthdate"><br>
                        <button name="register" id="register">Register</button><br>
                    </div>
                </td>
            </tr>
        </table>

        <footer>
            <div id="footer">
                <p>W3Schools is optimized for learning, testing, and training. Examples might be simplified to improve reading and basic understanding. Tutorials, references, and examples are constantly 
                    reviewed to avoid errors, but we cannot warrant full correctness of all content. While using this site, you agree to have read and accepted our terms of use, cookie and privacy policy. 
                    Copyright 1999-2016 by Ref Data. All Rights Reserved.</p>
            </div>
        </footer>

        <script type = "text/javascript" language = "javascript">
            $("#login").click(function () {
                var email = $("#Email").val();
                var password = $("#Password").val();
                if (email !== "" && password !== "") {
                    $.ajax({
                        url: "SignInServletController",
                        method: "post",
                        data: {
                            "email": email, "password": password
                        },
                        success: function (data, textStatus, jqXHR) {
                            $('#messageDiv').html("<font color='green'>You are successfully logged in. </font>");
                            $('#messageDiv').css("display", "block");
                        window.location.href = "https://www.google.com/?gfe_rd=cr&ei=ti5OVpSTJ8bm-gbd8KWACA&gws_rd=cr&fg=1";
                        }
                    });
                } else {
                    alert("Check your inputs");
                }
            });
        </script>

        <script type = "text/javascript" language = "javascript">
            $("#register").click(function () {
                var email = $("#E-mail").val();
                var password = $("#Passwd").val();
                var fName = $("#FirstName").val();
                var lName = $("#LastName").val();
                var username = $("#Userame").val();
                var phone = $("#Phone").val();
                var address = $("#Address").val();
                var payal = $("#Paypal").val();
                var birthdate = $("#Birthdate").val();
                $.ajax({
                    url: "SignUpServletController",
                    method: "post",
                    data: {
                        "email": email, "password": password, "fname": fName, "lName": lName, "username": username, "phone": phone, "address": address, "paypal": payal, "birthdate": birthdate
                    },
                    success: function (data, textStatus, jqXHR) {
                        $('#messageDiv').html("<font color='green'>You are successfully logged in. </font>");
                        $('#messageDiv').css("display", "block");
                        window.location.href = "https://www.google.com/?gfe_rd=cr&ei=ti5OVpSTJ8bm-gbd8KWACA&gws_rd=cr&fg=1";
                    }
                });
            });
        </script>
    </body>
</html>
