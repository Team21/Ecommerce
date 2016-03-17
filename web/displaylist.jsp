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
        <title>Display Products</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script type = "text/javascript" language = "javascript">
            var allData;
            
            $(document).ready(function () {
                $("#displayProBtn").click(function () {
                    var jsonObject = {};
                    $.ajax({
                        url: 'DisplayProducts',
                        type: 'get',
                        contentType: 'application/json',
                        data: jsonObject,
                        dataType: 'json',
                        success: function (data) {
                            allData = data;
                            for (var i = 0; i < data.length; i++) {
//                                $("#prodView").append("<tr><td>  " + data[i].name + "</td><td> " + data[i].price + "</td><td> " + data[i].quantity + "</td><td><button id=" + i + " onclick='addingProduct(" + data[i].id + ")'>Add</button></td></tr>");
//                                $("#divOfProduct").append("<div id="+data[i].id+" >  " + data[i].name + "<br/> " + data[i].price + "<br/> " + data[i].quantity + "<br/><button id=" + i + " onclick='addingProduct(" + data[i].id + ")'>Add</button><br></div>");
//                                $("#divOfProduct").append("<div class="+ data[i].id+"> "+
//                                        " <a  href='product_details.html'><img src='themes/images/products/7.jpg' alt=""/></a>" +
//                                        " <div class= caption>"+
//                                             "<h5>" + data[i].name + "</h5>"+
//                                             "<p>"+ 
//                                                " Lorem Ipsum is simply dummy text. "+
//                                             "</p>"
//                                             "<h4 style='text-align:center'><a class='btn' href='product_details.html'>"+
//                                               " <i class='icon-zoom-in'></i></a> <a class='btn' href='#'>Add to <i class='icon-shopping-cart'>"+
//                                               "</i></a> <a class='btn btn-primary' href='#'>"+$data[i].price +"</a></h4>"+
//                                         "</div>"+
//                                     "</div>");
                            }
                        }
                    });
                });
            });
            
            
            function addingProduct(id) {
                var product = allData[id];
                alert(product.id);
                var jsonObject = {"productId":product.id};
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
    <body>
    <center>
        <div id="divOfBtn">
            <h3>Show All Products</h3>
            <button id="displayProBtn">Execute Query</button>
        </div>
        <div id="divOfProduct" style="background: red">
<!--            <table id="prodView">
                <tr>
                    <th> Name</th>
                    <th> Price</th>
                    <th> Disc</th>
                </tr>
            </table>-->
            <%%>
        </div>
    </center>
</body>
</html>
