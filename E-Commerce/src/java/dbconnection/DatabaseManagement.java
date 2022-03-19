/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Product;

/**
 *
 * @author nour
 */
public class DatabaseManagement {

    Connection conn;
    Statement stmt;
    ArrayList<Customer> customers;
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
            if(p.getProduct_type().equalsIgnoreCase("Laptop")){
              pst.setInt(6, 1);
            }
            else{
              pst.setInt(6, 2);
            }
            int rows = pst.executeUpdate();
            pst.close();
            System.out.print(rows);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
