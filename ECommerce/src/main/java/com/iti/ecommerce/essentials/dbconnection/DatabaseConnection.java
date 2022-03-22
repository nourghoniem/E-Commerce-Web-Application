/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nour
 */
public class DatabaseConnection {
    private static Connection con;
    
    public static void createConnection(String dbURL,String dbusername,String dbPassword){
        try {
          //  Class.forName("org.postgresql.Driver");
        //    con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ecommerce", dbusername, dbPassword);  
       
     con=DriverManager.getConnection(dbURL, dbusername, dbPassword);  
      

} catch (Exception ex) {
            System.out.println("exception at database connection"+ex);
        }    
    }
    
    public static Connection getConnection(){
        return con;
    }
    
    public static void closeConnection(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                 ex.printStackTrace();
            }
        }
    
    }
    
    
}
