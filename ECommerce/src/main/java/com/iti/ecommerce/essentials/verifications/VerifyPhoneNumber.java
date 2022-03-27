/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.iti.ecommerce.essentials.verifications;

import com.twilio.rest.api.v2010.account.Call;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.net.URI;
import java.util.Arrays;
import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

import java.net.URI;
import java.util.Random;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Abdelrahman Mostafa
 * <Abdelrahman Mostafa at Information Technology Institute>
 */
public class VerifyPhoneNumber extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getParameter("phone"));
       ServletContext context =request.getServletContext();
       String ACCOUNT_SID = context.getInitParameter("ACCOUNT_SID");
       String AUTH_TOKEN = context.getInitParameter("AUTH_TOKEN");
       Random rand = new Random(); //instance of random class
         int upperbound = 9999;
        // int Random = rand.nextInt(upperbound);
       int Random  = Integer.parseInt(String.format("%04d", rand.nextInt(upperbound)));
 //Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
   //   Verfication.isphoneauthenticated(request.getParameter("phone"),"sms",Random, ACCOUNT_SID, AUTH_TOKEN);
       boolean Emailcondition=Verfication.isANEWEmail(request.getParameter("email"));
       boolean Phonecondition =Verfication.isANEWphone(request.getParameter("phone"));
  //Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//       Call call = Call.creator(
//                new com.twilio.type.PhoneNumber("+201147964655"),
//                new com.twilio.type.PhoneNumber("+15139404907"),
//                URI.create("http://demo.twilio.com/docs/voice.xml"))
//            .setMethod(HttpMethod.GET).setSendDigits("1234#").create();

     //   System.out.println(call.getSid());
          PrintWriter pw =response.getWriter();
          pw.println(Random+":"+String.valueOf(Phonecondition)+":"+String.valueOf(Emailcondition) );
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 

}
