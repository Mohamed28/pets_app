package com.example.pets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pets.R;
import com.example.pets.activities.clients.ClientsActivity;
import com.example.pets.activities.products.ProductsActivity;
import com.example.pets.activities.users.UsersActivity;
import com.example.pets.activities.dogs.info_dogs;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
    }

    public void goToUsers(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    public void goToClients(View view) {
        startActivity(new Intent(this, ClientsActivity.class));
    }

    public void goToProdutos(View view) {
        startActivity(new Intent(this, ProductsActivity.class));
    }

    public void goToInfoDogs(View view) {
        startActivity(new Intent(this, info_dogs.class));
    }

    /*public void goToInfoDogs(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }*/

    /*public void goToInfoCats(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }*/
}
