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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String e = request.getParameter("email");
            String p = request.getParameter("password");
            out.println("Welcome : " + "email = " + e + "<br/>" + "password = " + p);

            User usernow = (User) request.getAttribute("user");
           // out.println("<br/> Address = " + usernow.getAddress());

        %>

        <jsp:useBean id="user" scope="session" class="pojo.User"/>
        <jsp:setProperty name="user" property="id" value="<%=usernow.getId()%>" />
        <jsp:setProperty name="user" property="fName" value="<%=usernow.getfName()%>" />
        <jsp:setProperty name="user" property="lName" value="<%=usernow.getlName()%>" />
        <jsp:setProperty name="user" property="userName" value="<%=usernow.getUserName()%>" />
        <jsp:setProperty name="user" property="password" value="<%=usernow.getPassword()%>" />
        <jsp:setProperty name="user" property="birthdate" value="<%=usernow.getBirthdate()%>" />
        <jsp:setProperty name="user" property="email" value="<%=usernow.getEmail()%>" />
        <jsp:setProperty name="user" property="paypal" value="<%=usernow.getPaypal()%>" />
        <jsp:setProperty name="user" property="image" value="<%=usernow.getImage()%>" />
        <jsp:setProperty name="user" property="phone" value="<%=usernow.getPhone()%>" />
        <jsp:setProperty name="user" property="address" value="<%=usernow.getAddress()%>" />
        <jsp:setProperty name="user" property="permissionId" value="<%=usernow.getPermissionId()%>" />
        <jsp:setProperty name="user" property="activated" value="<%=usernow.getActivated()%>" />



        <h1>Hello World! welcome <%= e%> </h1> 
        <p>
            user on session:
            <br/>
            id = <jsp:getProperty name="user" property="id"/>
            <br/>
            <br/>User name = <jsp:getProperty name="user" property="userName"/>
            <br/>E-mail = <jsp:getProperty name="user" property="email"/>
            <br/>First name = <jsp:getProperty name="user" property="fName"/>
            <br/>Last name = <jsp:getProperty name="user" property="lName"/>
            <br/>Password = <jsp:getProperty name="user" property="password"/>
            <br/>Birth Date = <jsp:getProperty name="user" property="birthdate"/>
            <br/>Pay Pal Account = <jsp:getProperty name="user" property="paypal"/>
            <br/>image = <jsp:getProperty name="user" property="image"/>
            <br/>Phone Number = <jsp:getProperty name="user" property="phone"/>
            <br/>Address = <jsp:getProperty name="user" property="address"/>
            <br/>Permission ID = <jsp:getProperty name="user" property="permissionId"/>
            <br/>Activated = <jsp:getProperty name="user" property="activated"/>




        </p>

    </body>
</html>
