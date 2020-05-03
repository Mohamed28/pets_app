package com.example.pets.activities.users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.activities.MainMenuActivity;
import com.example.pets.daos.UserDAO;
import com.example.pets.models.User;
import com.example.pets.utils.RecyclerViewAdapter;

import java.util.List;

public class UsersActivity extends AppCompatActivity {

    private RecyclerView recyclerListUsers;
    private UserDAO userDAO;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_activity);

        userDAO = new UserDAO(this);
        users = userDAO.list();

        recyclerListUsers = findViewById(R.id.recyclerListUsers);
        recyclerListUsers.setAdapter(new RecyclerViewAdapter(this, users));
        recyclerListUsers.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void add(View view) {
        startActivity(new Intent(this, NewUserActivity.class));
    }

    public void edit(View view, User user) {
        Intent intent = new Intent(this, NewUserActivity.class);
        intent.putExtra("id", user.getId());
        startActivity(new Intent(this, NewUserActivity.class));
    }

    public void show(View view, User user) {
        Intent intent = new Intent(this, NewUserActivity.class);
        intent.putExtra("id", user.getId());
        startActivity(new Intent(this, NewUserActivity.class));
    }

    public void remove(View view, User user) {
        Intent intent = new Intent(this, NewUserActivity.class);
        intent.putExtra("id", user.getId());
        startActivity(new Intent(this, NewUserActivity.class));
    }
}
