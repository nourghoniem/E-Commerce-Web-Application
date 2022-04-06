/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.verifications;

import java.util.regex.Pattern;
import com.iti.dbconnection.DatabaseManagement;
import java.sql.Date;
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
        //verfiy mail phone before insert in database
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
        return condition;
    }
}