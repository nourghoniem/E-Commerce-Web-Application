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
    @Path("/Login/{email}/{password}")
    @Consumes("application/json")
    @Produces("application/json")
    public String verifyLogin(@PathParam("email") String email,
            @PathParam("password") String password)
            throws SQLException {
        DatabaseManagement DM = new DatabaseManagement();
        System.out.println(email);
        System.out.println(password);
        return DM.verfiyLoginForREST(email, password);
    }

    @PUT
    @Path("/Register/{first_name}/{last_name}/{dob}/{email}/{password}/{credit_limit}/{address}/{phone_number}/{interests}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public String RegisterData(
            @PathParam("first_name") String first_name,
            @PathParam("last_name") String last_name,
            @PathParam("dob") String dob,
            @PathParam("email") String email,
            @PathParam("password") String password,
            @PathParam("credit_limit") int credit_limit,
            @PathParam("address") String address,
            @PathParam("phone_number") String phone_number,
            @PathParam("interests") String interests
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
