<%-- 
    Document   : header
    Created on : Mar 18, 2016, 4:52:13 PM
    Author     : AndDeve
--%>

<%@page import="java.util.Set"%>
<%@page import="pojo.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="pojo.User"%>
<%@ page import="factory.SessionFactory"%>
<%
     User u = (User) SessionFactory.getSession(request, SessionFactory.USER);
%>
<div id="header">
    <div class="container">
        <div id="welcomeLine" class="row">
            <div class="span6">
                <strong  style="font-weight:bold; font-size:xx-large; font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif; color:#FFF; text-shadow:#999;" >Welcome!  
                    <a href="user.html"> 
                        <b  class="btn btn-mini btn-success" style="font-size:large; color:#FFF">
                            <c:choose>
                                <c:when test="${user==null}">
                                    User
                                </c:when>
                                <c:otherwise>
                                    <%=u.getUserName()%> 

                                </c:otherwise>
                            </c:choose>
                        </b>
                    </a>
                </strong>
            </div>
            <c:if test="${user!=null}">
                <div class="span6">
                    <div class="pull-right">
                        <div class="nav-header ">
                            <a href="product_summary.html">
                                <span  class="btn btn-mini" style="font-weight:bold;  font-family:'Palatino Linotype', 'Book Antiqua', Palatino, serif; color:#C00;" >Your Credit : </span>
                            </a>
                            <span class="btn btn-mini">$<%=((User) SessionFactory.getSession(request, SessionFactory.USER)).getPaypal()%>  </span>
                            <a href="product_summary.html">
                                <span class="btn btn-mini btn-primary">
                                    <i class="icon-shopping-cart icon-white"></i>
                                    <b style="color:#F93" id="NumberOfProductsInCart" name="NumberOfProductsInCart" value="NumberOfProductsInCart" >
                                        <c:choose>
                                            <c:when test="${SessionFactory.getSession(request, SessionFactory.PRODUCT_ARRAY_LIST)!=null}">
                                                [ <%=((Set<Product>) SessionFactory.getSession(request, SessionFactory.PRODUCT_ARRAY_LIST)).size()%>  ]
                                            </c:when>
                                            <c:otherwise>
                                                [ 0 ]
                                            </c:otherwise> 
                                        </c:choose>
                                    </b> 
                                    Itemes in your cart 
                                </span> 
                            </a> 
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
        <!-- Navbar ================================================== -->
        <div id="logoArea" class="navbar">
            <div class="navbar-inner">
                <!--*************************Search bar *************************-->
                <a class="brand" href="index.html"><img src="themes/images/homeIcon.png" alt="Bootsshop" width="55" height="41"/></a>
                <form class="form-inline navbar-search" method="post" action="products.html" >
                    <input id="srchFld" class="srchTxt" type="text" />
                    <select class="srchTxt">
                        <option disabled="" selected="" value="0">Search for : </option>
                        <option value="2">Product</option>
                        <option value="3">Category</option>
                    </select> 
                    <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                </form>
                <!--************************* right Bar *************************-->   <!-- Offers + Login Button-->
                <ul id="topMenu" class="nav pull-right">
                    <li class="">
                        <a  href="user.html" data-toggle="tooltip" data-placement="bottom"  title="My Account">
                            <img src="HomeImages/contact-icon.png" width="56" height="48" alt="MyAccount"/>
                        </a>
                    </li>
                    <li class="">
                        <a href="special_offer.html" data-toggle="tooltip" data-placement="bottom"  title="Special Offers"><img src="HomeImages/special_offers333.png"  alt="Special Offers" width="56" height="48"/></a>
                    </li>
                    <li class="">
                        <a href="contact.html" data-toggle="tooltip" data-placement="bottom"  title="Contact Us"><img src="HomeImages/images.png"  alt="Special Offers" width="56" height="48"/></a>
                    </li>
                    <!--Login div-->
                    <c:if test="${user==null}">
                        <li class="">
                            <a href="#login" role="button" data-toggle="modal" style="padding-right:0">
                                <span class="btn btn-large btn-success">Login</span>
                            </a>
                        </li>
                        <!--Register div-->
                        <li class="">
                            <a href="register.html" role="button" style="padding-right:0">
                                <span class="btn btn-large btn-success">Register</span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
