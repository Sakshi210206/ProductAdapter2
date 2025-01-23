package com.example.productadapter2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    ImageView productImageView;
    TextView productTitleTxtView, productPriceTxtView;
    ArrayList<Product> products;

    public ProductsAdapter(ArrayList<Product> products) {
        this.products = products;
    }



    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImageView);
            productTitleTxtView = itemView.findViewById(R.id.productTitleTxtView);
            productPriceTxtView = itemView.findViewById(R.id.productPriceTxtView);

            productImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ProductDetailsActivity.class);
                    intent.putExtra("product",products.get(getAdapterPosition()));
                    view.getContext().startActivity(intent);


                }
            });
        }
    }

    @NonNull
    @Override
    public ProductsAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View productView = layoutInflater.inflate(R.layout.product_view_holder, null);
        productImageView=productView.findViewById(R.id.productImageView);
        productTitleTxtView=productView.findViewById(R.id.productTitleTxtView);
        productPriceTxtView=productView.findViewById(R.id.productPriceTxtView);
// way 1  attaching listener in onCreate method
       /* productImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Image view Clicked",Toast.LENGTH_LONG).show();
            }
        });
        productTitleTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Title text view Clicked",Toast.LENGTH_LONG).show();
            }
        });
        productPriceTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "Price text view Clicked",Toast.LENGTH_LONG).show();
            }
        });*/

        return new ProductViewHolder(productView);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);//extract eachProduct from array of product object
        //holder.itemView.findViewById(R.id.productTitleTxtView); --previous code

        //get views from folder
        productImageView = holder.itemView.findViewById(R.id.productImageView);
        productTitleTxtView = holder.itemView.findViewById(R.id.productTitleTxtView);
        productPriceTxtView = holder.itemView.findViewById(R.id.productPriceTxtView);
        // bind eachProduct data with the corresponding view
        productTitleTxtView.setText(product.productTitle);
        productPriceTxtView.setText(product.productPrice + " ");
        productImageView.setImageResource(R.drawable.ic_launcher_background);
        //way 2 attaching listener on ion bind view holder
        /*
        productImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Image view Clicked "+product.productId,Toast.LENGTH_SHORT).show();

            }
        });
        productTitleTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Title text view Clicked "+product.productTitle,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), ProductDetailsActivity.class);
                intent.putExtra("product_title",product.productTitle);
                intent.putExtra("product_price",product.productPrice);
                intent.putExtra("product_image",product.imageId);
                intent.putExtra("product_id",product.productId);

                v.getContext().startActivity(intent);
            }
        });
        productPriceTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Price text view Clicked "+product.productPrice,Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return products.size();

    }
}
