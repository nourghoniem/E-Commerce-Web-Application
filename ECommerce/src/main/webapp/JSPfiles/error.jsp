<%@ page import="com.iti.ecommerce.essentials.model.Product" %>
<%@ page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/29/2022
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/JSPfiles/Header.jsp" %>
<a class="errorpage" >
    <header class="top-header">
    </header>

    <!--dust particel-->
    <div>
        <div class="starsec"></div>
        <div class="starthird"></div>
        <div class="starfourth"></div>
        <div class="starfifth"></div>
    </div>
    <!--Dust particle end--->


    <div class="lamp__wrap">
        <div class="lamp">
            <div class="cable"></div>
            <div class="cover"></div>
            <div class="in-cover">
                <div class="bulb"></div>
            </div>
            <div class="light"></div>
        </div>
    </div>
    <!-- END Lamp -->
    <section class="error">
        <!-- Content -->
        <div class="error__content">
            <div class="error__message message">
                <h1 class="message__title">Page Not Found</h1>
                <p class="message__text">We're sorry, the page you were looking for isn't found here. The link you followed may either be broken or no longer exists. Please try again</p>
            </div>

        </div>
        <!-- END Content -->

    </section>

</a>
<!-- NEWSLETTER -->
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="Enter Your Email">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /NEWSLETTER -->

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
<script src="/ECommerce/JSPfiles/js/newSearchScript.js"></script>
<script>
    function myAlert(my_id)
    {
        var id = my_id;
//
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart",
            data: {
                id: id
            },

            success: function (data) {
                var result = $.trim(data);
                if (result === "exists") {
                    $("#alreadyInCart").show();
                    setTimeout(function () {
                        $("#alreadyInCart").hide();
                    }, 2000);


                } else if (result === "added") {
                    $("#addedToCart").show();
                    setTimeout(function () {
                        $("#addedToCart").hide();
                    }, 2000);

                }
                else{
                    alert(data);
                }

            },
            error: function (resp) {
                alert("Error");
            }
        });
    }
</script>
<script>
    function Review(my_id)
    {
        var id = my_id;
//
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart",
            data: {
                id: id
            },

            success: function (data) {
                var result = $.trim(data);
                if (result === "exists") {
                    $("#alreadyInCart").show();
                    setTimeout(function () {
                        $("#alreadyInCart").hide();
                    }, 2000);


                } else if (result === "added") {
                    $("#addedToCart").show();
                    setTimeout(function () {
                        $("#addedToCart").hide();
                    }, 2000);

                }
                else{
                    alert(data);
                }

            },
            error: function (resp) {
                alert("Error");
            }
        });
    }
</script>
</body>
</html>
