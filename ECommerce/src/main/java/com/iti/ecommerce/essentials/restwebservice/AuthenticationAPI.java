package com.iti.ecommerce.essentials.restwebservice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/AuthenticationAPI")
public class AuthenticationAPI {

    @POST
    @Path("/Login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String verifyLogin(String credintials)
            throws SQLException {
        DatabaseManagement DM = new DatabaseManagement();
        Gson gson = new Gson();
       CredentialsForLogin Clogin=gson.fromJson(credintials,CredentialsForLogin.class);
        System.out.println(Clogin.email);
        System.out.println(Clogin.password);
        return DM.verfiyLoginForREST(Clogin.email, Clogin.password);
    }

    @PUT
    @Path("/Register")
  //  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public String RegisterData(
         String Credentials
    ) throws SQLException, ParseException {
        DatabaseManagement DM = new DatabaseManagement();
        Gson gson = new Gson();
        CredentialsForRegistration CRegister = gson.fromJson(Credentials, CredentialsForRegistration.class);
        System.out.println(CRegister.email);
      //  System.out.println(password);
        String checkRegister = String.valueOf(DM.addCustomer(CRegister.first_name, CRegister.last_name, CRegister.email, CRegister.password, CRegister.dob, CRegister.address, CRegister.phone_number, CRegister.interests, CRegister.credit_limit));
        JSONObject json=new JSONObject();
        return json.put("register",checkRegister).toString();
    }
}
class CredentialsForLogin {
    String email;
    String password;

    public CredentialsForLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
    class  CredentialsForRegistration{
        String first_name;
        String last_name;
        java.sql.Date dob;
        String Date_of_birth;
        String email;
        String password;
        int credit_limit;
        String address;
        String phone_number;
        String interests;

        public CredentialsForRegistration(String first_name, String last_name, String dob, String email, String password, int credit_limit, String address, String phone_number, String interests) throws ParseException {

            this.first_name = first_name;
            this.last_name = last_name;
      //      this.dob = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(dob).getTime());

            this.Date_of_birth=dob;
            this.email = email;
            this.password = password;
            this.credit_limit = credit_limit;
            this.address = address;
            this.phone_number = phone_number;
            this.interests = interests;

            this.dob= new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(dob).getTime());

        }
    }
