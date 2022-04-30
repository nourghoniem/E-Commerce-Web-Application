let txt = "";
let ResultDiv = document.getElementById("search-dropdown");
let Products_slider = document.getElementById("ProductsDivId");
let Gtype="";
const priceInput = document.querySelectorAll(".price-input");
var  Min_Price_id=document.getElementById("price-min");
var Max_Price_id=document.getElementById("price-max");

(function ($) {

    $("#search_bar_id").keyup(function () {
        if ($(this).val() == ''){ txt='';ResultDiv.innerHTML = txt; return;}
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
            //    ResultDiv.removeAttribute("class");
                ResultDiv.innerHTML = txt;
             //   ResultDiv.classList.add("products-slick slick-initialized slick-slider");
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
                                                        <h3 class="product-name"><a href="../JSPfiles/ProductPage.jsp?ID=`+elementArr[0]+`">` + elementArr[1] + `</a></h3>
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
    $("#SmartphonesCheckbox").mousedown(function (){console.log("SmartphonesCheckbox");tabFunction("Mobile",Min_Price_id.value,Max_Price_id.value)});
    $("#LaptopsCheckbox").mousedown(function (){console.log("LaptopsCheckbox");tabFunction("Laptop",Min_Price_id.value,Max_Price_id.value)});
    $("#AllcategoryCheckbox").mousedown(function (){console.log("AllcategoryCheckbox");tabFunction("",Min_Price_id.value,Max_Price_id.value)});

    // $("#Mobile_toggle_tab").mousedown(tabFunction("Mobile"));
    // $("#Laptop_toggle_tab").mousedown(tabFunction("Laptop"));

    function tabFunction(type,Min,Max) {
        Gtype=type;

        var dataForm = "type=" + type+"&Min="+Min+"&Max="+Max;
        var request = $.ajax({
            url: '/ECommerce/FilterProducts', type: 'GET', processData: false, //contentType: "text/html",
            cache: false, data: dataForm
        });
        request.done(function (msg) {
            Products_slider.innerHTML = "";
            txt = "";
            if (msg == '') {
            } else {
                var array = msg.split(";");
                array.forEach(myFunction2);
                //     $('#Products_slider_div').html(txt);
                var Header= `<div id="alreadyInCart" style="display:none;" class="alert alert-danger" role="alert">
                                        Product already exists in your cart.
                                    </div>
                                    <div id="addedToCart" style="display:none;" class="alert alert-success" role="alert">
                                        Product added to your cart.
                                    </div>  `;
                var trailer=``;
                Products_slider.innerHTML = Header+txt+trailer;
                //alert(msg);
            }
        });

        function myFunction2(value, index, array) {
            var elementArr = value.split(":");
            txt += `
<div class="col-md-4 col-xs-6">
                        <div class="product">
                            <div class="product-img">
                                <img src="` + elementArr[2] + `" alt="">
                                <div class="product-label">
                                    <span class="sale">-30%</span>
                                    <span class="new">NEW</span>
                                </div>
                            </div>
                            <div class="product-body">
                                <p class="product-category">` + elementArr[4] + `</p>
                                <h3 class="product-name"><a href="#">` + elementArr[1] +`</a></h3>
                                <h4 class="product-price">$`+ elementArr[3] +`  <del class="product-old-price">$`+ (parseInt(elementArr[3], 10) * 1.3) + `</del></h4>
                                <div class="product-rating">
                                    
                                    <i class="fa fa-star"></i>
                                    

                                </div>
                                <div class="product-btns">
                                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                </div>
                            </div>
                            <div class="add-to-cart">
                                           <button onclick="myAlert(`+elementArr[0]+`);" id="addCart" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                            </div>
                        </div>
                    </div>    
                           `
            return txt;
        }

        request.fail(function (jqXHR, textStatus) {
            Products_slider.innerHTML = `<h3> sorry we couldn't find any products</h3>`;
            txt = "";
        });
    };
// $(document).ajaxStop(function (){
//     console.log("ajax has finished query");
//     $("tab1").contentWindow.location.reload();
// });
//
    Min_Price_id.addEventListener("input", e => {
        filterPrice()
    });
    Max_Price_id.addEventListener("input", e => {
        filterPrice()
    });
function filterPrice(){
    let minPrice = parseInt(Min_Price_id.value),
        maxPrice = parseInt(Max_Price_id.value);
    if (minPrice > maxPrice) {
        Min_Price_id.value = maxPrice;
        minPrice = parseInt(Min_Price_id.value);
        maxPrice = parseInt(Max_Price_id.value);
    }
    if (isNaN(minPrice)||minPrice==0 || minPrice<0 ){

        minPrice = 0;
        maxPrice = parseInt(Max_Price_id.value);
    }
    if (isNaN(maxPrice)||maxPrice==0 || maxPrice<0 ){

        minPrice = parseInt(Min_Price_id.value);
        maxPrice = 99999;
    }
    if (minPrice > maxPrice) {

        minPrice = parseInt(Min_Price_id.value);
        maxPrice = minPrice;
    }

    tabFunction(Gtype,minPrice,maxPrice);
}

})(jQuery);