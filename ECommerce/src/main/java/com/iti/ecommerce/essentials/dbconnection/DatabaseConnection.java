/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nour
 */
public class DatabaseConnection {

    private static Connection con;
    private static MongoDatabase mongodatabase;
    private static MongoClient client;

    public static void createConnection(String dbURL, String dbusername, String dbPassword) {
        try {
            Class.forName("org.postgresql.Driver");
            //   con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ecommerce", dbusername, dbPassword);  

            con = DriverManager.getConnection(dbURL, dbusername, dbPassword);

            System.out.println("database connected");
        } catch (Exception ex) {
            System.out.println("exception at database connection" + ex);
        }
    }
    public static void createMongoConnection(String MongoURI, String DBname) {
        try {
         //   client = MongoClients.create(MongoURI);
            client = new MongoClient(new MongoClientURI(MongoURI));
            mongodatabase = client.getDatabase(DBname);
            System.out.println("Mongo database connected");
        } catch (Exception ex) {
            System.out.println("exception at database connection " + ex);
        }
    }

    public static MongoDatabase getMongoDataBase() {
        return mongodatabase;
    }

    public static MongoClient getMongoClient() {
        return client;
    }

    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void closeMongoConnection() {
        if (client != null) {
            client.close();
        }

    }

}
