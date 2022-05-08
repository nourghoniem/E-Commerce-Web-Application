<%-- 
    Document   : edit_user
    Created on : Apr 29, 2022, 11:05:06 PM
    Author     : Aya Mostafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../HTMLPages/Header.html" %>
<%@page import="com.iti.ecommerce.essentials.model.Customer"%>
<%@page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement"%>

<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    DatabaseManagement data = new DatabaseManagement();
    Customer getCustomer = data.getCustomerById(id);
%>

<!DOCTYPE html>
<html>
    <body>

                                <div class="panel-body">

                                    <form id="form1" action="" method= "POST">
                                        <div class="col-md-12 col-sm-12">

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="name"> Product Name  </label>
                                                <input type="text" class="form-control input-sm" id="form-name" required="" name="address" value="<% out.println(getCustomer.getEmail()); %>" placeholder="">
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="description">Description</label>
                                                <input type="text" class="form-control input-sm" id="form-description" required="" name="phone_number" value="<% out.println(getCustomer.getCredit_limit()); %>" placeholder="" >
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="quantity"> Quantity </label>
                                                <input type="text" class="form-control input-sm" id="form-quantity" required="" name="email" value="<% out.println(getCustomer.getPhone_number()); %>
                                                       " placeholder="" >
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="price"> Price </label>
                                                <input type="text" class="form-control input-sm" id="form-price" required="" name="credit_limit" value="<% out.println(getCustomer.getAddress()); %>">
                                            </div>
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group col-md-3 col-sm-3 pull-right" >
                                                    <button type="button" class="btn btn-primary">
                                                        Edit
                                                    </button>
                                                    <button type="button" class="btn btn-danger">
                                                        Delete
                                                    </button>
                                                </div>
                                            </div>

                                        </div>

                                    </form>    
                                </div>
                                
                                <script>
                                    $(document).ready(function () {
                                        $("#edit_user_submit").click(function (event) {
                                            event.preventDefault();
                                            var regex = /^(\+|-)?(\d*\.?\d*)$/;
                                            var id = $('#id').val();
                                            var address = $('#address').val();
                                            var phone_number = $('#phone_number').val();
                                            var email = $('#email').val();
                                            var credit_limit = $('#credit_limit').val();
                                            
                                              $.ajax({
                                                    type: "POST",
                                                    url: "${pageContext.request.contextPath}/edit_infoServlet",
                                                    data: {
                                                        id: id,
                                                        address:address,
                                                        phone_number: phone_number,
                                                        email: email,
                                                        credit_limit: credit_limit
                                                    },
                                                    success: function (data) {
                                                        $('#success-message').show();
                                                        $("#edit_user_submit").prop("disabled", true);
                                                        setTimeout(function () {

                                                            $('#editStaffModal.modal.fade.show').hide();
                                                            $('body').removeClass('modal-open');
                                                            $('.modal-backdrop').remove();
                                                        }, 2000);
                                                    },
                                                    error: function (resp) {
                                                        console.log(resp);
                                                    }
                                                });
                                            }
                                        });
                                        $(document).ajaxStop(function () {
                                            window.location.reload();
                                        });



                                    }
                                    );

                                    );

                                </script>
                                            

    </body>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
                                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
<%@ include file="../HTMLPages/Footer.html" %> 