package com.example.pets.activities.users;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.pets.R;
import com.example.pets.daos.UserDAO;
import com.example.pets.enums.Roles;
import com.example.pets.models.User;

import java.util.Objects;

public class UserShowActivity extends AppCompatActivity {

    private User user;
    private UserDAO userDAO;
    TextView textShowFullName, textShowCPF, textShowPhone, textShowRole;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_show_activity);
//        Log.e("ERROR --------------", getIntent().getExtras().toString());
        userDAO = new UserDAO(this);
        user = userDAO.find(getIntent().getExtras().getInt("id"));

        textShowFullName = findViewById(R.id.textFullName);
        textShowCPF = findViewById(R.id.textShowCPF);
        textShowPhone = findViewById(R.id.textShowPhone);
        textShowRole = findViewById(R.id.textShowRole);

        textShowFullName.setText(user.getFullName());
        textShowCPF.setText(String.valueOf(user.getCPF()));
        textShowPhone.setText(String.valueOf(user.getPhone()));
        textShowRole.setText(Roles.stringfy(user.getRole()));
    }

    public void back(View view) {
        startActivity(new Intent(this, UsersActivity.class));
    }
}
