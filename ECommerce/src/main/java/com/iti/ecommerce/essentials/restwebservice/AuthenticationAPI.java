package com.iti.ecommerce.essentials.restwebservice;

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
//    @Consumes("application/json")
    @Produces("application/json")
    public String verifyLogin(@FormParam("email") String email,
            @FormParam("password") String password)
            throws SQLException {
        DatabaseManagement DM = new DatabaseManagement();
        System.out.println(email);
        System.out.println(password);
        return DM.verfiyLoginForREST(email, password);
    }

    @PUT
    @Path("/Register")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces("application/json")
    public String RegisterData(
            @FormParam("first_name") String first_name,
            @FormParam("last_name") String last_name,
            @FormParam("dob") String dob,
            @FormParam("email") String email,
            @FormParam("password") String password,
            @FormParam("credit_limit") int credit_limit,
            @FormParam("address") String address,
            @FormParam("phone_number") String phone_number,
            @FormParam("interests") String interests
    ) throws SQLException, ParseException {
        String SDate = dob;
        java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(SDate);
        java.sql.Date DoB = new java.sql.Date(date.getTime());
        DatabaseManagement DM = new DatabaseManagement();
        System.out.println(email);
        System.out.println(password);
        String checkRegister = String.valueOf(DM.addCustomer(first_name, last_name, email, password, DoB, address, phone_number, interests, credit_limit));
        JSONObject json=new JSONObject();
        return json.put("register",checkRegister).toString();
    }
}
