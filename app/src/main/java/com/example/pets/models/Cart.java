package com.example.pets.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private static HashMap<Integer, Integer> cart;
    private static List<Product> products;
    private static double amount = 0;

    public static HashMap<Integer, Integer> getInstance() {
        cart = new HashMap<>();
        return cart;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void digest(List<Product> list) {
        products = new ArrayList<>();

        for (Product product : list){
            if (cart.containsKey(product.getId())) {
                products.add(product);
                amount += (product.getPrice() * cart.get(product.getId()));
            }
        }
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static String getValueAmount() {
        return String.format("R$ %.2f", amount);
    }
}
