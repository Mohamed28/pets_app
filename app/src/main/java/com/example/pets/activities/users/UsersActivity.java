package com.example.pets.activities.users;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.activities.MainMenuActivity;
import com.example.pets.daos.UserDAO;
import com.example.pets.models.User;

import java.util.List;

public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_activity);

        ListView listUsers = findViewById(R.id.listUsers);
        UserDAO userDAO = new UserDAO(this);
        List<User> users = userDAO.list();
        String[] testes = {"Teste_1", "Teste_2", "Teste_3", "Teste_4", "Teste_5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, testes);
        listUsers.setAdapter(adapter);

        listUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
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
