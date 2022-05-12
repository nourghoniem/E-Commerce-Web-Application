package com.ecommerce.model;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
/**
 *
 * @author nour
 */
public class Product {

    //    private FileInputStream product_image;
    private Integer id;
    private File product_image;
    private String product_name;
    private Double price;
    private Integer quantity;
    private String description;
    private String product_type;



    public Product(){}

    public Product(File product_image, String product_name, Double price, Integer quantity, String description, String product_type) {
        this.product_image = product_image;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.product_type = product_type;
    }
    public Product(Integer id, String product_name, Double price, Integer quantity, String product_type) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.product_type = product_type;
    }

    public Product(Integer id, String description, Double price, Integer quantity) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(Integer id, String product_name, String description, Double price, Integer quantity, String product_type) {
        this.id = id;
        this.product_name = product_name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.product_type = product_type;
    }

    public Product(File product_image, String product_name, Double price, Integer quantity, String product_type) {
        this.product_image = product_image;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.product_type = product_type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public File getFile() {
        return product_image;
    }

    public void setFile(File file) {
        this.product_image = file;
    }

}
