let txt = "";
let ResultDiv = document.getElementById("search-dropdown");
let Products_slider = document.getElementById("Products_slider_div");
let Laptop_toggle_tab = document.getElementById("Laptop_toggle_tab");
let Mobile_toggle_tab = document.getElementById("Mobile_toggle_tab");
(function ($) {

    $("#search_bar_id").keyup(function () {
        if ($(this).val() == '') return;
        console.log(`Showing Search Results for ${$(this).val()}`);
        var dataForm = "keyword=" + $(this).val();
        var request = $.ajax({
            url: '/ECommerce/SearchForProductsServlet', type: 'GET', processData: false, //contentType: "text/html",
            cache: false, data: dataForm
        });
        request.done(function (msg) {
            ResultDiv.innerHTML = "";
            txt = "";
            if (msg == '') {
            } else {
                var array = msg.split(";");
                array.forEach(myFunction);
                ResultDiv.innerHTML = txt;
                //alert(msg);
            }
        });

        function myFunction(value, index, array) {
            var elementArr = value.split(":");
            txt += `<div class="cart-list">
                                                <div class="product-widget">
                                                    <div class="product-img">
                                                        <img src="` + elementArr[2] + `" alt="">
                                                    </div>
                                                    <div class="product-body">
                                                        <h3 class="product-name"><a href="#">` + elementArr[1] + `</a></h3>
                                                   		<h4 class="product-price">` + elementArr[3] + `</h4>
                                                    </div>
                                                </div>
                                            </div>`
            return txt;
        }

        request.fail(function (jqXHR, textStatus) {
            ResultDiv.innerHTML = "";
            txt = "";
        });
    });
    ////////////////for mobile tab
    $("#Mobile_toggle_tab").mousedown(function (){tabFunction("Mobile")});
    $("#Laptop_toggle_tab").mousedown(function (){tabFunction("Laptop")});
    // $("#Mobile_toggle_tab").mousedown(tabFunction("Mobile"));
    // $("#Laptop_toggle_tab").mousedown(tabFunction("Laptop"));

    function tabFunction(type) {
        console.log("pressed"+type)
        var dataForm = "type=" + type;
        var request = $.ajax({
            url: '/ECommerce/FilterProducts', type: 'GET', processData: false, //contentType: "text/html",
            cache: false, data: dataForm
        });
        request.done(function (msg) {
            Products_slider.firstElementChild.firstElementChild.innerHTML = "";
            txt = "";
            if (msg == '') {
            } else {
                var array = msg.split(";");
                array.forEach(myFunction2);
          //      Products_slider.firstElementChild.firstElementChild.innerHTML = txt;
                //alert(msg);
            }
        });

        function myFunction2(value, index, array) {
            var elementArr = value.split(":");
            Products_slider.firstElementChild.firstElementChild.innerHTML += `
<div class="product "  >
                                            <div class="product-img">
                                                <img width="100px" height="250px" src=` + elementArr[2] + `>
                                                <div class="product-label">
                                                    <span class="sale">-30%</span>
                                                    <span class="new">NEW</span>
                                                </div>
                                            </div>
                                            <div class="product-body">
                                                <!--                                                    <input type="hidden" id="id" name="id" value="">-->
                                                <!--                                                    <p id="id" class="product-category"></p>-->
                                                <p class="product-category">` + elementArr[4] + `</p>
                                                <h3 class="product-name"><a href="#">` + elementArr[1] + `</a></h3>
                                                <h4 class="product-price">$` + elementArr[3] + ` <del class="product-old-price">$` + (parseInt(elementArr[3], 10) * 1.3) + `</del></h4>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">
                                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                </div>
                                            </div>
                                            <div class="add-to-cart">
                                                <button onclick="" id="addCart" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                            </div>
                                            </div>`
            return txt;
        }

        request.fail(function (jqXHR, textStatus) {
            Products_slider.firstElementChild.firstElementChild.innerHTML = "";
            txt = "";
        });
    };

})(jQuery);