package com.dianacosmetics.model;

import java.util.HashMap;

public class ProductCatalog {
    private HashMap<String, Product> products;

    public ProductCatalog() {

        products = new HashMap<>();
    }

    public void addProduct(Product product) {

        products.put(product.getName(), product);
    }

}

