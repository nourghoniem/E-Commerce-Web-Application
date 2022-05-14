package com.ecommerce.controller;

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
}
