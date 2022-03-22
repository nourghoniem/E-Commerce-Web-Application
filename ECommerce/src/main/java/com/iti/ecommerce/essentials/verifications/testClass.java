/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.verifications;

import java.net.URI;
import java.util.Arrays;
import com.twilio.Twilio;
import com.twilio.http.HttpMethod;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Abdelrahman Mostafa
 * <Abdelrahman Mostafa at Information Technology Institute>
 */

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class testClass {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACa6cbcb955bca23cadd8875e0a6ff1983";
  public static final String AUTH_TOKEN = "274e48d032948ab3dfc938a39fa79bc0";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+201147964655"),
        new PhoneNumber("+15139404907"), 
        "This is the ship that made the Kessel Run in fourteen parsecs?").create();
      // Call call = Call.creator(new PhoneNumber("+201102908309"),
       //        new PhoneNumber("+15139404907"),
       //         new com.twilio.type.Twiml("<Response><Say loop=\"1\">hello nour your code is 5 4 3 2</Say></Response>")).create();

       // System.out.println(call.getSid());
//    System.out.println(message.getSid());
//-----------------------------------
//        Message message = Message.creator(
//            new com.twilio.type.PhoneNumber("+201147964655"),
//            new com.twilio.type.PhoneNumber("+15139404907"),"T")        
//               .setMediaUrl(
//            Arrays.asList(URI.create("https://c1.staticflickr.com/3/2899/14341091933_1e92e62d12_b.jpg")))
//               .create();
//
//        System.out.println(message.getSid());
//        Call call = Call.creator(new PhoneNumber("+201100081688"),
//                new PhoneNumber("+16073035175"),
//                new com.twilio.type.Twiml("<Response><Say loop=\"3\">your code is 5 4 3 2</Say></Response>")).create();
//
//        System.out.println(call.getSid());
  }
}