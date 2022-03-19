/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import com.iti.ecommerce.essentials.dbconnection.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.iti.ecommerce.essentials.model.Customer;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author nour
 */
public class DatabaseManagement {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ArrayList<Customer> customers;
    ResultSet rs;

    public DatabaseManagement() {
        conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("database connection is null");
        }

    }

    public List<Customer> getCustomers() {
        customers = new ArrayList<Customer>();
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT first_name, last_name, dob, email, address, phone_number from users;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                Customer customer = new Customer(fname, lname, email, dob, address, phone);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public boolean addCustomer(String fname,String lname,String email,String Password,Date dob,String address,String phone,String interets,int creditLimit) throws SQLException
        {
            boolean isAdded =false; 
            try {
            String InsertStatement="insert into users(first_name,last_name,dob,email,password,credit_limit,address,phone_number,intersts)"
                                   + "VALUES(?,?,?,?,?,?,?,?,?)";
            pstmt=conn.prepareStatement(InsertStatement);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(3, email);
            pstmt.setString(4, Password);
            pstmt.setDate  (5, dob);
            pstmt.setString(6, address);
            pstmt.setString(7, phone);
            pstmt.setString(8, interets);
            pstmt.setInt   (9, creditLimit);
            int i=pstmt.executeUpdate();
            System.out.println(i+" records inserted"); 
            isAdded=true;
            } catch (SQLException e) {
             System.out.println(" Exception at adding new users in data base : "+e);
             isAdded=true;
            }
            return isAdded;
        }
}
