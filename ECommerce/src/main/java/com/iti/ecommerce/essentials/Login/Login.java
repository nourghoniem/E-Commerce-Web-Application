/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.Login;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author a7med
 */
public class Login extends HttpServlet {

    Connection con;
 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManagement DM =new DatabaseManagement();
      
        con = DM.getConnection();
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null ;
        
        if (email == null || email.equals("")){
        request.setAttribute("status", "invalidEmail");
        dispatcher = request.getRequestDispatcher("Login.jsp");
         dispatcher.forward(request, response);
        }
        if (password == null || password.equals("")){
        request.setAttribute("status", "invalidPassword");
        dispatcher = request.getRequestDispatcher("/JSPfiles/verifyLogin.jsp");
         dispatcher.forward(request, response);
        }
        
                try {
  
                    Statement sqlStmt = con.createStatement();
            String checkQuery = "select * from users where email = '" + email + "'" +
                    "and password = '" + password + "'" ;
            ResultSet rs = sqlStmt.executeQuery(checkQuery);

            if (rs.next()) {
                session.setAttribute("email", rs.getString("email"));
                dispatcher = request.getRequestDispatcher("store.html");
                
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher("/JSPfiles/verifyLogin.jsp");
            }
             dispatcher.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


}
