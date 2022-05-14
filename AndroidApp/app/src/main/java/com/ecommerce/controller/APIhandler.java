package com.ecommerce.controller;

import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class APIhandler {
    public static final String remote_IP = "192.168.122.1";
    public static final String Login_url = "http://"+remote_IP+":8080/ECommerce/rest/AuthenticationAPI/Login";
    public static final String Registration_url = "http://"+remote_IP+":8080/ECommerce/rest/AuthenticationAPI/Register";
    public static final String AllCategories_url = "http://"+remote_IP+":8080/ECommerce/rest/productAPI/AllCategories";
    public static final String AllProducts_url = "http://"+remote_IP+":8080/ECommerce/rest/productAPI/AllProductsInfo";
    public static final String SpecificProducts_url = "http://"+remote_IP+":8080/ECommerce/rest/productAPI/ProductInfo/";

    public static String produceProductUrl (int id){
        return SpecificProducts_url+id;
    }
    public static boolean Login (String email , String password) throws IOException {
        URL url = new URL(Login_url);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");

        String data = "{\n  \"email\": \""+email+"\",\n  \"password\": \""+password+"\"\n }";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
        return true;
    }
    public static boolean Register (Customer customer) throws IOException {
        URL url = new URL(Registration_url);
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestMethod("PUT");
        http.setDoOutput(true);
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");

        String data = "{"+
                "\n  \"first_name\": \""+customer.getFirst_name()+
                "\",\n  \"last_name\": \""+customer.getLast_name()+
                "\",\n  \"Date_of_birth\": \""+customer.getDob()+
                "\",\n  \"email\": \""+customer.getEmail()+
                "\",\n  \"password\": \""+customer.getPassword()+
                "\",\n  \"credit_limit\": "+customer.getCredit_limit()+
                "  ,\n  \"address\": \""+customer.getAddress()+
                "\",\n  \"phone_number\": \""+customer.getPhone_number()+
                "\",\n  \"interests\": \""+customer.getInterests()+
                "\"\n }";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();
        return true;
    }
    public static List<Product> getAllProducts ()
    {
        String result = "";
        try {
            URL url = new URL(AllProducts_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                result+=" "+ output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        Gson gson = new Gson();
        Type listType = new TypeToken<ArrayList<Product>>(){}.getType();
        List<Product> AllProductList = new Gson().fromJson(result, listType);
        return AllProductList;
    }
}
