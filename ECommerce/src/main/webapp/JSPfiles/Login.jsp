
<%-- 
    Document   : registration
    Created on : Mar 19, 2022, 1:15:02 PM
    Author     : Abdelrahman Mostafa <Abdelrahman Mostafa at Information Technology Institute>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Login</title>

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

    <link rel="stylesheet" href="alert/dist/sweetalert.css">

    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
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
    <!--===============================================================================================-->
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
                        <form>
                            <select class="input-select">
                                <option value="0">All Categories</option>
                                <option value="1">Category 01</option>
                                <option value="1">Category 02</option>
                            </select>
                            <input class="input" placeholder="Search here">
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->


            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->

            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- BREADCRUMB -->
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
<div id="breadcrumb" class="section">
    <!-- container -->

    <div class="container">
        <!-- row -->
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-t-50 p-b-90">
                    <form class="login100-form validate-form flex-sb flex-w" method="post" action="/ECommerce/Login"  >
								<span class="login100-form-title p-b-51">
									Login
								</span>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Email is required">
                            <input class="input100" type="text" name="email" placeholder="Email">
                            <span class="focus-input100"></span>
                        </div>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="flex-sb-m w-full p-t-3 p-b-24">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                                <label class="label-checkbox100" for="ckb1">
                                    Remember me
                                </label>
                            </div>

                            <div>
                                <a href="#" class="txt1">
                                    Forgot?
                                </a>
                            </div>
                        </div>

                        <div class="container-login100-form-btn m-t-17">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </div>
    <!-- /container -->
</div>
<!-- /BREADCRUMB -->





<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links">
                            <li><a href="#">Hot deals</a></li>
                            <li><a href="#">Laptops</a></li>
                            <li><a href="#">Smartphones</a></li>
                            <li><a href="#">Cameras</a></li>
                            <li><a href="#">Accessories</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>


                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="/ECommerce/JSPfiles/js/jquery.min.js"></script>
<script src="/ECommerce/JSPfiles/js/bootstrap.min.js"></script>
<script src="/ECommerce/JSPfiles/js/slick.min.js"></script>
<script src="/ECommerce/JSPfiles/js/nouislider.min.js"></script>
<script src="/ECommerce/JSPfiles/js/jquery.zoom.min.js"></script>
<script src="/ECommerce/JSPfiles/js/main.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/vendor/bootstrap/js/popper.js"></script>
<script src="/ECommerce/JSPfiles/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/vendor/daterangepicker/moment.min.js"></script>
<script src="/ECommerce/JSPfiles/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/ECommerce/JSPfiles/js/main2.js"></script>
<!--===============================================================================================-->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
    var status = document.getElementById("status").value;
    if (status === "failed"){
        swal("Sorry" , "Wrong Username Or Password" , "failed");
    }
</script>


</body>
</html>
