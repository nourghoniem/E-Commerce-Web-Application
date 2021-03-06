/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.verifications;

import com.iti.ecommerce.essentials.dbconnection.DatabaseConnection;
import java.util.regex.Pattern;
import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
/**
 *
 * @author Abdelrahman Mostafa
 * <Abdelrahman Mostafa at Information Technology Institute>
 */
public class Verfication {
   static String ACCOUNT_SID , AUTH_TOKEN;
    //methods to verfiy user inputs at the server 
    public static boolean RegistrationVerfied (String fname,String lname,String email,String Password,Date Dob,String address,String phone,String interets,int creditLimit)
    {
        boolean condition =true;
        //verify mail before insert in database
        condition =isvalidEmail(email);
        System.out.print("email codition "+condition);
        condition =isavalidPhone(phone);
        System.out.print("phone codition "+condition);
        if (!condition){
//////////////////////////////////////////////////////////
 System.out.print("email codition "+condition);
        DatabaseManagement DM =new DatabaseManagement();
        try {
               condition=DM.addCustomer(fname, lname, email, Password, Dob, address, phone, interets, creditLimit);

        } catch (SQLException e) {
               System.out.println("exception at end of verfication"+e);
        }catch (NullPointerException ne) {
                System.out.println("null exception at end of verfication"+ne);
    }}
        return condition;
    }
    //method to verify the email address of the user 
    public static boolean isvalidEmail(String email)
    {
        boolean condition=false;
        String regexMail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        
        if (!Pattern.matches(regexMail, email))
            {
                condition =true;
            }

        return condition;
    }
    public static boolean isANEWEmail(String email)
     {
        boolean isExist=false;
        try {
           PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM users WHERE email=?");
           pstmt.setString(1, email);
           ResultSet rs = pstmt.executeQuery();
           isExist = rs.next();
           System.out.println("is exist "+isExist);
            }catch(SQLException SE){
                System.out.println("there is a exception at retrieving mail"+SE);
            }
        return isExist; 
     }
    public static boolean isavalidPhone(String phone)
     {
        boolean condition=false;
        String regexPhone= "^01[0125][0-9]{8}$";
         
        if (!Pattern.matches(regexPhone, phone))
            {
                condition =true;
            }

        return condition;
     }
        public static boolean isANEWphone(String phone)
     {
        boolean isExist=false;
        try {
           PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM users WHERE phone_number=?");
           pstmt.setString(1, phone);
           ResultSet rs = pstmt.executeQuery();
           isExist = rs.next();
           System.out.println("is exist "+isExist);
            }catch(SQLException SE){
                System.out.println("there is a exception at retrieving phone "+SE);
            }
        return isExist;
     }
      public static boolean isphoneauthenticated(String phone, String method,int Random ,String ACCOUNT_SID,String AUTH_TOKEN)
     {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        boolean isAuth=false;
         switch (method) {
             case "call":
               Call call = Call.creator(new PhoneNumber("+2"+phone),
               new PhoneNumber("+15139404907"),
               new com.twilio.type.Twiml("<Response><Say loop=\"3\">your code is"+Random+"</Say></Response>")).create();
               System.out.println(call.getSid());
                 break;
             case "sms":
                Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+2"+phone),
                new com.twilio.type.PhoneNumber("+15139404907"),
              //  "Your code for registration at electro. is"+ Random).create(); 
               String.valueOf(Random)).create(); 
                 break;
             default:
                 throw new AssertionError();
         }
        return isAuth;
     }

     public static void sendSMSAfterCheckout(String phone,String smsbody){
         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message message = Message.creator(
                 new com.twilio.type.PhoneNumber("+2"+phone),
                 new com.twilio.type.PhoneNumber("+15139404907"),
                  smsbody).create();
     }
    public static void setTwillioParams(String SID ,String TOKEN){
        ACCOUNT_SID =SID;
       AUTH_TOKEN =TOKEN;
    }
}