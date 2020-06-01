package com.example.pets.activities.products;

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
import com.example.pets.daos.ProductDAO;
import com.example.pets.models.Product;
import com.example.pets.utils.ProductListAdapter;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    private RecyclerView recyclerListProducts;
    private ProductDAO productDAO;
    private List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity);
        TextView textHeader = findViewById(R.id.textHeader);
        textHeader.setText(R.string.products);


        productDAO = new ProductDAO(this);
        products = productDAO.list();

        recyclerListProducts = findViewById(R.id.recyclerListProducts);
        recyclerListProducts.setAdapter(new ProductListAdapter(this, products));
        recyclerListProducts.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewProduct(View view) {
        startActivity(new Intent(this, ProductNewActivity.class));
    }

    public void edit(View view, int productID) {
        Intent intent = new Intent(this, ProductNewActivity.class);
        intent.putExtra("id", productID);
        startActivity(intent);
    }

    public void show(View view, int productID) {
        Intent intent = new Intent(this, ProductShowActivity.class);
        intent.putExtra("id", productID);
        startActivity(intent);
    }

    public void remove(View view, int productID) {
        if (productDAO.delete(productID)) {
            Toast.makeText(this, "Produto id: " + productID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do produto!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, ProductsActivity.class));
    }
}
