/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.controller;

import com.iti.ecommerce.essentials.model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nour
 */
public class handleQuantity extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
        if (cart_list != null) {
            if (action.equals("minus")) {
                for (Cart c : cart_list) {
                    if (c.getId() == id && c.getUser_quantity() >= 1) {
                        int quantity = c.getUser_quantity();
                           if(quantity > 1){
                            quantity--;
                           }
                            c.setUser_quantity(quantity);
                            out.println(c.getUser_quantity());
                       
                   

                    }
                }

            } else {
                for (Cart c : cart_list) {
                    if (c.getId() == id && c.getUser_quantity() >= 1) {
                        int quantity = c.getUser_quantity();
                        quantity++;
                        c.setUser_quantity(quantity);
                        out.println(c.getUser_quantity());
                    }
                }
            }
        }
    }
}
