package com.example.pets.daos.seeds;

import com.example.pets.daos.ProductDAO;
import com.example.pets.enums.Roles;
import com.example.pets.models.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductsSeeds {

     public static List<Product> getCollection() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Coleira Canina", 1, 15.99));
        products.add(new Product("Arranhador", 1, 9.99));
        products.add(new Product("Aquario Pequeno", 1, 5.59));

        return products;
    }

    public static void install(ProductDAO userDAO){
        for (Product user : getCollection()){
            userDAO.insert(user);
        }
    }
}
