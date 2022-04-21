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

/**
 * @author abdelrahman
 */
public class SearchForProductsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String Keyword = request.getParameter("keyword");
        System.out.println("Servlet Key Word is :" + Keyword);
        DatabaseManagement DM = new DatabaseManagement();
        String Result = DM.resultString(Keyword);
        PrintWriter pw = response.getWriter();
        pw.println(Result);
        System.out.println(Result);
    }


}
