package com.iti.ecommerce.essentials.restwebservice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@Path("/productApi")
public class ProductAPI
{
    DatabaseManagement DM;

    @GET
    @Path("/AllCategories")
    public String listAllCategories() throws SQLException, IOException {
       String result="no category is found";
        List<String> categories=null;
        DM=new DatabaseManagement();
        categories=DM.geAllCategories();
        if (categories != null){
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, categories);
            final byte[] data = out.toByteArray();
            result=new String(data);
        }
        return result;
    }

    @GET
    @Path("/AllProductsInfo")
    public String listAllProductsInfo () throws IOException {
        String result="no product is found";
        DM=new DatabaseManagement();
        List<Product> productList = DM.getProducts();
        if (productList != null){
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            final ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, productList);
            final byte[] data = out.toByteArray();
            result=new String(data);
        }
        return result;
    }

    @GET
    @Path("/ProductInfo/{id}")
    public String listProductInfo(@PathParam("id") int id) throws JsonProcessingException {
        String result="The product is not found";
        DM=new DatabaseManagement();
        Product product=DM.getProductById(id);
        if (product != null){
            ObjectMapper mapper=new ObjectMapper();
            result =mapper.writeValueAsString(product);
        }
        return result;
    }
}
