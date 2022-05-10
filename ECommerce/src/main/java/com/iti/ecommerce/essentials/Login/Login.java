/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.Login;

import com.iti.ecommerce.essentials.dbconnection.DatabaseConnection;
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

//    Connection con;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManagement DM = new DatabaseManagement();

        Connection con = DatabaseConnection.getConnection();
        PrintWriter pw = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        if (email == null || email.equals("")) {
            request.setAttribute("status", "invalidEmail");
            dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        }
        if (password == null || password.equals("")) {
            request.setAttribute("status", "invalidPassword");
            dispatcher = request.getRequestDispatcher("/JSPfiles/verifyLogin.jsp");
            dispatcher.forward(request, response);
        }

        try {

            Statement sqlStmt = con.createStatement();
            String checkQuery = "select * from users where email = '" + email + "'"
                    + "and password = '" + password + "'";
            ResultSet rs = sqlStmt.executeQuery(checkQuery);

            if (rs.next()) {
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("id",rs.getInt("id"));
                session.setAttribute("user_type",rs.getInt("usertype_id"));
                session.setAttribute( "first_name",rs.getString("first_name"));
                session.setAttribute("last_name",rs.getString("last_name"));
                session.setAttribute("address",rs.getString("address"));
                session.setAttribute("credit_limit",rs.getInt("credit_limit"));
             // dispatcher = request.getRequestDispatcher("/JSPfiles/home.jsp");
                int Customer_type=rs.getInt("usertype_id");
                if (Customer_type==1) {
                    response.sendRedirect("/ECommerce/JSPfiles/home.jsp");
                } else if (Customer_type==2) {
                    response.sendRedirect("/ECommerce/Admin/client_management_page.jsp");
                  //  dispatcher = request.getRequestDispatcher("/ECommerce/Admin/client_management_page.jsp");
                }else{
                    response.sendRedirect("/ECommerce/JSPfiles/error.jsp");
                }
            } else {
                request.setAttribute("status", "failed");
             //  dispatcher = request.getRequestDispatcher("/JSPfiles/verifyLogin.jsp");
                response.sendRedirect("/ECommerce/JSPfiles/verifyLogin.jsp?status=failed");
            }
         // dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
