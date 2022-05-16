
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.iti.ecommerce.essentials.model.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement"%>
<%
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    String check;
    boolean use_CartList=false;
    if (cart_list != null) {
        use_CartList=true;
        check = "notnull";
    } else {
        check = "null";
    }
    %>
<%
    String AccountLink = null;
    if (session.getAttribute("id")== null){
        AccountLink = request.getContextPath()+"/JSPfiles/Login.jsp";
    }else{
        AccountLink = request.getContextPath()+"/JSPfiles/edit_user.jsp";
    }
    boolean Registration=false;
boolean error=false;
boolean Login=false;
Double all_Price =0.0;
    switch (request.getRequestURL().toString().split("/")[5])
{
    case "registration.jsp":
        Registration=true;
        break;
    case "error.jsp":
        error=true;
        break;
    case "Login.jsp":
        Login=true;
        break;
    default:
        break;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Electro - HTML Ecommerce Template</title>

    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="/ECommerce/JSPfiles/css/font-awesome.min.css">
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/style.css"/>
    <link rel="icon" type="image/png" href="/ECommerce/JSPfiles/img/icons/favicon.ico"/>
    <% if (Login){ %>
<%--    for login page --%>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <%}%>
<%--    for registration page--%>
    <% if (Registration){ %>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/css/form-elements.css">
    <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/css/style.css">
    <%}%>
    <% if (error){ %>
<%--    for error page--%>
    <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/error.css"/>
    <%}%>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +021-95-51-84</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> email@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> 1734 Stonecoal Road</a></li>
            </ul>
            <ul class="header-links pull-right">
                <li><a href="#"><i class="fa fa-dollar"></i> USD</a></li>
                <li><a href="<%=AccountLink%>"><i class="fa fa-user-o"></i> My Account</a></li>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->
    <div id="checkifnull" style="display:none;"><%=check%></div>
    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="/ECommerce/JSPfiles/home.jsp" class="logo">
                            <img src="/ECommerce/JSPfiles/img/logo.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="/ECommerce/JSPfiles/home.jsp">
                            <!-- Cart -->
                            <div class="dropdown dropDownSearch">
                                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                    <input class="input-select input" placeholder="Search here" id="search_bar_id" name ="q">
                                </a>
                                <button class="search-btn">Search</button>
                                <div id="search-dropdown" class="cart-dropdown">

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <!-- Wishlist -->
                        <div>
                            <a href="#">
                                <i class="fa fa-heart-o"></i>
                                <span>Your Wishlist</span>
                                <div class="qty">0</div>
                            </a>
                        </div>
                        <!-- /Wishlist -->

                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Your Cart</span>
                                <div class="qty">
                                    <% if (use_CartList){
                                    out.println( cart_list.size());}else{ out.println(0); }
                                %></div>
                            </a>

                            <div class="cart-dropdown cart-dropdownList">
                                <div class="cart-list">
<%--                                    --%>
                                    <% if (use_CartList){
                                            ArrayList<Cart> carts =null;
                                            DatabaseManagement database = new DatabaseManagement();
                                            carts = database.getProductsFromCart(cart_list);
                                            request.setAttribute("cart_list", cart_list);
                                            request.setAttribute("cart_size", cart_list.size());

                                    %>
                                    <% for(Cart cart : carts){%>
                                    <% all_Price += cart.getPrice();%>
                                    <div class="product-widget">
                                        <div class="product-img">
                                            <img src="${pageContext.request.contextPath}/db_images/<% out.println(cart.getId()); %>.jpg" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a href="#"><% out.println(cart.getProduct_name()); %> </a></h3>
                                            <h4 class="product-price"><span class="qty"><%out.println(cart.getUser_quantity());%>x</span>$<% out.println(cart.getPrice());%></h4>
                                        </div>
                                    </div>
<%--    --%>                            <%}%>

                            </div>
                                <div class="cart-summary">
                                    <small><%out.println(cart_list.size());%> Item(s) selected</small>
                                    <h5>SUBTOTAL: $<%=all_Price%></h5>
                                </div>

                                <div class="cart-btns">
                                    <a href="/ECommerce/JSPfiles/Cart.jsp">View Cart</a>
                                    <a href="/ECommerce/JSPfiles/checkout.jsp">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                        </div>   <%}%>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->
