package com.example.pets.activities.orders;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.daos.ProductDAO;
import com.example.pets.models.Cart;
import com.example.pets.models.Product;
import com.example.pets.utils.OrderCheckoutListAdapter;

import java.util.List;

public class OrderCheckoutActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_checkout_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.checkout);

        ProductDAO productDAO = new ProductDAO(this);
        Cart.digest(productDAO.list());
        List<Product> products = Cart.getProducts();

        TextView textValue = findViewById(R.id.textValue);
        textValue.setText(Cart.getValueAmount());
        RecyclerView recyclerListOrderProducts = findViewById(R.id.recyclerListOrderProducts);
        recyclerListOrderProducts.setAdapter(new OrderCheckoutListAdapter(products));
        recyclerListOrderProducts.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, OrderNewActivity.class));
    }

    public void confirm(View view) {
        startActivity(new Intent(this, OrderCheckoutActivity.class));
    }
}
