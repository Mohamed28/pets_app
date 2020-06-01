package com.example.pets.activities.orders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.activities.MainMenuActivity;
import com.example.pets.activities.products.ProductNewActivity;
import com.example.pets.activities.products.ProductShowActivity;
import com.example.pets.daos.ProductDAO;
import com.example.pets.models.Product;
import com.example.pets.utils.OrderProductListAdapter;

import java.util.HashMap;
import java.util.List;

public class OrderNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_new_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.order);

        ProductDAO productDAO = new ProductDAO(this);
        List<Product> products = productDAO.list();

        RecyclerView recyclerListOrderProducts = findViewById(R.id.recyclerListOrderProducts);
        recyclerListOrderProducts.setAdapter(new OrderProductListAdapter(products));
        recyclerListOrderProducts.setLayoutManager(new LinearLayoutManager(this));
    }

    public void cancel(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void confirm(View view) {
        startActivity(new Intent(this, OrderCheckoutActivity.class));
    }
}
