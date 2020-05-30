package com.example.pets.activities.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.daos.ProductDAO;
import com.example.pets.enums.Category;
import com.example.pets.models.Product;

public class ProductShowActivity extends AppCompatActivity {
    private Product product;
    private ProductDAO productDAO;
    TextView textHeader, textShowName, textShowPrice, textShowCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_show_activity);
        productDAO = new ProductDAO(this);
        product = productDAO.find(getIntent().getExtras().getInt("id"));

        textHeader = findViewById(R.id.textHeader);
        textShowPrice = findViewById(R.id.textShowPrice);
        textShowCategory = findViewById(R.id.textShowCategory);

        textHeader.setText(product.getName());
        textShowName.setText(String.valueOf(product.getName()));
        textShowPrice.setText(String.valueOf(product.getPrice()));
        textShowCategory.setText(Category.stringfy(product.getCategory()));
    }

    public void back(View view) {
        startActivity(new Intent(this, ProductsActivity.class));
    }
}
