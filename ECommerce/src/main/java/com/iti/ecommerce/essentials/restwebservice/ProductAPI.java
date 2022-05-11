package com.iti.ecommerce.essentials.restwebservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.iti.ecommerce.essentials.dbconnection.DatabaseManagement;
import com.iti.ecommerce.essentials.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Produces;
import org.json.JSONObject;

@Path("/productAPI")
public class ProductAPI {

    DatabaseManagement DM;

    @GET
    @Path("/AllCategories")
    @Produces("application/json")
    public String listAllCategories() throws SQLException, IOException {
        String result = "none";
        List<String> categories = null;
        DM = new DatabaseManagement();
        categories = DM.getAllCategories();
        JSONObject json=new JSONObject();
        if (categories != null) {
            result = json.put("categories",categories).toString();
//            final ByteArrayOutputStream out = new ByteArrayOutputStream();
//            final ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(out, categories);
//            final byte[] data = out.toByteArray();
//            result = new String(data);
        }
        return result;
    }

    @GET
    @Path("/AllProductsInfo")
    @Produces("application/json")
    public String listAllProductsInfo() throws IOException {
        JSONObject json=new JSONObject();
        String result = "none";
        DM = new DatabaseManagement();
        List<Product> productList = DM.getProducts();
        if (productList != null) {
            result = new Gson().toJson(productList);
//            final ByteArrayOutputStream out = new ByteArrayOutputStream();
//            final ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(out, productList);
//            final byte[] data = out.toByteArray();
//            result = new String(data);
        }
        return result;
    }

    @GET
    @Path("/ProductInfo/{id}")
    @Produces("application/json")
    public String listProductInfo(@PathParam("id") int id) throws JsonProcessingException {
        String result = "none";
        DM = new DatabaseManagement();
        Product product = DM.getProductById(id);
        if (product != null) {
            result = new Gson().toJson(product);
//            ObjectMapper mapper = new ObjectMapper();
//            result = mapper.writeValueAsString(product);
           
        }
        return result;
    }
}
