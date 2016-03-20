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
        <%
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null) {
//                response.sendRedirect("");
//            }
        %>

        <div class="container" style="background-image: url(HomeImages/welcome_back.png); width:1366px; height: 677px; ">
            <div id="welcomeLine" class="row" > 

                <!--                                <div align="center">
                                                    <a href="#login" role="button" data-toggle="modal" style="padding-right:0">
                                                        <span class="btn btn-large btn-info" style="width: 90px; height: 33px; font-size: xx-large; font-family: cursive; margin-top: 50px; background: #FFF; color: #008ab8;">Login</span> 
                                                    </a>
                                                </div>-->


                <div id="loginModal" class="modal" tabindex="-1" role="dialog" aria-labelledby="login" aria-hidden="false" style="background: #d7f8cc; left: 310px; width: 480px;" >

                    <div class="modal-header">
                        <!--                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>-->
                        <h3 style="color:#008ab8;font-weight: bolder; font-size: x-large; font-family: cursive; " id="loginError" >Login :</h3>

                        <!--                        <span align="right" id="loadimg"> <img src='HomeImages/loadingWait.gif' alt='Loading Please Wait..' width='100px' height='100px' ></span>-->
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
                                    <input name="RememberMe"  type="checkbox"/>Remember me
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




                <!--******************************************************************************************************* -->
                <div style="position:absolute; left: 586px; top: 122px; width: 615px; height: 219px;" align="center">
                    <h3 style="color:#FFF;font-weight: bolder; font-size: xx-large; font-family: cursive; " >Register and Have an Account now ....</h3>
                    <!--                    <div class="control-group">
                                            <button type="submit" id="btnLogin" class="btn btn-large " style="font-weight: bolder; font-size: x-large; font-family: cursive;  background: #FFF; color: #008ab8;">Sign in</button>
                                                                        <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                                        </div>-->
                    <br/>
                    <br/>
                    <br/>
                    <a href="#register" role="button" data-toggle="modal" style="padding-right:0" >
                        <span class="btn btn-large " style="font-weight: bolder; font-size: x-large; font-family: cursive;  background: #FFF; color: #008ab8;">Register Now</span>
                    </a>
                    <!--registration page -->
                    <div id="register"  class="modal hide fade in " tabindex="-1" role="dialog" aria-labelledby="register" aria-hidden="false" style="max-height:750px ; height: 630px; top: 40%;  width: 1300px; left: 23%; "> 


                        <div class="well modal-header" style="background: url(HomeImages/cartoon_clouds_and_blue_sky-wallpaper-1024x1024.jpg); height: 30px; margin-bottom: 0px;">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><img src="HomeImages/erroricon.png" width="30px" height="20px"></button>
                            <h3 style="color:#FFF;font-weight: bolder; font-size: xx-large; font-family: cursive; " >Registration : </h3>
                        </div>

                        <div class=" modal-body" align="center" style=" height: 500px; max-height:800px ; background: url(HomeImages/cartoon_clouds_and_blue_sky-wallpaper-1024x1024.jpg);" >

                            <form class="form-horizontal well" method="post" id="formRegister" action="SignUpServletController">
                                <h4 class="text-info" style="font-weight: bold; font-size: large;">Your personal information</h4>
                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;">Title </label>
                                    <div class="controls">
                                        <!--                                        Title <sup>*</sup>-->
                                        <select class="span6" name="title"  id="title">
                                            <option value="">-</option>
                                            <option value="1">Mr.</option>
                                            <option value="2">Mrs</option>
                                            <option value="3">Miss</option>
                                        </select>
                                        <b id="titleError" style="color: tomato;"></b>
                                    </div>
                                </div>

                                <div class="control-group">

                                    <label class="control-label text-info" style=" font-weight: bold; font-size: large;" for="inputFname1">First name  <b style="color: tomato; font-weight: bolder; font-size: large;">*</b> </label>

                                    <div class="controls">
                                        <input type="text" class="span6" id="inputFname1" placeholder="First Name" required="true" name="inputFname1">
                                        <b id="fnameError" style="color: tomato;"></b>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="inputLnam">Last name </label>
                                    <div class="controls">
                                        <input type="text" class="span6" id="inputLnam" placeholder="Last Name"   name="inputLname1">
                                        <b id="lnameError" style="color: tomato;"></b>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="input_email">Email <sup style="color: tomato;">*</sup></label>
                                    <div class="controls">
                                        <input type="text" class="span6" id="input_email" placeholder="Email" required="true" name="inputEmail">
                                        <b id="emailError" style="color: tomato;">${sessionScope.invalidEmail}</b>
                                    </div>
                                </div>	  
                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="inputPassword1">Password <sup style="color: tomato;">*</sup></label>
                                    <div class="controls">
                                        <input type="password" class="span6" id="inputPassword1" placeholder="Password" required="true" name="inputPassword">
                                        <b id="passwordError" style="color: tomato;">  </b>
                                    </div>
                                </div>	 

                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="inputUserName">User name <sup style="color: tomato;">*</sup></label>
                                    <div class="controls">
                                        <input type="text" class="span6" id="inputUserName" placeholder="User Name" required="true" name="inputUserName">
                                        <b id="usernameError" style="color: tomato;"></b>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="inputPayPal"> PayPal Credit <sup style="color: tomato;">*</sup></label>
                                    <div class="controls">
                                        <input type="password" class="span6" id="inputPayPal" placeholder="Your PayPal Credit" required="true" name="inputPayPal">
                                        <b id="paypalError" style="color: tomato;"></b>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="inputPhone">Phone number </label>
                                    <div class="controls">
                                        <input type="text" class="span6" id="inputPhone" placeholder="Phone Number" name="inputPhone">
                                        <b id="phoneError" style="color: tomato;"></b>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" for="inputAddress">Address </label>
                                    <div class="controls">
                                        <input type="text" class="span6" id="inputAddress" placeholder="Address"  name="inputAddress">
                                        <b id="addressError" style="color: tomato;"></b>
                                    </div>
                                </div>


                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;" >Profile Image </label>
                                    <div class="controls">
                                        <input type="file" name="pic" accept="image/*" >

                                    </div>
                                </div>




                                <div class="control-group">
                                    <label class="control-label text-info" style="font-weight: bold; font-size: large;">Date of Birth <sup style="color: tomato;">*</sup></label>
                                    <div class="controls">
                                        <select class="span2" name="Days" required="true" >
                                            <option value="">-&nbsp;&nbsp;</option>
                                            <option value="1">1&nbsp;&nbsp;</option>
                                            <option value="2">2&nbsp;&nbsp;</option>
                                            <option value="3">3&nbsp;&nbsp;</option>
                                            <option value="4">4&nbsp;&nbsp;</option>
                                            <option value="5">5&nbsp;&nbsp;</option>
                                            <option value="6">6&nbsp;&nbsp;</option>
                                            <option value="7">7&nbsp;&nbsp;</option>
                                        </select>
                                        <select class="span2" name="Months" required="true" >
                                            <option value="">-&nbsp;&nbsp;</option> 
                                            <option value="01">January&nbsp;&nbsp;</option>
                                            <option value="02">February&nbsp;&nbsp;</option>
                                            <option value="03">March&nbsp;&nbsp;</option>
                                            <option value="04">April&nbsp;&nbsp;</option>
                                            <option value="05">May&nbsp;&nbsp;</option>
                                            <option value="06">June&nbsp;&nbsp;</option>
                                            <option value="07">July&nbsp;&nbsp;</option>
                                            <option value="08">August&nbsp;&nbsp;</option>
                                            <option value="09">September&nbsp;&nbsp;</option>
                                            <option value="10">October&nbsp;&nbsp;</option>
                                            <option value="11">November&nbsp;&nbsp;</option>
                                            <option value="12">December&nbsp;&nbsp;</option>

                                        </select>
                                        <select class="span2" name="Years" required="true" >
                                            <option value="">-&nbsp;&nbsp;</option>
                                            <option value="1980">1980&nbsp;&nbsp;</option>
                                            <option value="1981">1981&nbsp;&nbsp;</option>
                                            <option value="1982">1982&nbsp;&nbsp;</option>
                                            <option value="1983">1983&nbsp;&nbsp;</option>
                                            <option value="1984">1984&nbsp;&nbsp;</option>
                                            <option value="1985">1985&nbsp;&nbsp;</option>
                                            <option value="1986">1986&nbsp;&nbsp;</option>
                                            <option value="1987">1987&nbsp;&nbsp;</option>
                                            <option value="1988">1988&nbsp;&nbsp;</option>
                                            <option value="1989">1989&nbsp;&nbsp;</option>
                                            <option value="1990">1990&nbsp;&nbsp;</option>
                                            <option value="1991">1991&nbsp;&nbsp;</option>
                                            <option value="1992">1992&nbsp;&nbsp;</option>
                                            <option value="1993">1993&nbsp;&nbsp;</option>

                                        </select>
                                        <!--                                        <b id="lnameError" style="color: tomato;">date error</b>-->
                                    </div>
                                </div>





                                <div class="alert alert-block alert-error fade in" style="width:550px;"> <!-- visibility:hidden -->
                                    <button type="button" class="close" data-dismiss="alert">×</button>
                                    <span id="alertError"> <strong>Please Confirm your Data Correctly..</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</span>
                                </div>	



                                <p style="font-weight: bold; color: #ff6666; font-size: large;">* Required fields	</p>

                                <div class="control-group">
                                    <div >
                                        <input class="btn btn-large btn-info" type="submit" value="Register" />
                                        <input type="hidden" name="email_create" value="1">
                                        <input type="hidden" name="is_new_customer" value="1">

                                    </div>
                                </div>		
                            </form>

                        </div>
                        <div class="well modal-footer" style="background: url(HomeImages/cartoon_clouds_and_blue_sky-wallpaper-1024x1024.jpg); height: 5px; margin-top: 0px;">

                        </div>


                    </div>
                    <!--End of registration page -->

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
            <script type="text/javascript" src="js/registerTest.js"></script>


    </body>
</html>
