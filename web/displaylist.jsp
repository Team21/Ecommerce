<%-- 
    Document   : displaylist
    Created on : Mar 14, 2016, 8:38:02 PM
    Author     : AndDeve
--%>

<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.lang.String"%>
<%@ page import="factory.DAOFactory"%>
<%@ page import="pojo.Product"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="factory.MysqlFactory"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            MysqlFactory obj = (MysqlFactory) DAOFactory.getDAOFactory(0);
            ArrayList<Product> products = (ArrayList<Product>) obj.getProduct().selectObjectsTO(new Product());
        %>
        <%=products.get(1).getName()%>
        <c:forEach items="${products}" var="p">
            <c:out value="${p.name}" />
            <c:out value="${p.id}" />
        </c:forEach>

    </body>
</html>
