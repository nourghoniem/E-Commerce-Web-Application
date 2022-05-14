package com.ecommerce.controller;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class APIhandler {
    public static final String remote_IP = "41.43.202.107";
    public static final String Login_url = "http://" + remote_IP + ":8080/ECommerce/rest/AuthenticationAPI/Login";
    public static final String Registration_url = "http://" + remote_IP + ":8080/ECommerce/rest/AuthenticationAPI/Register";
    public static final String AllCategories_url = "http://" + remote_IP + ":8080/ECommerce/rest/productAPI/AllCategories";
    public static final String AllProducts_url = "http://" + remote_IP + ":8080/ECommerce/rest/productAPI/AllProductsInfo";
    public static final String SpecificProducts_url = "http://" + remote_IP + ":8080/ECommerce/rest/productAPI/ProductInfo/";

    public static String produceProductUrl(int id) {
        return SpecificProducts_url + id;
    }
    /// write your Login Logic here
    public static void Login_CallBack(Context context,boolean result){
        if (result == true ){
            //porceed after login
            Toast.makeText(context, "Login was successful", Toast.LENGTH_SHORT).show();
            //procee to home page
        }else {
            // the credentials are wrong
            Toast.makeText(context, "Login has couter an issue please try again ", Toast.LENGTH_SHORT).show();
        }
    }
    ///
    //implement go to home page here
    public static void Register_CallBack(Context context,boolean result){
        if (result == true ){
            //porceed after Registration
            Toast.makeText(context, "Registration is submitted successfully", Toast.LENGTH_SHORT).show();
            //go to home page
        }else {
            // something isnot right
            Toast.makeText(context, "Registration Countered an error", Toast.LENGTH_SHORT).show();
            // something isnot right
        }
    }

    public static void Login(Context context,String email, String password) throws IOException {

        try {
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("email", email);
            jsonBody.put("password", password);
            final String mRequestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, Login_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject respObj = new JSONObject(response);
                        boolean status = Boolean.valueOf(respObj.getString("login"));
                        Login_CallBack(context,status);
                      //  Toast.makeText(context, result[0], Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_RESPONSE", error.toString());
                    Toast.makeText(context,  error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                        return null;
                    }
                }
            };


            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void Register(Context context,Customer customer) throws IOException {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JSONObject jsonBody = new JSONObject();

            jsonBody.put("first_name", customer.getFirst_name());
            jsonBody.put("last_name",  customer.getLast_name() );
            jsonBody.put("Date_of_birth", customer.getDob());
            jsonBody.put("email",  customer.getEmail());
            jsonBody.put("password",  customer.getPassword());
            jsonBody.put("credit_limit", customer.getCredit_limit());
            jsonBody.put("address", customer.getAddress());
            jsonBody.put("phone_number", customer.getPhone_number());
            jsonBody.put("interests", customer.getInterests());

            final String mRequestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.PUT, Registration_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject respObj = new JSONObject(response);
                        boolean status = Boolean.valueOf(respObj.getString("register"));
                        Register_CallBack(context,status);
                        //  Toast.makeText(context, result[0], Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("LOG_RESPONSE", error.toString());
                    Toast.makeText(context,  error.toString(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                        return null;
                    }
                }
            };


            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public static List<Product> getAllProducts( Context context) {
        final String[] result = {""};
        List<Product> AllProductList =new ArrayList<Product>();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = AllProducts_url;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0;i<response.length();i++){
                    try {
                        JSONObject jsonproduct = response.getJSONObject(i);
                        AllProductList.add(jsontoProduct(jsonproduct));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                Toast.makeText(context, response.toString(), Toast.LENGTH_LONG).show();
                }
//

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return AllProductList;
    }
    public static Product jsontoProduct(JSONObject jsonProduct) throws JSONException {
        Product product= new Product(
        jsonProduct.getInt("id"),
                jsonProduct.getString("product_name"),
                jsonProduct.getDouble("price"),
                jsonProduct.getInt("quantity"),
                jsonProduct.getString("product_type")
    );
        return product;
    }
}
