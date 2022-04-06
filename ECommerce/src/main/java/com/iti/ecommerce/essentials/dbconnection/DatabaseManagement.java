/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.iti.ecommerce.essentials.model.Product;
import com.iti.ecommerce.essentials.model.Customer;
import java.io.File;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author nour
 */
public class DatabaseManagement {

    public static String AbsolutePath = new File("").getAbsolutePath();

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ArrayList<Customer> customers;
    ArrayList<Product> products;
    ResultSet rs;
    PreparedStatement pst;

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

    public void addProduct(Product p) {
        try {
            pst = conn.prepareStatement("INSERT INTO products (name, price, quantity, description, image, product_type) VALUES(?,?,?,?,?,?)");
            pst.setString(1, p.getProduct_name());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getQuantity());
            pst.setString(4, p.getDescription());
            FileInputStream file_in = new FileInputStream(p.getImage());
            pst.setBinaryStream(5, file_in);
            pst.execute();
            if (p.getProduct_type().equalsIgnoreCase("Laptop")) {
                pst.setInt(6, 1);
            } else {
                pst.setInt(6, 2);
            }
            int rows = pst.executeUpdate();
            pst.close();
            System.out.print(rows);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean addCustomer(String fname, String lname, String email, String Password, Date Dob, String address, String phone, String interets, int creditLimit) throws SQLException {
        boolean isAdded = false;
        try {
            String InsertStatement = "insert into users(first_name,last_name,dob,email,password,credit_limit,address,phone_number,interests)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(InsertStatement);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(4, email);
            pstmt.setString(5, Password);
            pstmt.setDate(3, Dob);
            pstmt.setString(7, address);
            pstmt.setString(8, phone);
            pstmt.setString(9, interets);
            pstmt.setInt(6, creditLimit);
            int i = pstmt.executeUpdate();
            System.out.println(i + " records inserted");
            isAdded = true;
        } catch (SQLException e) {
            System.out.println(" Exception at adding new users in data base : " + e);
            isAdded = false;
        }
        return isAdded;
    }

    public List<Product> getProducts() throws SQLException {
        products = new ArrayList<Product>();
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT name, price, quantity, description, image, product_type from products;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                Integer quantity = rs.getInt("quantity");
                String description = rs.getString("description");
                String image = rs.getString("image");
                String product_type = rs.getString("product_type");
                Product product = new Product(name, price, quantity, description, image, product_type);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Connection getConnection() {
        return conn;
    }
}
