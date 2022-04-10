/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

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
        String dbURL= context.getInitParameter("db_URL");
        try {
            DatabaseConnection.createConnection(dbURL,dbusername, dbpassword);
           Connection conn= DatabaseConnection.getConnection();
            System.out.println("Connection Establised.........");
        } catch (Exception ex) {
            System.out.println("Connection not Establised.........");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DatabaseConnection.closeConnection();
    }
}
