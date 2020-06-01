package com.example.pets.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.pets.daos.seeds.ProductsSeeds;
import com.example.pets.factories.DatabaseFactory;
import com.example.pets.models.Product;
import com.example.pets.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private SQLiteDatabase database;
    private Context context;

    public ProductDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
        ProductsSeeds.install(this);
    }

    public void insert(Product product) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", product.getName());
            values.put("category", product.getCategory());
            values.put("quantity", product.getQuantity());
            values.put("price", product.getPrice());
            database.insert("product", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Product> list() {
        List<Product> products = new ArrayList<>();

        try {
            Cursor cursor = database.query("product", DatabaseFactory.PRODUCT_COLUMNS, null, null, null, null, null);

            while (cursor.moveToNext()) {
                Product product = new Product();
                product.setId(cursor.getInt(0));
                product.setName(cursor.getString(1));
                product.setCategory(cursor.getInt(2));
                product.setQuantity(cursor.getInt(3));
                product.setPrice(cursor.getDouble(4));
                products.add(product);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return products;
    }

    public Product find(int id) {
        Product product = new Product();
        final String WHERE = "product.id=" + id;

        try {
            Cursor cursor = database.query("product", DatabaseFactory.PRODUCT_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            product.setId(cursor.getInt(0));
            product.setName(cursor.getString(1));
            product.setCategory(cursor.getInt(2));
            product.setQuantity(cursor.getInt(3));
            product.setPrice(cursor.getDouble(4));

        } catch (SQLiteException e) {
            database.close();
        }
        return product;
    }

    public Product findByName(String name) {
        return null;
    }

    public void update(Product product) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "product.id=" + id;

        try {
            database.delete("product", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
