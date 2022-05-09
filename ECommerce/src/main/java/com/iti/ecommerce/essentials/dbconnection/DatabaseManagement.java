/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import com.iti.ecommerce.essentials.model.Cart;
import com.iti.ecommerce.essentials.model.Customer;
import com.iti.ecommerce.essentials.model.Product;
import com.iti.ecommerce.essentials.model.Review;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.*;
import com.google.gson.*;


import javax.xml.namespace.QName;
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
    MongoDatabase mongoDatabase;
    MongoCollection mongoCollection;
    Statement stmt;
    PreparedStatement pstmt;
    ArrayList<Customer> customers;
    ArrayList<Product> products;

    Product product;
    Customer customer;
    ResultSet rs;
    PreparedStatement pst;

    public DatabaseManagement() {
        conn = DatabaseConnection.getConnection();
        if (conn == null) {
            System.out.println("database connection is null");
        }
        mongoDatabase = DatabaseConnection.getMongoDataBase();
        if (mongoDatabase == null) {
            System.out.println("Mongo database connection is null");
        }else {
            System.out.println("MongoDb is Ready");
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
    public Customer getCustomer(int customer_id) {
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT id, first_name, last_name, dob, email, address, phone_number, credit_limit from users where id ="+customer_id+";";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                Integer id = rs.getInt("id");
                int credit_limit =rs.getInt("credit_limit");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone_number");
                String dob = rs.getString("dob");
                String address = rs.getString("address");
                customer = new Customer(id, fname, lname, email, dob,credit_limit, address, phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    public int getUserType (int customer_id) throws SQLException {
        int type=0;
        stmt = conn.createStatement();
        String SQL = "SELECT usertype_id from users where id="+customer_id+";";
        rs = stmt.executeQuery(SQL);

        while (rs.next()) {
            type = rs.getInt("usertype_id");
        }
        return type;
    }
    public List<Product> getProducts() throws IOException {

        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id limit 8;";
            rs = stmt.executeQuery(SQL);
            products = (ArrayList<Product>) loopThroughResultSetForProducts(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getProducts(String Min, String Max) throws IOException {
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price, f.type from products as e inner join product_type as f on e.product_type = f.id Where e.price between " + Min + " and " + Max + " limit 8;";
            rs = stmt.executeQuery(SQL);
            products = (ArrayList<Product>) loopThroughResultSetForProducts(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<Product> getProducts(String Type, String Min, String Max) throws IOException {
        if (Type.equalsIgnoreCase("")) {
            return getProducts(Min, Max);
        } else {
            try {
                stmt = conn.createStatement();
                String SQL = "SELECT e.id, e.image, e.name, e.quantity, e.price, f.type "
                        + "from products as e "
                        + "inner join product_type as f "
                        + "on e.product_type = f.id "
                        + "where f.type='" + Type + "' and "
                        + "e.price between " + Min + " and " + Max + " limit 8;";
                rs = stmt.executeQuery(SQL);
                products = (ArrayList<Product>) loopThroughResultSetForProducts(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return products;
        }
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

    public String productTypeString(String Type, String Min, String Max) throws IOException {
        String result, name, image_URL;
        int id;
        double Price;
        result = "";
        products = (ArrayList<Product>) getProducts(Type, Min, Max);
        for (Product product : products) {

            name = product.getProduct_name();
            id = product.getId();
            Price = product.getPrice();
            image_URL = "../db_images/" + id + ".jpg";

            result = result + id + ":" + name + ":" + image_URL + ":" + Price + ":" + Type + ";";

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
    
    public Customer getCustomerById(Integer getid) {

        try {

            stmt = conn.createStatement();
            String SQL = "SELECT address,phone_number,email,credit_limit from customer where id =" + getid + ";";
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
               
                Integer id = rs.getInt("id");
                String address = rs.getString("address");
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
//                Double price = rs.getDouble("price");
                Integer credit_limit = rs.getInt("credit_limit");

                customer = new Customer(id, address,credit_limit,email,phone_number);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
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
    
     public void editCustomer(Customer customer) {
        try {
            pst = conn.prepareStatement("UPDATE users SET first_name = ? ,last_name = ? ,email = ? ,credit_limit = ? ,address = ? where id = ?");
            pst.setString(1, customer.getFirst_name());
            pst.setString(2, customer.getLast_name());
            pst.setString(3, customer.getEmail());
            pst.setInt(4, customer.getCredit_limit());
            pst.setString(5,customer.getAddress());
            pst.setInt(6,customer.getId());
            int rows = pst.executeUpdate();
            System.out.println("update data base");
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

    public ArrayList<Cart> getProductsFromCart(ArrayList<Cart> cart_list) {
        ArrayList<Cart> cartList = new ArrayList<Cart>();
        try {
            if (!cart_list.isEmpty()) {
                for (Cart c : cart_list) {
                    pst = conn.prepareStatement("SELECT name, description, price FROM products WHERE id = ?");
                    pst.setInt(1, c.getId());
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        Cart element = new Cart();
                        element.setId(c.getId());
                        element.setProduct_name(rs.getString("name"));
                        element.setDescription(rs.getString("description"));
                        element.setPrice(rs.getDouble("price") * c.getUser_quantity());
                        element.setUser_quantity(c.getUser_quantity());
                        cartList.add(element);
                    }

                }

            } else {
                System.out.println("zero ");
            }

        } catch (Exception e) {
        }
        return cartList;
    }

    public double getTotalPriceCart(ArrayList<Cart> cart_list) {
        double total_price = 0;
        try {
            if (!cart_list.isEmpty()) {
                for (Cart c : cart_list) {
                    pst = conn.prepareStatement("SELECT price FROM products WHERE id = ?");
                    pst.setInt(1, c.getId());
                    rs = pst.executeQuery();

                    while (rs.next()) {
                        total_price += (rs.getDouble("price") * c.getUser_quantity());
                    }

                }

            } else {
                System.out.println("zero ");
            }

        } catch (Exception e) {
        }
        return total_price;
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
            System.out.println(path + "db_images/" + id + ".jpg");
            FileOutputStream out = new FileOutputStream(path + "db_images/" + id + ".jpg");
            out.write(byteArray);
            Product product = new Product(id, name, price, quantity, product_type);
            products.add(product);

        }
        return products;
    }

    public void addMongoReview(Review review){

        Document document = new Document();
        document.append("product_id", review.getProduct_id());
        document.append("customer_id", review.getCustomer_id());
        document.append("review", review.getReview());
        document.append("review_date", review.getYear()+"/"+review.getMonth()+"/"+review.getDay()+";"+review.getHours()+":"+review.getMinutes());
        document.append("rating",review.getRating());

        mongoDatabase.getCollection("productsRR").insertOne(document);

    }
    public List<Review> getProductRRList(int Product_id) {
    int counter =0;
        List<Review> Result = new ArrayList<Review>();
        mongoCollection=mongoDatabase.getCollection("productsRR");
        Document doc;
        Document query =new Document();
        query.append("product_id",Product_id);
      //  FindIterable findIterable =mongoCollection.
       MongoCursor<Document> cursor =mongoCollection.find(query).iterator();
        while (cursor.hasNext()) {
            doc=cursor.next();
            Review review=new Review();
            String[] arrOfStr = doc.getString("review_date").split(";");
            review.setProduct_id(doc.getInteger("product_id"));
            review.setCustomer_id(doc.getInteger("customer_id"));
            review.setReview(doc.getString("review"));
            review.setYear(Integer.parseInt(arrOfStr[0].split("/")[0]));
            review.setMonth(Integer.parseInt(arrOfStr[0].split("/")[1]));
            review.setDay(Integer.parseInt(arrOfStr[0].split("/")[2]));
            review.setHours(Integer.parseInt(arrOfStr[1].split(":")[0]));
            review.setMinutes(Integer.parseInt(arrOfStr[1].split(":")[1]));
            review.setRating(doc.getInteger("rating"));

            Result.add(review);

        }

            return Result;

    }
    public int getProductRating(int product_id) {
        return CalculateTheAverageRating(product_id);
    }
     public int CalculateTheAverageRating(int product_id){
        int RatingTotal=0,RatingCount=0;
        double Avg;

        if (getProductRRList(product_id) != null){
         for (Review rev : getProductRRList(product_id)){
             RatingCount++;
             RatingTotal+=rev.getRating();
         }}
         if (RatingTotal != 0 && RatingCount !=0) {
             Avg = (double) RatingTotal / (double) RatingCount;
             return (int) Math.round(Avg);
         }else return 0;

    }


    public String[] getReviewList(int product_id){
        String[] str=null ;int i =0;
        for (Review rev : getProductRRList(product_id)){
            str[i]=rev.getReview();
            i++;
        }
        return str;
    }
    public boolean canReview(int product_id, int customer_id){
        boolean result;
        if (customer_id==-1){
            result= false;
        }else result=true;
        //check the db for purchasing product
        return result;
    }
}
