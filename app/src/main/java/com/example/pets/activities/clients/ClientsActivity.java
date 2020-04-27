package com.example.pets.activities.clients;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.activities.MainMenulActivity;
import com.example.pets.daos.ClientDAO;
import com.example.pets.models.Client;

import java.util.List;

public class ClientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clients_activity);

        ListView listClients = findViewById(R.id.listClients);
        ClientDAO clientDAO = new ClientDAO(this);
        List<Client> clients = clientDAO.list();

        ArrayAdapter<Client> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clients);
        listClients.setAdapter(adapter);
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenulActivity.class));
    }

    public void add(View view) {
        startActivity(new Intent(this, NewClientActivity.class));
    }

    public void edit(View view, Client client) {
        Intent intent = new Intent(this, NewClientActivity.class);
        intent.putExtra("id", client.getId());
        startActivity(new Intent(this, NewClientActivity.class));
    }

    public void show(View view, Client client) {
        Intent intent = new Intent(this, NewClientActivity.class);
        intent.putExtra("id", client.getId());
        startActivity(new Intent(this, NewClientActivity.class));
    }

    public void remove(View view, Client client) {
        Intent intent = new Intent(this, NewClientActivity.class);
        intent.putExtra("id", client.getId());
        startActivity(new Intent(this, NewClientActivity.class));
    }
}
