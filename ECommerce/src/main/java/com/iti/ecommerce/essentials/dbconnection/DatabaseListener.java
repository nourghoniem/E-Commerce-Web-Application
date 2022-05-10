/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import com.iti.ecommerce.essentials.verifications.Verfication;
import com.mongodb.client.MongoDatabase;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String dbusername = context.getInitParameter("db_username");
        String dbpassword = context.getInitParameter("db_password");
        String Mongodbusername = context.getInitParameter("Mongodb_username");
        String Mongodbpassword = context.getInitParameter("Mongodb_password");
        String MongoURI = context.getInitParameter("Mongodb_URI");
        String MongoDBName = context.getInitParameter("MongodbName");
        String dbURL = context.getInitParameter("db_URL");
        String MongodbURL = context.getInitParameter("Mongodb_URL");
        String  ACCOUNT_SID = context.getInitParameter("ACCOUNT_SID"),
                AUTH_TOKEN= context.getInitParameter("AUTH_TOKEN");
        Verfication.setTwillioParams(ACCOUNT_SID ,AUTH_TOKEN);
        try {
            DatabaseConnection.createConnection(dbURL,dbusername, dbpassword);
           Connection conn = DatabaseConnection.getConnection();
            System.out.println("Connection Establised.........");
        } catch (Exception ex) {
            System.out.println("Connection not Establised.........");
        }
        try {
           DatabaseConnection.createMongoConnection(MongoURI, MongoDBName);
           System.out.println("Mongo Connection Establised.........");
        } catch (Exception ex) {
            System.out.println("Mongo Connection not Establised.........");
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("STOP");
        DatabaseConnection.closeConnection();
        DatabaseConnection.closeMongoConnection();
    }
}
