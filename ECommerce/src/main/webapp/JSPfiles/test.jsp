<%-- 
    Document   : test
    Created on : May 10, 2022, 8:11:54 PM
    Author     : nour
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.iti.ecommerce.essentials.model.Product"%>
<%@page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement"%>
<%
    DatabaseManagement database = new DatabaseManagement();
    Integer id = (Integer) session.getAttribute("id");
    ArrayList<Product> products = database.getPurchasedProducts(id);
    out.println("hi");
    if (id == null) {
        out.println("null id");
    }
    if (products.isEmpty()) {
        out.println("empty");
    }
    if (!products.isEmpty()) {
        for (Product p : products) {
            out.println(p.getId());
            out.println(p.getProduct_name());
        }
    }


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
