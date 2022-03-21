/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.verifications;

import java.util.regex.Pattern;
import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.iti.ecommerce.essentials.dbconnection.DatabaseConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Abdelrahman Mostafa
 * <Abdelrahman Mostafa at Information Technology Institute>
 */
public class Verfication {

    //methods to verfiy user inputs at the server 
    public static boolean RegistrationVerfied (String fname,String lname,String email,String Password,Date dob,String address,String phone,String interets,int creditLimit)
    {
        boolean condition =false;
        //verify mail before insert in database
        if (isvalidEmail(email))
           {
                condition=true;
           }
        else 
           {
             //tell the user that he already registered
           }
        //verify phone number
        
//////////////////////////////////////////////////////////
        DatabaseManagement DM =null;
        try {
               condition=DM.addCustomer(fname, lname, email, Password, dob, address, phone, interets, creditLimit);

        } catch (SQLException e) {
               System.out.println("exception at end of verfication"+e);
        }catch (NullPointerException ne) {
                System.out.println("null exception at end of verfication"+ne);
    }
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
        if (condition)
         {
            condition=isANEWEmail(email);
         }
        return condition;
    }
    private static boolean isANEWEmail(String email)
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
        return !isExist;
     }
    private static boolean isavalidPhone(String phone)
     {
        boolean condition=false;
        String regexPhone= "^01[0125][0-9]{8}$";
         
        if (!Pattern.matches(regexPhone, phone))
            {
                condition =true;
            }
        if (condition)
            {
                condition=isANEWphone(phone);
            }
        if (condition)
            {
                condition=isANEWphone(phone);
            }
        return condition;
     }
        private static boolean isANEWphone(String phone)
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
        return !isExist;
     }
      private static boolean isphoneauthenticated(String phone)
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
        return !isExist;
     }
}