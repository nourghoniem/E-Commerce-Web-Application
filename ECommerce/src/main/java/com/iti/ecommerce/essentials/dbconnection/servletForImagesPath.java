/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.dbconnection;

import com.iti.ecommerce.essentials.model.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author engab
 */
public class servletForImagesPath extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseManagement DM = new DatabaseManagement();
        Connection conn = DM.getConnection();
        Statement stmt;
        ArrayList<Product> products;
        products = new ArrayList<Product>();
        try {
            stmt = conn.createStatement();
            String SQL = "SELECT e.id, e.imagefrom products as e inner join product_type as f on e.product_type = f.id;";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String type;
                Integer id = rs.getInt("id");
                InputStream image = rs.getBinaryStream("image");
                byte byteArray[] = new byte[image.available()];
                image.read(byteArray);
                FileOutputStream out = new FileOutputStream(request.getSession().getServletContext().getRealPath("db_images/" + id + ".jpg"));
               // response.getOutputStream().write(byteArray);
                out.write(byteArray);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(servletForImagesPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
