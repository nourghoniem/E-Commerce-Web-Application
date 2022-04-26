/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.controller;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.iti.ecommerce.essentials.model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nour
 */
public class addToCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Integer id = Integer.parseInt(request.getParameter("id"));
        Cart cart = new Cart();
        cart.setId(id);
        cart.setUser_quantity(1);
        ArrayList<Cart> cartList = new ArrayList<>();
        HttpSession session = request.getSession();
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if (cart_list == null) { //cart session is empty 
            cartList.add(cart);
            session.setAttribute("cart-list", cartList);
            out.println("added");
        } else {
            cartList = cart_list;
            boolean exists = false;
            for (Cart c : cart_list) {
                if (c.getId() == id) {
                    exists = true; // already added to Cart
                    out.println("exists");
                }
            }
            if (!exists) {
                cartList.add(cart);
                out.println("added");

            }
//            for (Cart c : cart_list) {
//                out.println(c.getId());
//            }

        }
    }
}
