package com.example.ecommerceandroidapp;

import static com.ecommerce.controller.APIhandler.getAllProducts;
import static com.ecommerce.controller.APIhandler.produceImageUrl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ecommerce.controller.AP_RecyclerViewAdapter;

import com.ecommerce.controller.DownloadImageTask;
import com.ecommerce.controller.RecyclerViewInterface;
import com.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ViewAllProducts extends AppCompatActivity implements RecyclerViewInterface {
    Button CloseButton;
    static ArrayList<Product> AllProductList;
    static AP_RecyclerViewAdapter adapter;
    public static String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_products);
        type = getIntent().getStringExtra("type");
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        getAllProducts(ViewAllProducts.this);
        AllProductList = new ArrayList<>();
        Product product =new Product(1,"lenovo",15000.00,22,"Laptop");
        AllProductList.add(product);
        adapter = new AP_RecyclerViewAdapter(this, AllProductList,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     *  it returns an image from the url without downloading it
     *  @param id is the product id
     *  @param imageViewID is the id of the image view in the xml file wrote in the form "R.id.IMAGE_VIEW_ID"
     */
    private void setImage (int id ,int imageViewID){
        ImageView imageView =  findViewById(imageViewID);
        new DownloadImageTask(imageView).execute(produceImageUrl(id));
    }
    /**
     *  it returns an image from the url without downloading it
     *  @param id is the product id
     *  @param imageView image view element
     */
    private void setImage (int id ,ImageView imageView){
        new DownloadImageTask(imageView).execute(produceImageUrl(id));
    }
    public static void getAllProduct_CallBack( ArrayList<Product> ProductList){
        AllProductList.clear();
        if (type != "" || type !=null){
            for (Product product:ProductList){
                if (type == product.getProduct_type()){
                    AllProductList.add(product);
                }
            }
        }else {
            AllProductList.addAll(ProductList);
        }

       // AllProductList.addAll(ProductList);
        // notify adapter
        adapter.notifyDataSetChanged();
    }
    @Override
    public void onItemTab(int position) {
        Intent intent = new Intent(ViewAllProducts.this,ViewProductDetails.class);
        Toast.makeText(getApplicationContext(),AllProductList.get(position).getId().toString(),Toast.LENGTH_LONG).show();
        intent.putExtra("id",AllProductList.get(position).getId());
        startActivity(intent);
    }
}