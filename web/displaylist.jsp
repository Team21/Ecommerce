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
                                $("#prodView").append("<tr><td>  " + data[i].name + "</td><td> " + data[i].price + "</td><td> " + data[i].quantity + "</td><td><button id=" + i + " onclick='addingProduct(" + i + ")'>Add</button></td></tr>");
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
    </head>
    <body>
    <center>
        <div id="divOfBtn">
            <h3>Show All Products</h3>
            <button id="displayProBtn">Execute Query</button>
        </div>
        <div id="divOfProduct">
            <table id="prodView">
                <tr>
                    <th> Name</th>
                    <th> Price</th>
                    <th> Disc</th>
                </tr>
            </table>
        </div>
    </center>
</body>
</html>
