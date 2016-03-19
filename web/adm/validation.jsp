<%-- 
    Document   : validation
    Created on : Mar 19, 2016, 3:51:31 PM
    Author     : Ahmad Moawad <ahmadmoawad3@gmail.com>
--%>

<%@page import="pojo.User"%>
<%@page import="factory.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    System.out.print("trace");
    User admin = SessionFactory.getSession(request, SessionFactory.ADMIN);
    if (admin == null) {

        response.sendRedirect("login.jsp");
        return;
    }
    
    
%>
