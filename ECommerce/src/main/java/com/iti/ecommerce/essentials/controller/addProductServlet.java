/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.controller;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author nour
 */
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,//2mb
//        maxFileSize = 1024 * 1024 * 10,//10mb
//        maxRequestSize = 1024 * 1024 * 50)//50mb
@MultipartConfig
public class addProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        String quantity = request.getParameter("quantity");
        String product_type = request.getParameter("PType");
        String price = request.getParameter("price");

        Part part = request.getPart("image");
    
        
        String file_name = extractFileName(part);
        String save_path = "/home/nour/NetBeansProjects/Web_Development/ECommerce/src/main/webapp/images" + File.separator + file_name;
        File fileSaveDir = new File(save_path);
        part.write(save_path + File.separator);
     
    }

    public String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }

        }
        return "";

    }
}
