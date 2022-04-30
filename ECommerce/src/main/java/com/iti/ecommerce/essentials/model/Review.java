package com.iti.ecommerce.essentials.model;

public class Review {
    int Product_id;
    int Customer_id;
    String Review;
    int year,month,day,hours,minutes;

    public Review(int product_id, int customer_id, String review, int year, int month, int day, int hours, int minutes) {
        Product_id = product_id;
        Customer_id = customer_id;
        Review = review;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
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
}
