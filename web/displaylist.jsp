<%-- 
    Document   : displaylist
    Created on : Mar 14, 2016, 8:38:02 PM
    Author     : AndDeve
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
        <title>Display Products</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script type = "text/javascript" language = "javascript">

            function addingProduct(id) {
                alert(id);
                var jsonObject = {"productId": id};
                $.ajax({
                    url: 'RequestReciever',
                    type: 'get',
                    contentType: 'application/json',
                    data: jsonObject,
                    dataType: 'json',
                    success: function (data) {
                    }
                });
            }
        </script>
        <meta charset="utf-8">
        <title>Online Shopping</title>
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

        <%--<%@include file="header.jsp" %>--%>  <!-- include before create --> 
        <jsp:include page="header.jsp" flush="" />
        <!-- Main Bocy ================================================== -->
        <div id="mainBody" style="margin-top: -2px;">
            <div class="container" style="height:850px">
                <div class="row" style="height:850px">
                    <!--Side bar eley 3al shemal On left-->
                    <%@include file="sidebar.jsp" %>
                    <%--<jsp:include page="sidebar.jsp" flush="" />--%>  <!-- Not good in design  --> 
                    <a href="products.html" role="button"  style="padding-right:0;  width: 234px; height: 20px;">
                        <span class="btn btn-info ">
                            <h4 style="color:#FFF; font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif;  text-shadow:#999; ">  Our Products : </h4>
                        </span>
                    </a>
                    <br/>
                    <br/>
                    <ul class="thumbnails">
                        <c:forEach begin="0" end="5" items="${sessionScope.products}" var="current">
                            <li class="span3">
                                <div class="thumbnail">
                                    <a  href="product_details.html"><img src="themes/images/products/6.jpg" alt=""/></a>
                                    <div class="caption">
                                        <h5><c:out value="${current.name}" /></h5>
                                        <p> 
                                            <c:out value="${current.description}" /> 
                                            
                                        </p>
                                        <h4 style="text-align:center"><a class="btn" href="product_details.html"> <i class="icon-zoom-in"></i></a> <a class="btn" onclick="addingProduct(<c:out value="${current.id}" />);">Add to <i class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">$<c:out value="${current.price}" /></a></h4>

                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <!--</div>-->   
        <!-- Footer ================================================================== -->
        <%--<%@include file="footer.jsp" %>--%>
        <jsp:include page="footer.jsp" flush="" />
    </body>
</html>
