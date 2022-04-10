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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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

    Product product;

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

    public List<Product> getProducts() throws IOException {
        products = new ArrayList<Product>();
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String type;
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                Integer quantity = rs.getInt("quantity");
                Double price = rs.getDouble("price");
                String product_type = rs.getString("type");
                InputStream image = rs.getBinaryStream("image");
                byte byteArray[] = new byte[image.available()];
                image.read(byteArray);
               FileOutputStream out = new FileOutputStream("F:/webProject/newerversion/E-Commerce-Web-Application/ECommerce/src/main/webapp/db_images/" + id + ".jpg");
             // File my_URL= new File("../../../../../../webapp/db_images/" + id + ".jpg");
          //   String localDir = System.getProperty("user.dir");
          //   File my_URL = new File(localDir + "src\\main\\webapp\\db_images\\" + id + ".jpg");
           //  FileOutputStream out = new FileOutputStream(my_URL);
           //     System.out.println(out);           
//   FileOutputStream output = new FileOutputStream( request.getSession().getServletContext().getRealPath("WEB-INF/classes/data.json"), false);

              out.write(byteArray);
                Product product = new Product(id, name, price, quantity, product_type);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    
        public Product getProductById(Integer getid) throws IOException {
      
        try {
          
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.description, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id where e.id ="+getid+";";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String type;
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Integer quantity = rs.getInt("quantity");
                Double price = rs.getDouble("price");
                String product_type = rs.getString("type");
            
                 product = new Product(id, name, description, price, quantity, product_type);
  
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public void addProduct(Product p) {
        try {
            FileInputStream fis = new FileInputStream(p.getFile());
            pst = conn.prepareStatement("INSERT INTO products (name, price, quantity, description, image, product_type) VALUES(?,?,?,?,?,?)");
            pst.setString(1, p.getProduct_name());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getQuantity());
            pst.setString(4, p.getDescription());
//<<<<<<< HEAD
//            FileInputStream file_in = new FileInputStream(p.getImage());
//            pst.setBinaryStream(5, file_in);
//            pst.execute();
//=======
            pst.setBinaryStream(5, fis, p.getFile().length());

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



      public void editProduct(Product p) {
        try {
        
            pst = conn.prepareStatement("UPDATE products SET description=?, price = ?, quantity=? where id = ?");
            pst.setString(1, p.getDescription());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getQuantity());
            pst.setInt(4, p.getId());
            int rows = pst.executeUpdate();
            pst.close();
            System.out.print(rows);
        } catch (Exception e) {
            e.getMessage();
        }
    }
      
    public void deleteProduct(Integer id) {
        try {
        
            pst = conn.prepareStatement("DELETE from products where id = ?");
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            pst.close();
            System.out.print(rows);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public boolean addCustomer(String fname, String lname, String email, String Password, Date dob, String address, String phone, String interets, int creditLimit) throws SQLException {
        boolean isAdded = false;
        try {
            String InsertStatement = "insert into users(first_name,last_name,dob,email,password,credit_limit,address,phone_number,intersts)"
                    + "VALUES(?,?,?,?,?,?,?,?,?);";
            pstmt = conn.prepareStatement(InsertStatement);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setString(4, email);
            pstmt.setString(5, Password);
            pstmt.setDate(3, dob);
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
    public Connection getConnection() {
        return conn;
    }
}
