let txt = "";
let ResultDiv = document.getElementById("search-dropdown");
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
})(jQuery);