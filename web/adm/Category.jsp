<%-- 
    Document   : Category
    Created on : Mar 17, 2016, 3:36:24 PM
    Author     : Ahmad Moawad <ahmadmoawad3@gmail.com>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <jsp:include page="head.jsp"/>

    <body>
        <script src="js/cat.js"></script>

        <jsp:include page="header.jsp"/>

        <table style="width:100%;" class="table table-border table-striped">
            <tr>
                <td style="width:50%;">
                    <div class="well">
                        <div class="alert alert-error" id="erroInfo" style="text-align: center; color:red; background: whitesmoke">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <h4 id="infoResp">
                            </h4>
                        </div>
                        <form class="form form-horizontal">
                            <table class="table table-striped">
                                <tr>
                                    <td>
                                        <input type="text" id="catName" placeholder="add category name" required="" style="width:100%;"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label class="glyphicon glyphicon-upload">
                                            <span>
                                                image for category
                                            </span>
                                        </label>
                                        <input type="file" id="catImg"/>

                                    </td>

                                </tr>
                            </table>
                        </form>        
                        <button class="btn btn-primary glyphicon glyphicon-plus" onclick="addCat();"/>add
                    </div>
                </td>

                <td style="width:50%;">
                    <div class="well">
                        <table class="table table-striped">
                            <tr>
                                <td>
                                    <div class="container">
                                        <div class="row">

                                            <div class="col-lg-1">

                                                <label class="label label-success">
                                                    select category
                                                </label>
                                            </div>
                                            <div class="col-lg-9">


                                                <select id="cats" class="dropdown" style="width: 100%;">
                                                    <c:forEach begin="0" end="10"  step="1" var="i" >
                                                        <option>
                                                            <c:out value="${i}"/>
                                                        </option>
                                                    </c:forEach>

                                                </select>
                                            </div>
                                            <div class="col-lg-2">

                                                <button id="editBtn" class="btn btn-primary glyphicon glyphicon-pencil" style="width:100%;" onclick="enableBtns()">edit</button>
                                            </div>
                                        </div>

                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="container">
                                        <div class="row">

                                            <div class="col-lg-8">
                                                <input type="text" id="newCat" placeholder="select category from dropdown list" readonly="" style="width:100%;"/>
                                            </div>
                                            <div class="col-lg-2">
                                                <center>
                                                    <img src="img/icon.png" class="image images-circle" width="200"/>
                                                    <a href="#" role="button" class="btn btn-danger glyphicon glyphicon-remove">remove</a>
                                                </center>
                                            </div>
                                            <div class="col-lg-2">
                                                <button id="updateBtn" class="btn btn-warning  	glyphicon glyphicon-floppy-open" disabled="">update</button>
                                                <button id="deleteBtn" class="btn btn-danger  glyphicon glyphicon-remove" disabled="">delete</button>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>

                        </table>
                    </div>
                </td>

            </tr>
        </table>

        <jsp:include page="footer.jsp"/>

    </body>
</html>
