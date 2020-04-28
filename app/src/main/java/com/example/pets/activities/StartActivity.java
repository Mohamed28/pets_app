package com.example.pets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pets.R;
import com.example.pets.daos.UserDAO;
import com.example.pets.models.User;

public class StartActivity extends AppCompatActivity {

    UserDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        dao = new UserDAO(this.getApplicationContext());
    }

    public void login(View view) {
        User seed = new User("Teste_1", "Teste_2", 11122233345L, "12345", 11900001111L, true);
        dao.insert(seed);

        Intent intent = new Intent(this, MainMenuActivity.class);
//        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
