package com.ecommerce.controller;

import static com.ecommerce.controller.APIhandler.produceImageUrl;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecommerce.model.Product;
import com.example.ecommerceandroidapp.R;

import java.util.ArrayList;

public class AP_RecyclerViewAdapter extends RecyclerView.Adapter<AP_RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Product> productArrayList;
    public AP_RecyclerViewAdapter(Context context, ArrayList<Product> productArrayList ,
                                  RecyclerViewInterface recyclerViewInterface) {
        this.context=context;
        this.productArrayList=productArrayList;
        this.recyclerViewInterface=recyclerViewInterface;
    }


    @NonNull
    @Override
    public AP_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);
        return new AP_RecyclerViewAdapter.MyViewHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AP_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(productArrayList.get(position).getProduct_name());
        Log.d("+++","product name : "+productArrayList.get(position).getProduct_name());
        holder.tvCat.setText(productArrayList.get(position).getProduct_type());
        holder.tvPrice.setText(productArrayList.get(position).getPrice().toString());
        setImage(productArrayList.get(position).getId(), holder.ProductImage);
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ProductImage;
        TextView tvName , tvCat, tvPrice;
        public MyViewHolder(@NonNull View itemView , RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            ProductImage = itemView.findViewById(R.id.ProductImage);
            tvName=itemView.findViewById(R.id.ProductName);
            tvCat=itemView.findViewById(R.id.ProductCategory);
            tvPrice=itemView.findViewById(R.id.ProductPrice);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null)
                    {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemTab(position);
                        }
                    }
                }
            });
        }
    }
    /**
     *  it returns an image from the url without downloading it
     *  @param id is the product id
     *  @param imageView image view element
     */
    private void setImage (int id ,ImageView imageView){
        new DownloadImageTask(imageView).execute(produceImageUrl(id));
    }
}
