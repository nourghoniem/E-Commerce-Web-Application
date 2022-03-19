<%-- 
    Document   : getData
    Created on : Mar 18, 2022, 11:35:46 PM
    Author     : nour
--%>

<%@page import="image.handling.ImageHandling"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.stream.StreamSupport"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="dbconnection.DatabaseManagement"%>
<%--<%@page import="org.apache.commons.io.FilenameUtils" %>--%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ImageHandling imagesHandling = new ImageHandling();
    String name = request.getParameter("name");
    String desc = request.getParameter("description");
    String quantity = request.getParameter("quantity");
    String product_type = request.getParameter("PType");
    String image = request.getParameter("image");
    String price = request.getParameter("price");
    out.println(name);
    out.println(desc);
    out.println(quantity);
    out.println(product_type);
    out.println(image);
    out.println(price);
    String replace = image.replace("\\", ",");
    String []token = replace.split(",");
    String imagePath = token[2];
    out.println(imagePath);
%>
