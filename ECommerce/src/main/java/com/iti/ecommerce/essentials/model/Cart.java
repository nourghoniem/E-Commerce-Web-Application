/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iti.ecommerce.essentials.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nour
 */
public class Cart extends Product implements Serializable{
    
    private Integer user_quantity;
    
    public Cart(){
      user_quantity = 1;
    
    }

    public Integer getUser_quantity() {
        return user_quantity;
    }

    public void setUser_quantity(Integer user_quantity) {
        this.user_quantity = user_quantity;
    }
    
   
    
    
}
