/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.controller;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nour
 */
public class handleOrders extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        DatabaseManagement database = new DatabaseManagement();
        Integer total = Integer.parseInt(request.getParameter("total"));
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");
        Integer credit_limit = (Integer) session.getAttribute("credit_limit");
        Integer new_credit;
        if(total < credit_limit ){
           new_credit = credit_limit - total;
           //update credit-limit
           database.editCreditLimit(new_credit, id);
           //decrease quantity of product
//           editProductQuantity
           
          
           //decrease quantity of product
           //check if another address is placed
           //get note if left
           //insert into mongodb
           //pop up success message with remaining credit
        }
        else{
           out.println("sorry no");
        } 


        
       
    }

}
