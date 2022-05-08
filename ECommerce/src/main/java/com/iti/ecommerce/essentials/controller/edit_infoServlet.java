/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.controller;
/**
 *
 * @author Aya Mostafa
 */
import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.iti.ecommerce.essentials.model.Customer;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nour
 */
public class edit_infoServlet extends HttpServlet {

 
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String address = request.getParameter("address");
        String phone_number =request.getParameter("phone_number");
        String email = request.getParameter("email");
        Integer credit_limit = Integer.parseInt(request.getParameter("credit_limit"));
        
        Customer c = new Customer(id, address, phone_number,email,credit_limit);
        DatabaseManagement data = new DatabaseManagement();
        data.editCustomer(c);
    }
}