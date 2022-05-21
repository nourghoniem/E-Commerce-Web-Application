<%@page import="java.util.ArrayList"%>
<%@page import="com.iti.ecommerce.essentials.model.Cart"%>
<%@ page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement" %>
<%@ page import="com.iti.ecommerce.essentials.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/29/2022
  Time: 4:37 AM
  To change this template use File | Settings | File Templates.
--%>

<% DatabaseManagement DM = new DatabaseManagement();%>
<%
    List<Product> Allproducts = null;
    if (request.getParameter("q") == null) {
        Allproducts = DM.getProducts("0", "999999");
    } else {
        Allproducts = DM.getProductsForMainSearch(request.getParameter("q"));
    }
%>
<% List<Product> Laptops = DM.getProducts("Laptop", "0", "999999");%>
<% List<Product> Mobile = DM.getProducts("Mobile", "0", "999999");%>
<%  String name, description, image_URL, product_type, visibility, show;
    Double price, oldPrice;
    Integer quantity, id, Rating;
//    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
//    String check;
//    if (cart_list != null) {
//        check = "notnull";
//    } else {
//        check = "null";
//    }

%>
<%@ include file="/JSPfiles/Header.jsp" %>

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#">Laptops</a></li>
                <li><a href="#">Smartphones</a></li>
            </ul>
            <!-- /NAV -->
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- ASIDE -->
            <div id="aside" class="col-md-3">
                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">Categories</h3>
                    <div class="checkbox-filter">

                        <div class="input-checkbox">
                            <input name="input" type="radio" id="Laptops">
                            <label id="LaptopsCheckbox" for="Laptops">
                                <span></span>
                                Laptops
                                <small>(120)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input name="input" type="radio" id="Smartphones">
                            <label id="SmartphonesCheckbox" for="Smartphones">
                                <span></span>
                                Smartphones
                                <small>(740)</small>
                            </label>
                        </div>

                        <div class="input-checkbox">
                            <input name="input" type="radio" checked id="Allcategory">
                            <label id="AllcategoryCheckbox" for="Allcategory">
                                <span></span>
                                All Categories
                                <small>(1450)</small>
                            </label>
                        </div>

                    </div>
                </div>
                <!-- /aside Widget -->

                <!-- aside Widget -->
                <div class="aside">
                    <h3 class="aside-title">Price</h3>
                    <div class="price-filter">
                        <div id="price-slider"></div>
                        <div class="input-number price-min">
                            <input id="price-min" type="number">
                            <span class="qty-up">+</span>
                            <span class="qty-down">-</span>
                        </div>
                        <span>-</span>
                        <div class="input-number price-max">
                            <input id="price-max" type="number">
                            <span class="qty-up">+</span>
                            <span class="qty-down">-</span>
                        </div>
                    </div>
                </div>
                <!-- /aside Widget -->

            </div>
            <!-- /ASIDE -->

            <!-- STORE -->
            <div id="store" class="col-md-9">
                <!-- store products -->
                <div id ="ProductsDivId" class="row">
                    <div id="alreadyInCart" style="display:none;" class="alert alert-danger" role="alert">
                        Product already exists in your cart.
                    </div>
                    <div id="addedToCart" style="display:none;" class="alert alert-success" role="alert">
                        Product added to your cart.
                    </div>
                    <!-- product -->

                    <% for (Product product : Allproducts) {

                            name = product.getProduct_name();
                            price = product.getPrice();
                            oldPrice = price + (price * .02);
                            quantity = product.getQuantity();
                            description = product.getDescription();
                            id = product.getId();
                            image_URL = "/ECommerce/db_images/" + id + ".jpg";
                            product_type = product.getProduct_type();
                            Rating = DM.getProductRating(id);


                    %>
                    <div class="col-md-4 col-xs-6">
                        <div class="product">
                            <div class="product-img">
                                <img src="<%=image_URL%>" alt="">
                                <div class="product-label">
                                    <span class="sale">-30%</span>
                                    <span class="new">NEW</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <input id="quantity_product" value="1" style="display:none;">
                                <p class="product-category"><%=product_type%></p>
                                <h3 class="product-name"><a href="#"><%=name%></a></h3>
                                <h4 class="product-price">$<%=price%>  <del class="product-old-price">$<%=oldPrice%></del></h4>
                                <div class="product-rating">
                                    <% while (Rating != 0) {%>
                                    <i class="fa fa-star"></i>
                                    <% Rating--;
                                        }%>

                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                    <button  onclick="location.href = '<%=request.getContextPath()%>' + '/JSPfiles/ProductPage.jsp?ID=<%=id%>'" class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                <button onclick="myAlert(<%=id%>);" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>
                    <%}%>

                    <!-- /product -->

                </div>
                <!-- /store products -->

                <!-- store bottom filter -->
                <div class="store-filter clearfix">
                    <span class="store-qty">Showing 20-100 products</span>
                    <ul class="store-pagination">
                        <li class="active">1</li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                    </ul>
                </div>
                <!-- /store bottom filter -->
            </div>
            <!-- /STORE -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

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
                                var cart_size;
                                var quantity = $("#quantity_product").val();
                                if (quantity === "") {
                                    quantity = 1;
                                }
                                $.ajax({
                                    type: "POST",
                                    url: "${pageContext.request.contextPath}/addToCart",
                                    data: {
                                        id: id,
                                        quantity: quantity
                                    },

                                    success: function (data) {

                                        var results = data.split(',');
                                        var result = $.trim(results[0]);
                                        cart_size = results[1];
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


                                    },
                                    error: function (resp) {
                                        alert("Error");
                                    }

                                });

                                $(document).ajaxStop(function () {
                                    if (cart_size !== "") {
                                        $("#quantity_cart").html(cart_size);
                                        $("#quantity_cart").show();
                                        $("#cart_dropdown").show();

                                    }
                                });





                            }


</script>

</body>
</html>
