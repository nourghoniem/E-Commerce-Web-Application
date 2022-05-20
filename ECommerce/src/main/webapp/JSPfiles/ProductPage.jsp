<%@ page import="com.iti.ecommerce.essentials.model.Product" %>
<%@ page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement" %>
<%@ page import="java.util.List" %>
<%@ page import="com.iti.ecommerce.essentials.model.Review" %><%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 4/29/2022
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>

<%  int id=Integer.parseInt(request.getParameter("ID"));
    int CID=-1;
    System.out.println("session attribute id :"+session.getAttribute("id"));
    if (session.getAttribute("id")!=null){
        CID= (int)session.getAttribute("id");}
    DatabaseManagement DM=new DatabaseManagement();
    List<Product> products=DM.getProducts();
    Product product=DM.getProductById(id);
    List<Review> reviewList = DM.getProductRRList(id);
    int Product_id,Customer_id,year,month,day,hours,minutes,oneProductRating;
    String ReviewBody,Customer_name;
    String name, description, image_URL, product_type;
    Double price, oldPrice;
    Integer quantity,rating,reviews_Count;
    boolean inStock =true;
    name = product.getProduct_name();
    price = product.getPrice();
    oldPrice = price + (price * .02);
    quantity = product.getQuantity();
    description = product.getDescription();

    image_URL = "/ECommerce/db_images/" + id + ".jpg";
    product_type = product.getProduct_type();
    rating = DM.getProductRating(id);
    boolean canReview=DM.canReview(id,CID);
    //boolean canReview=true;
    reviews_Count=DM.getReviewCount(id);
    if (quantity > 0){
        inStock=true;
    }
    else if(quantity ==0){
        inStock=false;
    }
%>
<%@ include file="/JSPfiles/Header.jsp" %>

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- Product main img -->
            <div class="col-md-5 col-md-push-2">
                <div id="alreadyInCart" style="display:none;" class="alert alert-danger" role="alert">
                    Product already exists in your cart.
                </div>
                <div id="addedToCart" style="display:none;" class="alert alert-success" role="alert">
                    Product added to your cart.
                </div>
                <div id="product-main-img">
                    <div class="product-preview">
                        <img src="<%=image_URL%>" alt="">
                    </div>
                </div>
            </div>
            <!-- /Product main img -->

            <!-- Product thumb imgs -->
            <div class="col-md-2  col-md-pull-5">
                <div id="product-imgs">
                    <div class="product-preview">
                        <img src="<%=image_URL%>" alt="">
                    </div>
                </div>
            </div>
            <!-- /Product thumb imgs -->

            <!-- Product details -->
            <div class="col-md-5">
                <div class="product-details">
                    <h2 class="product-name"><%=name%></h2>
                    <div>
                        <div class="product-rating">
                            <% int i =rating;
                            while (i !=0){ %>
                            <i class="fa fa-star"></i>
                            <%i--;}%>
                            <% int j = 5-rating;
                            while (j != 0){ %>
                            <i class="fa fa-star-o"></i>
                            <%j--;}%>
                        </div>
                        <a class="review-link" href="#"><%=reviews_Count%> Review(s)</a>
                    </div>
                    <div>
                        <h3 class="product-price">$<%=price%> <del class="product-old-price">$<%=oldPrice%></del></h3>
                        <% if (inStock){%>
                        <span class="product-available">In Stock</span>
                        <%}else{%>
                        <span class="product-unavailable">Out of Stock</span>
                        <%}%>

                    </div>
                    <p> <%=description%></p>

                    <div class="add-to-cart">
                        <div class="qty-label">
                            Qty
                            <div class="input-number">
                                <input id="quantity_product" value="1" type="number">
                                <span class="qty-up">+</span>
                                <span class="qty-down">-</span>
                            </div>
                        </div>
                        <button onclick="myAlert(<%=id%>);" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                    </div>

                    <ul class="product-btns">
                        <li><a href="#"><i class="fa fa-heart-o"></i> add to wishlist</a></li>
                        <li><a href="#"><i class="fa fa-exchange"></i> add to compare</a></li>
                    </ul>

                    <ul class="product-links">
                        <li>Category:</li>
                        <li><a href="#">Headphones</a></li>
                        <li><a href="#">Accessories</a></li>
                    </ul>

                    <ul class="product-links">
                        <li>Share:</li>
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        <li><a href="#"><i class="fa fa-envelope"></i></a></li>
                    </ul>

                </div>
            </div>
            <!-- /Product details -->

            <!-- Product tab -->
            <div class="col-md-12">
                <div id="product-tab">
                    <!-- product tab nav -->
                    <ul class="tab-nav">
                        <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                        <li><a data-toggle="tab" href="#tab2">Details</a></li>
                        <li><a data-toggle="tab" href="#tab3">Reviews (<%=reviews_Count%>)</a></li>
                    </ul>
                    <!-- /product tab nav -->

                    <!-- product tab content -->
                    <div class="tab-content">
                        <!-- tab1  -->
                        <div id="tab1" class="tab-pane fade in active">
                            <div class="row">
                                <div class="col-md-12">
                                    <p> <%=description%></p>
                                </div>
                            </div>
                        </div>
                        <!-- /tab1  -->

                        <!-- tab2  -->
                        <div id="tab2" class="tab-pane fade in">
                            <div class="row">
                                <div class="col-md-12">
                                <p><%=description%></p>
                                </div>
                            </div>
                        </div>
                        <!-- /tab2  -->

                        <!-- tab3  -->
                        <div id="tab3" class="tab-pane fade in">
                            <div class="row">
                                <!-- Rating -->
                                <div class="col-md-3">
                                    <div id="rating">
                                        <div class="rating-avg">
                                            <span><%=rating%></span>
                                            <div class="rating-stars">
                                                <% i =rating;
                                                    while (i !=0){ %>
                                                <i class="fa fa-star"></i>
                                                <%i--;}%>
                                                <% j = 5-rating;
                                                    while (j != 0){ %>
                                                <i class="fa fa-star-o"></i>
                                                <%j--;}%>
                                            </div>
                                        </div>
                                        <ul class="rating">
                                            <li>
                                                <div class="rating-stars">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="rating-progress">
                                                    <div style="width: 80%;"></div>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="rating-stars">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star-o"></i>
                                                </div>
                                                <div class="rating-progress">
                                                    <div style="width: 60%;"></div>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="rating-stars">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star-o"></i>
                                                </div>
                                                <div class="rating-progress">
                                                    <div></div>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="rating-stars">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star-o"></i>
                                                </div>
                                                <div class="rating-progress">
                                                    <div></div>
                                                </div>

                                            </li>
                                            <li>
                                                <div class="rating-stars">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star-o"></i>
                                                    <i class="fa fa-star-o"></i>
                                                </div>
                                                <div class="rating-progress">
                                                    <div></div>
                                                </div>

                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- /Rating -->

                                <!-- Reviews -->
                                <div class="col-md-6">
                                    <div id="reviews">
                                        <ul class="reviews">
                                            <% i =reviews_Count;
                                            if (reviewList != null){
                                                for (Review review : reviewList){
                                                            Product_id=review.getProduct_id();
                                                            Customer_id=review.getCustomer_id();
                                                            Customer_name=review.getCustomer_name();
                                                            year=review.getYear();
                                                            month=review.getMonth();
                                                            day=review.getDay();
                                                            hours=review.getHours();
                                                            minutes=review.getMinutes();
                                                            oneProductRating=review.getRating();
                                                            ReviewBody=review.getReview();
                                            %>
                                            <li>
                                                <div class="review-heading">
                                                    <h5 class="name"><%=Customer_name%></h5>
                                                    <p class="date"><%=year%> <%=month%> <%=day%>, <%=hours%>:<%=minutes%></p>
                                                    <div class="review-rating">
                                                        <% i = oneProductRating;
                                                            while (i!=0){
                                                        %>
                                                        <i class="fa fa-star"></i>
                                                        <%i--;}%>
                                                        <% i = 5 - oneProductRating;
                                                            while (i!=0){
                                                        %>
                                                        <i class="fa fa-star-o empty"></i>
                                                        <%i--;}%>
                                                    </div>
                                                </div>
                                                <div class="review-body">
                                                    <p><%=ReviewBody%></p>
                                                </div>
                                            </li>
                                            <%
                                                }}
                                            %>

                                        </ul>
                                        <ul class="reviews-pagination">
                                            <li class="active">1</li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li><a href="#">4</a></li>
                                            <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- /Reviews -->
                                <% String condition=""; String style="style=\"display:none;\"";%>
                                <% if (!canReview){  condition="disabled";  style="";}%>
                                <!-- Review Form -->
                                <div class="col-md-3">
                                    <div id="addedReview" style="display:none;" class="alert alert-success" role="alert">
                                        Product Review is submitted.
                                    </div>
                                    <div <%=style%>  class="alert alert-danger" role="alert">
                                        You should Sign in and buy the product to be able to submit a review.
                                    </div>
                                    <div id="review-form">
                                        <form class="review-form">
                                            <input <%=condition%> id="" class="input" type="text" placeholder="Your Name">
                                            <input <%=condition%> class="input" type="email" placeholder="Your Email">
                                            <textarea <%=condition%> id="review_id" class="input" placeholder="Your Review"></textarea>
                                            <div class="input-rating">
                                                <span>Your Rating: </span>
                                                <div class="stars">
                                                    <input <%=condition%> id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
                                                    <input <%=condition%> id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
                                                    <input <%=condition%> id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
                                                    <input <%=condition%> id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
                                                    <input <%=condition%> id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
                                                </div>
                                            </div>
                                            <button <%=condition%> onclick="Review(<%=id%>, <%=CID%>);" class="primary-btn" type="button">Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /tab3  -->
                    </div>
                    <!-- /product tab content  -->
                </div>
            </div>
            <!-- /product tab -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- Section -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <div class="col-md-12">
                <div class="section-title text-center">
                    <h3 class="title">Related Products</h3>
                </div>
            </div>
            <% for (Product product2 : products) {

                name = product2.getProduct_name();
                price = product2.getPrice();
                oldPrice = price + (price * .02);
                quantity = product2.getQuantity();
                description = product2.getDescription();
                id = product2.getId();
                image_URL = "../db_images/" + id + ".jpg";
                product_type = product2.getProduct_type();


            %>
            <!-- product -->
            <div class="col-md-3 col-xs-6">
                <div class="product">
                    <div class="product-img">
                        <img src="<%=image_URL%>" alt="">
                        <div class="product-label">
                            <span class="sale">-30%</span>
                        </div>
                    </div>
                    <div class="product-body">
                        <p class="product-category"><%=product_type%></p>
                        <h3 class="product-name"><a href="#"><%=name%></a></h3>
                        <h4 class="product-price">$<%=price%> <del class="product-old-price">$<%=oldPrice%></del></h4>
                        <div class="product-rating">
                        </div>
                        <div class="product-btns">
                            <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                            <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                            <button  onclick="location.href = '<%=request.getContextPath() %>'+'/JSPfiles/ProductPage.jsp?ID=<%=id%>'" class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                        </div>
                    </div>
                    <div class="add-to-cart">
                        <button onclick="myAlert(<%=id%>);" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                    </div>
                </div>
            </div>
            <!-- /product -->
            <%}%>

        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /Section -->

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
        var  quantity = $("#quantity_product").val();
        if(quantity === ""){
            quantity = 1;
        }
//
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/addToCart",
            data: {
                id: id,
                quantity: quantity
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
    function Review(Pid,  Cid)
    {
        var product_id=Pid;
        var customer_id=Cid;
        var review=document.getElementById("review_id").value;

        var year=new Date().getFullYear();
        var month=new Date().getMonth();
        var day= new Date().getDay();
        var hours=new Date().getHours();
        var minutes=new Date().getMinutes();
        var rating=document.querySelector('input[name="rating"]:checked').value ;
        console.log(review);
        if (review != ""){
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/SubmitAReview",
            data: {
                product_id:product_id,
                customer_id:customer_id,
                review:review,
                year:year,
                month:month,
                day: day,
                hours:hours ,
                minutes: minutes,
                rating:rating
            },

            success: function (data) {
                var result = $.trim(data);
                if (result === "added") {
                    $("#addedReview").show();
                    setTimeout(function () {
                        $("#addedReview").hide();
                    }, 2000);

                }
                else{
                    alert(data);
                }

            },
            error: function (resp) {
                alert("Error");
            }
        });}
    }
</script>
</body>
</html>
