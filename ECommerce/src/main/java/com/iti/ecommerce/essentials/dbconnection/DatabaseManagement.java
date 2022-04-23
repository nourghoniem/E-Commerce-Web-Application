/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import com.iti.ecommerce.essentials.model.Customer;
import com.iti.ecommerce.essentials.model.Product;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nour
 */
public class DatabaseManagement {

    String filePath = new File("").getAbsolutePath();
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
        customers = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT id, first_name, last_name, dob, email, address, phone_number from users;";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                Customer customer = new Customer(id, fname, lname, email, dob, address, phone);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Product> getProducts() throws IOException {

        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id;";
            rs = stmt.executeQuery(SQL);
            products = (ArrayList<Product>) loopThroughResultSetForProducts(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public List<Product> getProducts(String Type) throws IOException {

        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id where f.type='"+Type+"' limit 8;";
            rs = stmt.executeQuery(SQL);
            products = (ArrayList<Product>) loopThroughResultSetForProducts(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public Product getProductById(Integer getid) {

        try {

            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.description, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id where e.id =" + getid + ";";
            rs = stmt.executeQuery(SQL);

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
    public String productTypeString(String Type) throws IOException {
        String result, name, image_URL;
        int id;
        double Price;
        result = "";
        products = (ArrayList<Product>) getProducts(Type);
        for (Product product : products) {

            name = product.getProduct_name();
            id = product.getId();
            Price = product.getPrice();
            image_URL = "../db_images/" + id + ".jpg";

            result = result + id + ":" + name + ":" + image_URL + ":" + Price + ":"+Type+";";

        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
    public String resultString(String KeyWord) throws IOException {
        String result, name, image_URL;
        int id;
        double Price;
        result = "";
        products = (ArrayList<Product>) getProductsForMainSearch(KeyWord);
        for (Product product : products) {

            name = product.getProduct_name();
            id = product.getId();
            Price = product.getPrice();
            image_URL = "../db_images/" + id + ".jpg";
            result = result + id + ":" + name + ":" + image_URL + ":" + Price + ";";

        }
        result = result.substring(0, result.length() - 1);
        return result;
    }

    List<Product> getProductsForMainSearch(String KeyWord) throws IOException {

        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price,e.description, f.type from products as e\n" + "    inner join product_type as f on e.product_type = f.id\n" + "    where UPPER(e.name) LIKE UPPER('" + KeyWord + "%') OR UPPER(description) LIKE UPPER('%" + KeyWord + "%');";
            rs = stmt.executeQuery(SQL);

            products = (ArrayList<Product>) loopThroughResultSetForProducts(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public void addProduct(Product p) {
        try {
            FileInputStream fis = new FileInputStream(p.getFile());
            pst = conn.prepareStatement("INSERT INTO products (name, price, quantity, description, image, product_type) VALUES(?,?,?,?,?,?)");
            pst.setString(1, p.getProduct_name());
            pst.setDouble(2, p.getPrice());
            pst.setInt(3, p.getQuantity());
            pst.setString(4, p.getDescription());

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

    public void deleteCustomer(Integer id) {
        try {

            pst = conn.prepareStatement("DELETE from users where id = ?");
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
            String InsertStatement = "insert into users(first_name,last_name,dob,email,password,credit_limit,address,phone_number,interests)" + "VALUES(?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(InsertStatement);
            pstmt.setString(1, fname);
            pstmt.setString(2, lname);
            pstmt.setDate(3, dob);
            pstmt.setString(4, email);
            pstmt.setString(5, Password);
            pstmt.setInt(6, creditLimit);
            pstmt.setString(7, address);
            pstmt.setString(8, phone);
            pstmt.setString(9, interets);

            int i = pstmt.executeUpdate();
            System.out.println(i + " records inserted");
            isAdded = true;
        } catch (SQLException e) {
            System.out.println(" Exception at adding new users in database : " + e);
            isAdded = true;
        }
        return isAdded;
    }

    List<Product> loopThroughResultSetForProducts(ResultSet rs) throws SQLException, IOException {
        products = new ArrayList<Product>();
        while (rs.next()) {
            String type;
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            Integer quantity = rs.getInt("quantity");
            Double price = rs.getDouble("price");
            String product_type = rs.getString("type");
            InputStream image = rs.getBinaryStream("image");
            byte[] byteArray = new byte[image.available()];
            image.read(byteArray);

            URL resource = getClass().getResource("/");
            String path = resource.getPath();
            path = path.replace("WEB-INF/classes/", "");
//                FileOutputStream out = new FileOutputStream("/home/nour/NetBeansProjects/Web_Development/ECommerce/src/main/webapp/db_images/" + id + ".jpg");
            System.out.println(path + "db_images/" + id + ".jpg");
            FileOutputStream out = new FileOutputStream(path + "db_images/" + id + ".jpg");
            out.write(byteArray);
            Product product = new Product(id, name, price, quantity, product_type);
            products.add(product);

        }
        return products;
    }

}
