<%-- 
    Document   : productDetails
    Created on : Mar 20, 2016, 1:07:52 PM
    Author     : Hossam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script type = "text/javascript" language = "javascript">
            function addingProduct(id) {
                var jsonObject = {"productId": id};
                $.ajax({
                    url: 'RequestReciever',
                    type: 'get',
                    contentType: 'application/json',
                    data: jsonObject,
                    dataType: 'json',
                    success: function (data) {}
                });
            }
        </script>
    </head>


    <body>
        <%--<%@include file="header.jsp" %>--%>  <!-- include before create --> 
        <jsp:include page="header.jsp" flush="" />
        
        <!-- Main Body ================================================== -->
        <div id="mainBody" style="margin-top: -2px;">
            <div class="container" style="height:850px">
                <div class="row" style="height:850px">
                    <!--Side bar eley 3al shemal On left-->
                    <%@include file="sidebar.jsp" %>
                    <%--<jsp:include page="sidebar.jsp" flush="" />--%>  <!-- Not good in design  -->
                    <div class="span9">
                        <div class="row">
                            <div id="gallery" class="span3">
                                <a href="themes/images/products/large/f1.jpg" title="Fujifilm FinePix S2950 Digital Camera">
                                    <img src="themes/images/products/large/3.jpg" style="width:100%" alt="Fujifilm FinePix S2950 Digital Camera"/>
                                </a>
                            </div>
                            <!----------------------end of gallery----------------------------------end of gallery----------------------end of gallery--------------------------->
                            <div class="span6">
                                
                                <h3>${sessionScope.productObj.getName()}</h3>
                                <small>- ${sessionScope.productObj.getName()}</small>
                                <hr class="soft"/>
                                <!--<form class="form-horizontal qtyFrm">-->
                                    <div class="control-group">
                                        <label class="control-label"><span>$ ${sessionScope.productObj.getPrice()}</span></label>
                                        <div class="controls">
                                            <!--<button type="submit" class="btn btn-large btn-primary pull-right" onclick="addingProduct();"> Add to cart <i class=" icon-shopping-cart"></i></button>-->
                                            <a class="btn" onclick="addingProduct(${sessionScope.productObj.getId()});">Add This Product to <i class="icon-shopping-cart"></i></a>
                                        </div>
                                    </div>
                                <!--</form>-->

                                <hr class="soft"/>
                                <h4> ${sessionScope.productObj.getQuantity()} items in stock</h4>
                                <hr class="soft clr"/>
                                <p>
                                    ${sessionScope.productObj.getDescription()}
                                </p>
                                <!--<br class="clr"/>-->
                            </div>
                        </div>
                    </div>
                    <!-------------------------div of main body of Page----------------------------</div of main body of Page>--------------------------------div of main body of Page--------------------->   
                </div>
            </div>
        </div>
        <!-- Footer ================================================================== -->
        <%--<%@include file="footer.jsp" %>--%>
        <jsp:include page="footer.jsp" flush="" />
    </body>
</html>
