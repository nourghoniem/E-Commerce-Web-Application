/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.model;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author nour
 */
public class Order {
    private Integer order_id;
    private Integer user_id;
    private ArrayList<Cart> products;
    private Double total_price;
    private String delivery_address;
    private Date creation_date;
    
    public Order(){}

    public Order(Integer order_id, Integer user_id, ArrayList<Cart> products, Double total_price, String delivery_address, Date creation_date) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.products = products;
        this.total_price = total_price;
        this.delivery_address = delivery_address;
        this.creation_date = creation_date;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public ArrayList<Cart> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Cart> products) {
        this.products = products;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
       
}
