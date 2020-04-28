package com.example.pets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pets.R;
import com.example.pets.activities.users.NewUserActivity;
import com.example.pets.activities.users.UsersActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);
    }

    public void goToUsers(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }
}
