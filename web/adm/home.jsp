<%-- 
    Document   : Category
    Created on : Mar 17, 2016, 3:36:24 PM
    Author     : Ahmad Moawad <ahmadmoawad3@gmail.com>
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="pojo.Category"%>
<%@page import="factory.DAOFactory"%>
<%@page import="factory.MysqlFactory"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <jsp:include page="templete/head.jsp"/>

    <body>
        <script src="js/cat.js"></script>
        <jsp:include page="templete/nav.jsp"/>

        <div class="container-fluid">
            <div class="row">
                <jsp:include page="templete/sidebar.jsp"/>

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

                    <jsp:include page="templete/dashbordheader.jsp"/>
                    
                </div>
            </div>
        </div>
    </body>
</html>
