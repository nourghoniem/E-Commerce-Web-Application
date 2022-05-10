/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.controller;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.iti.ecommerce.essentials.model.Cart;
import com.iti.ecommerce.essentials.model.Order;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Date;
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
        Double total = Double.parseDouble(request.getParameter("total"));
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute("id");
        String address = (String) session.getAttribute("address");
        Integer credit_limit = (Integer) session.getAttribute("credit_limit");
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        ArrayList<Cart> get_cart_products = null;
        get_cart_products = database.getProductsFromCart(cart_list);
        Double new_credit;
        String new_address = request.getParameter("address");
        String order_note = request.getParameter("notes");
        if (total < credit_limit) {
           
            new_credit = credit_limit - total;
            database.editCreditLimit(new_credit, id);
            if (cart_list != null) {
                System.out.println("cart_list is not empty");
                database.editProductQuantity(cart_list);
                if (new_address.equalsIgnoreCase("no-address")) {
                    new_address = address;
                }
                if (order_note.equalsIgnoreCase("no-notes")) {
                    order_note = "none";
                }
                Date now = new Date();
                Order order = new Order(id, get_cart_products, total, new_address, order_note, now);
                database.addOrder(order);
                cart_list.clear();

            } else {
                System.out.println("cart_list is empty");
            }

            out.println("success");

        } else {
            out.println("failure");
        }

    }

}
