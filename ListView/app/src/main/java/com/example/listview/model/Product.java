package com.example.listview.model;

public class Product {
    String name;
    int price;
    int productID;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductID() {
        return productID;
    }

    public Product(int productID, String name, int price) {
        this.name = name;
        this.price = price;
        this.productID = productID;
    }
}
