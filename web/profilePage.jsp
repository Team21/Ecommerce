<%-- 
    Document   : profilePage
    Created on : Mar 19, 2016, 4:49:55 PM
    Author     : islam
--%>

<%@page import="pojo.User"%>
<%@page import="factory.SessionFactory"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.lang.String"%>
<%@ page import="factory.DAOFactory"%>
<%@page import="pojo.Category"%>
<%@ page import="pojo.Product"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="factory.MysqlFactory"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

        <meta charset="utf-8">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

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
    </head>
    <body background="HomeImages/cloud-hd-backgrounds.jpg">

        <%
            User user = (User) SessionFactory.getSession(request, SessionFactory.USER);
            pageContext.setAttribute("user", user);

          //  System.out.println(user.getAddress()+"---"+user.getUserName());

        %>
        <%--<%@include file="header.jsp" %>--%>  <!-- include before create --> 
        <jsp:include page="header.jsp" flush="" />
        <!-- Main Body ================================================== -->
        <div id="mainBody" style="margin-top: -2px;" >

            <div class="container well" style="height:850px; background-color: mediumturquoise;">

                <div class="" style="height:850px;">
                    <!--Side bar eley 3al shemal On left-->
                    <%
                    %>

                    <%--<jsp:include page="sidebar.jsp" flush="" />--%>  <!-- Not good in design  --> 
                    <div align="Left">
                        <h2 style="font-weight:bold; font-size:xx-large; font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif; color:#FFF; text-shadow:#999;" >Your Personal Information</h2>
                    </div>



                    <div align="center">

                        <img src="HomeImages/contact-icon.png" width="150" height="150" alt="MyImaget"/>
<!--                         <h3 style="font-weight:bold; font-size:xx-large; font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif; color:#FFF; text-shadow:#999;" ><%=user.getUserName()%></h3>-->
                        <input type="file" name="pic" accept="image/*" value="Upload Image"/>

                    </div>
                    <!--                        button edit-->
                    <div align="right"> 
                        <input type="button" class="btn " style=" font-size: large; font-family: cursive;  background: #FFF; color: #008ab8;" value="Save" id="SaveEdit"/>
                        &nbsp;&nbsp;&nbsp;<input type="button" class="btn " style=" font-size: large; font-family: cursive;  background: #FFF; color: #008ab8;" value="Edit my Profile" id="EditButton"/>

                    </div>
                    <br/>
                    <table class="table">
                        <thead align="right">

                        </thead>

                        <tbody class="info" style="font-weight:bold; font-size:large; font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif;  text-shadow:#999;">
                            <tr class="info" >
                                <td>First Name : </td>
                                <td id="fnameValue"><%=user.getfName()%></td>
                                <td><input type="text" value="<%=user.getfName()%>" style="visibility:hidden" id="editFname"></td>

                                <!--                                <td> <input type="button" class="btn " style=" font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;" value="Edit"/> </td>-->

                            </tr>
                            <tr class="info">
                                <td >Last Name : </td>

                                <td  id="lnameValue"><%=user.getlName()%></td>
                                <td><input type="text" value="<%=user.getlName()%>" style="visibility: hidden" id="editLname"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >E-mail : </td>

                                <td  id="emailValue"><%=user.getEmail()%></td>
                                <td><input type="text" value="<%=user.getEmail()%>" style="visibility: hidden" id="editEmail"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >User Name : </td>

                                <td  id="usernameValue"><%=user.getUserName()%></td>
                                <td><input type="text" value="<%=user.getUserName()%>" style="visibility: hidden" id="editUserName"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >Password : </td>

                                <td  id="passwordValue"><%=user.getPassword()%></td>
                                <td><input type="password" value="<%=user.getPassword()%>" style="visibility: hidden" id="editPassword"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >Birth Date : </td>

                                <td  id="birthDateValue"><%=user.getBirthdate()%></td>
                                <td><input type="text" value="<%=user.getBirthdate()%>" style="visibility: hidden" id="editDate"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >Your Credit : </td>

                                <td  id="payPalValue"><%=user.getPaypal()%> <b style="color: #00cc00;">$</b></td>
                                <td><input type="text" value="<%=user.getPaypal()%>" style="visibility: hidden" id="editPayPal"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >Phone-Number : </td>

                                <td  id="PhoneValue"><%=user.getPhone()%></td>
                                <td><input type="text" value="<%=user.getPhone()%>" style="visibility: hidden" id="editPhone"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                            <tr class="info">
                                <td >Address : </td>

                                <td  id="addressValue"><%=user.getAddress()%></td>
                                <td><input type="text" value="<%=user.getAddress()%>" style="visibility: hidden" id="editAddress"></td>
                                <!--                                <td> <span class="btn " style="width: 30px; height: 20px; font-size: small; font-family: cursive;  background: #FFF; color: #008ab8;">Edit</span> </td>-->

                            </tr>
                        </tbody>
                    </table>
















                </div>
            </div>
        </div>
        <!--</div>-->   
        <!-- Footer ================================================================== -->
        <%--<%@include file="footer.jsp" %>--%>
        <jsp:include page="footer.jsp" flush="" />
        <script src="themes/js/jquery.js" type="text/javascript"></script> 
        <script src="themes/js/bootstrap.min.js" type="text/javascript"></script> 
        <script src="themes/js/google-code-prettify/prettify.js"></script> 
        <script src="themes/js/bootshop.js"></script> 
        <script src="themes/js/jquery.lightbox-0.5.js"></script> 
        <!-- Scripts--> 
        <script type="text/javascript" src="themes/js/jquery-1.12.0.min.js"></script> 
        <script type="text/javascript" src="js/EditProfileTest.js"></script>




    </body>
</html>
