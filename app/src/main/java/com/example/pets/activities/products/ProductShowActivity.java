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
    TextView textHeader, textShowName, textShowCategory, textShowAvailablility, textShowPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_show_activity);
        productDAO = new ProductDAO(this);
        product = productDAO.find(getIntent().getExtras().getInt("id"));

        textHeader = findViewById(R.id.textHeader);
        textShowCategory = findViewById(R.id.textShowCategory);
        textShowAvailablility = findViewById(R.id.textShowAvailablility);
        textShowPrice = findViewById(R.id.textShowPrice);

        textHeader.setText(product.getName());
        textShowName.setText(String.valueOf(product.getName()));
        textShowCategory.setText(Category.stringfy(product.getCategory()));
        textShowAvailablility.setText(String.valueOf(product.getQuantity()));
        textShowPrice.setText(product.toCurrency(product.getPrice()));
    }

    public void back(View view) {
        startActivity(new Intent(this, ProductsActivity.class));
    }
}
