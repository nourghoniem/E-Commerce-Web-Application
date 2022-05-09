package com.iti.ecommerce.essentials.model;

import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;

public class Review {
    int Product_id;
    int Customer_id;
    String Customer_name;
    String Review;
    int year,month,day,hours,minutes;
    int Rating;

    public Review() {
        Product_id = 0;
        Customer_id = 0;
        Review = "";
        Customer_name="";
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.hours = 0;
        this.minutes = 0;
        Rating = 0;
    }

    public Review(int product_id, int customer_id, String review, int year, int month, int day, int hours, int minutes, int rating) {
        Product_id = product_id;
        Customer_id = customer_id;
        Review = review;
        Customer_name=getName(customer_id);
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
        Rating = rating;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
        setCustomer_name(getName(customer_id));
    }

    public void setReview(String review) {
        Review = review;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public int getProduct_id() {
        return Product_id;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public String getReview() {
        return Review;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getRating() {
        return Rating;
    }
    private String getName(int customer_id){
        String Name;
        DatabaseManagement DM =new DatabaseManagement();
        Name= DM.getCustomer(customer_id).getFirst_name();
        return Name;
    }
    public void PrintReview(){
        System.out.print("Product_id : "+this.Product_id);
        System.out.print("  Customer_id : "+this.Customer_id);
        System.out.print("  Review : "+this.Review);
        System.out.print("  Customer_name : "+this.Customer_name);
        System.out.print("  year  : "+this.year);
        System.out.print("  month : "+this.month);
        System.out.print("  day : "+this.day);
        System.out.print("  hours : "+this.hours);
        System.out.print("  minutes : "+this.minutes);
        System.out.println("  Rating : "+ this.Rating);
    }
}
