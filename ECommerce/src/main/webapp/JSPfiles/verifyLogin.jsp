<%-- 
    Document   : Login
    Created on : Mar 19, 2022, 12:39:29 AM
    Author     : a7med
--%>

<%@ include file="/JSPfiles/Header.jsp" %>

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
                <input type="hidden" id="status" value="<%=request.getParameter("status")%>">
		<!-- BREADCRUMB -->
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
		<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
		<script src="/ECommerce/JSPfiles/js/main2.js"></script>
        <!--===============================================================================================-->
                <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
                <script type="text/javascript">
                    var status = document.getElementById("status").value;
					console.log(status);
                    if (status === "failed"){
                       swal({
                           title: "Failed to Login",
                           text: "Wrong Email or Password"
                          
                     });  
                    }
                    if (status === "invalidEmail"){
                       swal({
                           title: "Failed to Login",
                           text: "Please Enter Email"
                          
                     });  
                    }
                    if (status === "invalidPassword"){
                       swal({
                           title: "Failed to Login",
                           text: "Please Enter Password"
                          
                     });  
                    }
               </script>
                

	</body>
</html>

