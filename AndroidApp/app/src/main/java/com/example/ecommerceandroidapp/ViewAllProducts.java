package com.example.ecommerceandroidapp;

import static com.ecommerce.controller.APIhandler.Login;
import static com.ecommerce.controller.APIhandler.Register;
import static com.ecommerce.controller.APIhandler.getAllProducts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewAllProducts extends AppCompatActivity {
    Button CloseButton;
    List<Product> AllProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_products);
 //      AllProductList= getAllProducts();
         CloseButton = findViewById(R.id.button);
        CloseButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                              AllProductList= getAllProducts(ViewAllProducts.this);
//                                               try {
//                                                 //  Login(ViewAllProducts.this,"aa@gmail.com","abdelrahman");
//                                                //       Customer customer = new Customer (
//                                                  //             "amr" , "aly","amr@gmail.com","25-03-1998","123456789",50000,"123moon","01147964622","swimming"
//                                                 //      );
//                                                    //   Register(ViewAllProducts.this,customer);
//                                               } catch (IOException e) {
//                                                   e.printStackTrace();
//                                               }
                                           }
                                       }
        );
    }
}