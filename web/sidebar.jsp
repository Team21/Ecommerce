<%-- 
    Document   : sidebar
    Created on : Mar 18, 2016, 5:16:05 PM
    Author     : AndDeve
--%>


<%@page import="pojo.User"%>
<%@page import="java.util.Set"%>
<%@page import="factory.SessionFactory"%>
<%@page import="pojo.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<div id="sidebar" class="span3">
    <c:if test="${user!=null}">
        <div class="well well-small"><a id="myCart" href="product_summary.html"><img src="themes/images/ico-cart.png" alt="cart">
                <c:choose>
                    <c:when test="${SessionFactory.getSession(request, SessionFactory.PRODUCT_ARRAY_LIST)!=null}">
                        [ <%=((Set<Product>) SessionFactory.getSession(request, SessionFactory.PRODUCT_ARRAY_LIST)).size()%>  ]
                    </c:when>
                    <c:otherwise>
                        [ 0 ]
                    </c:otherwise> 
                </c:choose> 
                Items in your cart  
                <span class="badge badge-warning pull-right">
                    $<%=((User) SessionFactory.getSession(request, SessionFactory.USER)).getPaypal()%> 
                </span></a>
        </div>
    </c:if>
    <ul id="sideManu" class="nav nav-tabs nav-stacked">
        <li class="subMenu open"><a> ELECTRONICS [230]</a>
            <ul>
                <c:forEach begin="0" end="7" items="${categorys}" var="current">
                    <li><a href="products.html"><i class="icon-chevron-right"></i><c:out value="${current.name}" /> (30)</a></li>
                    </c:forEach>
            </ul>
        </li>
    </ul>
    <br/><br/><br/>
    <div class="thumbnail">
        <img src="themes/images/payment_methods.png" title="Bootshop Payment Methods" alt="Payments Methods">
        <div class="caption">
            <h5>Payment Methods</h5>
        </div>
    </div>
</div>
