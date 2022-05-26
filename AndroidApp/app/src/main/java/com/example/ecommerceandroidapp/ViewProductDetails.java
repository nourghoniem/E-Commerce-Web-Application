package com.example.ecommerceandroidapp;

import static com.ecommerce.controller.APIhandler.produceProductUrl;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ecommerce.controller.AP_RecyclerViewAdapter;
import com.ecommerce.model.Product;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ViewProductDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_product_details);
        Toast.makeText(getApplicationContext(),"second page"+String.valueOf(getIntent().getIntExtra("id",-1)),Toast.LENGTH_LONG).show();
        int id = getIntent().getIntExtra("id",-1);
//        String url = "http://192.168.122.1:8080/ECommerce/rest/productAPI/ProductInfo/1";
        String url = produceProductUrl(1);
        HashMap<String, String> param = new HashMap<>();
//        param.put("param", "1");
        param.put("param",String.valueOf(id));
        JSONObject jsonObject = new JSONObject(param);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Integer id =  response.getInt("id");
                    String name =  response.getString("product_name");
                    String description =  response.getString("description");
                    Double price =  response.getDouble("price");
                    Integer quantity =  response.getInt("quantity");
                    String type =  response.getString("product_type");
                    Product product = new Product(id, name, description, price, quantity, type);
                    setProductData(product);
//                    Log.e("Rest Response", response.getString("product_name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("Rest Response", error.toString());
                    }
                }
        );
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        requestQueue.add(jsonObjectRequest);

    }
    public void setProductData(Product p){
        ImageView image = (ImageView)findViewById(R.id.product_image);
        TextView name = (TextView)findViewById(R.id.product_name);
        TextView description = (TextView)findViewById(R.id.description);
        TextView price = (TextView)findViewById(R.id.price);
        String product_price = Double.toString(p.getPrice());
        name.setText(p.getProduct_name());
        description.setText(p.getDescription());
        price.setText(product_price);
    }
}