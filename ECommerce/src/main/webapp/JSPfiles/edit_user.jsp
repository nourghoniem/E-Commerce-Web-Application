<%-- 
    Document   : edit_user
    Created on : Apr 29, 2022, 11:05:06 PM
    Author     : Aya Mostafa
--%>

<%@page import="com.iti.ecommerce.essentials.model.Customer"%>
<%@page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement"%>

<%
  //  Integer id = Integer.parseInt(request.getParameter("id"));
    String email ="",address="",phone_number="",first_name="",last_name="",dob="";
    int credit_limit=0 ;
    Integer id =-1;
    if (session.getAttribute("id")!= null) {
        id = (int) session.getAttribute("id");
    }
    if (id!=-1) {
        DatabaseManagement data = new DatabaseManagement();
        Customer customer = data.getCustomer(id);
        email= customer.getEmail();
        address=customer.getAddress();
        phone_number=customer.getPhone_number();
        credit_limit=customer.getCredit_limit();
        first_name = customer.getFirst_name();
        last_name = customer.getLast_name();
    }



%>
<%@ include file="/JSPfiles/Header.jsp" %>
    <body>

                                <div class="panel-body">

                                    <form id="form1" action="" method= "POST">
                                        <div class="col-md-12 col-sm-12">

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="fname">  first Name  </label>
                                                <input type="text" class="form-control input-sm" id="fname" required="" value="<%=first_name%>" placeholder="">
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="lname">last name</label>
                                                <input type="text" class="form-control input-sm" id="lname" required="" value="<%= last_name%>" placeholder="" >
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="email">email</label>
                                                <input type="text" class="form-control input-sm" id="email" required="" value="<%= email%>" placeholder="" >
                                            </div>
                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="address"> address </label>
                                                <input type="text" class="form-control input-sm" id="address" required="" value="<%=address %>
                                                       " placeholder="" >
                                            </div>

                                            <div class="form-group col-md-6 col-sm-6">
                                                <label for="credit_limit"> credit limit </label>
                                                <input type="text" class="form-control input-sm" id="credit_limit" required=""  value="<%=credit_limit%>">
                                            </div>
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group col-md-3 col-sm-3 pull-right" >
                                                    <button onclick="editUserFn(<%=id%>);" type="button"  class="btn btn-primary">
                                                        Edit
                                                    </button>

                                                </div>
                                            </div>

                                        </div>

                                    </form>    
                                </div>
                                
                                <script>

                                       function editUserFn(ID){
                                           var id = ID;
                                           var address = $('#address').val();
                                            var fname =$('#fname').val();
                                           var lname =$('#lname').val();
                                           var email = $('#email').val();
                                           var credit_limit = $('#credit_limit').val();
                                            console.log($('#credit_limit'));
                                           console.log($('#credit_limit').val());
                                              $.ajax({
                                                    type: "POST",
                                                    url: "${pageContext.request.contextPath}/edit_infoServlet",
                                                    data: {
                                                       id: id,
                                                       address:address,
                                                       email: email,
                                                      credit_limit: credit_limit,
                                                        fname:fname,
                                                        lname:lname
                                                    },
                                                    success: function (data) {
                                                       alert("success");
                                                       //  $('#success-message').show();
                                                       //  $("#edit_user_submit").prop("disabled", true);
                                                       //  setTimeout(function () {
                                                       //
                                                       //      $('#editStaffModal.modal.fade.show').hide();
                                                       //      $('body').removeClass('modal-open');
                                                       //      $('.modal-backdrop').remove();
                                                       //  }, 2000);
                                                    },
                                                    error: function (resp) {
                                                        alert("error");
                                                    }
                                                });

                                        }
                                        // $(document).ajaxStop(function () {
                                        //     window.location.reload();
                                        // });






                                </script>
                                            

    </body>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
                                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</html>
<%@ include file="../HTMLPages/Footer.html" %> 