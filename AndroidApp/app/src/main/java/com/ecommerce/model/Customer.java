/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ecommerce.model;
/**
 *
 * @author nour
 */
public class Customer {
    
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private String dob;
    private String password;
    private int credit_limit;
    private String address;
    private String phone_number;
    private String interests;
        

    public Customer(Integer id,String address,String phone_number,String email,Integer credit_limit){
        this.id = id;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.credit_limit = credit_limit;
    }

    public Customer(){}

    public Customer(Integer id, String email, int credit_limit, String address, String phone_number) {
        this.id = id;
        this.email = email;
        this.credit_limit = credit_limit;
        this.address = address;
        this.phone_number = phone_number;

    }
    
    public Customer(Integer id, String first_name, String last_name, String email, String dob, String address, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phone_number = phone_number;
    }

    public Customer(Integer id, String first_name, String last_name, String email, String dob, int credit_limit, String address, String phone_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.dob = dob;
        this.credit_limit = credit_limit;
        this.address = address;
        this.phone_number = phone_number;
    }

    public Customer(Integer id, String first_name, String last_name, String email, int credit_limit, String address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.credit_limit = credit_limit;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(int credit_limit) {
        this.credit_limit = credit_limit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getInterests() {
        return interests;
    }
}
