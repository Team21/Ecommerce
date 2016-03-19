<%-- 
    Document   : listOrderedProduct
    Created on : Mar 17, 2016, 5:46:10 PM
    Author     : AndDeve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<%@ page import="java.lang.String"%>
<%@ page import="factory.DAOFactory"%>
<%@ page import="pojo.Product"%>
<%@ page import="factory.SessionFactory"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="factory.MysqlFactory"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <title>Bootshop online Shopping cart</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--Less styles -->
        <!-- Other Less css file //different less files has different color scheam
             <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
             <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
        <!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->

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
            Set<Product> products = SessionFactory.getSession(request, SessionFactory.PRODUCT_ARRAY_LIST);
            if (products == null) {
                products = new HashSet<>();
            }
            pageContext.setAttribute("listOrderedProducts", products);
            
        %>
        <jsp:include page="header.jsp" flush="" />
        <!-- Main Bocy ================================================== -->
        <div id="mainBody" style="margin-top: -2px;">
            <div class="container" style="height:850px">
                <div class="row" style="height:850px">
                    <!--Side bar eley 3al shemal On left-->
                    <a href="products.html" role="button"  style="padding-right:0;  width: 234px; height: 20px;">
                        <span class="btn btn-info ">
                            <h4 style="color:#FFF; font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif;  text-shadow:#999; ">  List of your Ordered Products : </h4>
                        </span>
                    </a>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Description</th>
                                <th>Quantity/Update</th>
                                <th>Price</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach begin="0" end="7" items="${listOrderedProducts}" var="current">
                                <tr>
                                    <td> <img width="60" src="themes/images/products/4.jpg" alt=""/></td>
                                    <td><c:out value="${current.name}" /><br/><c:out value="${current.description}" />  </td>
                                    <td>
                                        <div class="input-append"><input class="span1" style="max-width:34px" placeholder="1" id="appendedInputButtons" size="16" type="text"><button class="btn" type="button"><i class="icon-minus"></i></button><button class="btn" type="button"><i class="icon-plus"></i></button><button class="btn btn-danger" type="button"><i class="icon-remove icon-white"></i></button></div>
                                    </td>
                                    <td>$<c:out value="${current.price}" /></td>
                                    <td>$110.00(price*#product)</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="6" style="text-align:right"><strong>Total Price: =</strong></td>
                                <td class="label label-important" style="display:block"> <strong> $155.00 </strong></td>
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
    </body>
</html>
