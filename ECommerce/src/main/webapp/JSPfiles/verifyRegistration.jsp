<%-- 
    Document   : verifyRegistration
    Created on : Mar 19, 2022, 1:30:55 PM
    Author     : Abdelrahman Mostafa <Abdelrahman Mostafa at Information Technology Institute>
--%>

<%@page import="com.iti.ecommerce.essentials.dbconnection.DatabaseManagement"%>
<%@page import="java.util.Locale"%>

<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.iti.ecommerce.essentials.verifications.Verfication"%>
<%@ include file="/JSPfiles/Header.jsp" %>
  <% String FName=request.getParameter("form-first-name");
  String LName=request.getParameter("form-last-name");
  String Address=request.getParameter("form-address");

  String SDate =request.getParameter("form-DateofBirth");
  java.util.Date date = new SimpleDateFormat("yyyy-MM-dd").parse(SDate);
//surround below line with try catch block as below code throws checked exception
int days =date.getDay();
int month =date.getMonth();
int year =date.getYear();
java.sql.Date DoB=new java.sql.Date(date.getTime());  
  String Email=request.getParameter("form-email");
  String phone=request.getParameter("form-phone");
  String password=request.getParameter("form-password");
  String Interests=request.getParameter("form-Interests");
  int Credits=Integer.parseInt(request.getParameter("form-credit"));
 // boolean Condition =new DatabaseManagement().addCustomer(FName, LName, Email, password, days,month,year, Address, phone, Interests, Credits);
 boolean Condition=Verfication.RegistrationVerfied(FName, LName, Email, password, DoB, Address, phone, Interests, Credits);
  if (Condition)
        {
            %><h1  style="color: greenyellow">your data is submmited successfully </h1>
  <%              
        }else{
%><h1 style="color: red">an error has occured </h1>
<%
    }  
%>
  <%@ include file="../HTMLPages/Footer.html" %> 
