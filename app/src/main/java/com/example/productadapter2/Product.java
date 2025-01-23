package com.example.productadapter2;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Product implements Serializable {
    int productId;
    String productTitle;
    int productPrice;
    int imageId;

    public Product(int productId, String productTitle, int productPrice, int imageId) {
        this.productId = productId;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
        this.imageId = imageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    @NonNull
    @Override
    public String toString(){
        return super.toString();
    }
}
