<%-- 
    Document   : Welcome
    Created on : Mar 13, 2016, 6:01:05 PM
    Author     : Hossam
--%>

<%@page import="dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User u;
            u = (User) session.getAttribute("user");
            out.println(u.getUserName()+u.getEmail());
        %> 
    </body>
</html>
