<%-- 
    Document   : test1
    Created on : Mar 15, 2016, 7:23:29 PM
    Author     : islam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import ="java.sql.*" %>
<%@ page import ="pojo.*" %>
<%--<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" 
           uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <%
            
            //String head = request.getHeader()
            String reqttpe = request.getPathInfo();
            out.println("request gay men =  "+reqttpe);
//            String e = request.getParameter("inputEmail");
//            String p = request.getParameter("inputPassword");
//            out.println("Welcome : " + "email = " + e + "<br/>" + "password = " + p);
//
//             User usernow = (User) request.getAttribute("user");
            User regUser = (User) request.getAttribute("user");

            out.println("<br/> username = " + regUser.getUserName()+regUser.getEmail()+regUser.getPassword());
//            out.println("<br/> Address = " + usernow.getAddress());
            

        %>

        <br/>

        <b>_______________________________________________________________________________________________</b>




    </body>
</html>
