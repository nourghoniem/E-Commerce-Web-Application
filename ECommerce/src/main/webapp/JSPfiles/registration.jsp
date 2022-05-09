
<%-- 
    Document   : registration
    Created on : Mar 19, 2022, 1:15:02 PM
    Author     : Abdelrahman Mostafa <Abdelrahman Mostafa at Information Technology Institute>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

  <!-- Custom stlylesheet -->
  <link type="text/css" rel="stylesheet" href="/ECommerce/JSPfiles/css/style.css"/>
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
  <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/css/form-elements.css">
  <link rel="stylesheet" href="/ECommerce/JSPfiles/assets/css/style.css">
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
        <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
      </ul>
    </div>
  </div>
  <!-- /TOP HEADER -->

  <!-- MAIN HEADER -->
  <div id="header">
    <!-- container -->
    <div class="container">
      <!-- row -->
      <div class="row">
        <!-- LOGO -->
        <div class="col-md-3">
          <div class="header-logo">
            <a href="#" class="logo">
              <img src="/ECommerce/JSPfiles/img/logo.png" alt="">
            </a>
          </div>
        </div>
        <!-- /LOGO -->

        <!-- SEARCH BAR -->
        <div class="col-md-6">
          <div class="header-search">
            <form method="get" action="home.jsp">
              <!-- Cart -->
              <div class="dropdown dropDownSearch">
                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                  <input class="input-select input" placeholder="Search here" id="search_bar_id">
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
                <div class="qty">2</div>
              </a>
            </div>
            <!-- /Wishlist -->

            <!-- Cart -->
            <div class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                <i class="fa fa-shopping-cart"></i>
                <span>Your Cart</span>
                <div class="qty">3</div>
              </a>
              <div class="cart-dropdown">
                <div class="cart-list">
                  <div class="product-widget">
                    <div class="product-img">
                      <img src="./img/product01.png" alt="">
                    </div>
                    <div class="product-body">
                      <h3 class="product-name"><a href="#">product name goes here</a></h3>
                      <h4 class="product-price"><span class="qty">1x</span>$980.00</h4>
                    </div>
                    <button class="delete"><i class="fa fa-close"></i></button>
                  </div>

                  <div class="product-widget">
                    <div class="product-img">
                      <img src="./img/product02.png" alt="">
                    </div>
                    <div class="product-body">
                      <h3 class="product-name"><a href="#">product name goes here</a></h3>
                      <h4 class="product-price"><span class="qty">3x</span>$980.00</h4>
                    </div>
                    <button class="delete"><i class="fa fa-close"></i></button>
                  </div>
                </div>
                <div class="cart-summary">
                  <small>3 Item(s) selected</small>
                  <h5>SUBTOTAL: $2940.00</h5>
                </div>
                <div class="cart-btns">
                  <a href="#">View Cart</a>
                  <a href="#">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
                </div>
              </div>
            </div>
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
  <%@ include file="../HTMLPages/Registration.html" %>
  <%@ include file="../HTMLPages/Footer.html" %> 