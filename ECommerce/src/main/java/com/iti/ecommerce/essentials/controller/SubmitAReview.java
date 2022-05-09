package com.iti.ecommerce.essentials.controller;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.iti.ecommerce.essentials.model.Review;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SubmitAReview extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Review review= new Review(
                Integer.parseInt(req.getParameter("product_id")),
                Integer.parseInt(req.getParameter("customer_id")),
                req.getParameter("review"),
                Integer.parseInt(req.getParameter("year")),
                Integer.parseInt(req.getParameter("month")),
                Integer.parseInt(req.getParameter("day")),
                Integer.parseInt(req.getParameter("hours")),
                Integer.parseInt(req.getParameter("minutes")),
                Integer.parseInt(req.getParameter("rating")));
        PrintWriter out = resp.getWriter();
        DatabaseManagement DM = new DatabaseManagement();
        DM.addMongoReview(review);
        out.println("added,");


    }
}
