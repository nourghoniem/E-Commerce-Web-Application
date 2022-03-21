/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DatabaseListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String dbusername = context.getInitParameter("db_username");
        String dbpassword = context.getInitParameter("password");

        DatabaseConnection.createConnection(dbusername, dbpassword);
        System.out.println("Connection Establised.........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
