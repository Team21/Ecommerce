<%-- 
    Document   : indexHome
    Created on : Mar 15, 2016, 6:35:09 PM
    Author     : islam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width,minimum-scale=1,maximum-scale=1,user-scalable=no">
        <!-- Bootstrap style -->
        <link id="callCss" rel="stylesheet" href="themes/bootshop/bootstrap.min.css" media="screen"/>
        <link href="themes/css/base.css" rel="stylesheet" media="screen"/>
        <!-- Bootstrap style responsive -->
        <link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet"/>
        <link href="themes/css/font-awesome.css" rel="stylesheet" type="text/css">
        <!-- Google-code-prettify -->
        <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
        <!-- fav and touch icons -->
        <link rel="shortcut icon" href="themes/images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="themes/images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="themes/images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="themes/images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="themes/images/ico/apple-touch-icon-57-precomposed.png">
        <style type="text/css" id="enject"></style>
        <title>Welcome Page</title>
    </head>

    <body >


        <div class="container" style="background-image: url(HomeImages/welcome_back.png); width:1366px; height: 677px; ">
            <div id="welcomeLine" class="row"> 

                <!--                                <div align="center">
                                                    <a href="#login" role="button" data-toggle="modal" style="padding-right:0">
                                                        <span class="btn btn-large btn-info" style="width: 90px; height: 33px; font-size: xx-large; font-family: cursive; margin-top: 50px; background: #FFF; color: #008ab8;">Login</span> 
                                                    </a>
                                                </div>-->


                <div id="loginModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" style="background: #d7f8cc; left: 310px; width: 480px;" >

                    <div class="modal-header">
                        <!--                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>-->
                        <h3 style="color:#008ab8;font-weight: bolder; font-size: x-large; font-family: cursive; " id="loginError" >Login :
                        </h3>
                    </div>

                    <div class="modal-body" id="logindiv" >

                            <form class="form-horizontal loginFrm" method="post" id="formlogin" action="SignInServletController">
                            <div class="control-group">
                                <input type="text" id="inputEmail" placeholder="Email" name="email" required>
                                <b id="emailError" style="color: #C00;"> </b> </div>
                            <div class="control-group">
                                <input type="password" id="inputPassword" placeholder="Password" name="password" required >
                                <b id="passwordError" style="color: #C00;"> </b> </div>
                            <div class="control-group">
                                <label class="checkbox" style="color:#008ab8;  font-size: small; font-family: cursive;">
                                    <input type="checkbox"/>Remember me
                                </label>
                            </div>
                            <div class="control-group">
                                <button type="submit" id="btnLogin" class="btn btn-large " style="font-weight: bolder; font-size: x-large; font-family: cursive;  background: #FFF; color: #008ab8;">Sign in</button>
                                <!--                            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>-->
                            </div>
                        </form>


                    </div>
                </div>
                <!--end of login section-->









            </div>
        </div>


        <!-- Placed at the end of the document so the pages load faster ============================================= --> 
        <script src="themes/js/jquery.js" type="text/javascript"></script> 
        <script src="themes/js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="themes/js/google-code-prettify/prettify.js"></script> 
        <script src="themes/js/bootshop.js"></script> 
        <script src="themes/js/jquery.lightbox-0.5.js"></script> 
        <!-- Scripts--> 
        <script type="text/javascript" src="themes/js/jquery-1.12.0.min.js"></script> 
        <!--        <script type="text/javascript" src="js/loginjs.js"></script>-->
        <script type="text/javascript" src="js/loginTest.js"></script>



    </body>
</html>
