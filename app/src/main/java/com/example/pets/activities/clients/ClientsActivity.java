package com.example.pets.activities.clients;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.activities.MainMenuActivity;
import com.example.pets.daos.ClientDAO;
import com.example.pets.models.Client;
import com.example.pets.utils.ClientListAdapter;

import java.util.List;

public class ClientsActivity extends AppCompatActivity {

    private RecyclerView recyclerListClients;
    private ClientDAO clientDAO;
    private List<Client> clients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clients_activity);

        clientDAO = new ClientDAO(this);
        clients = clientDAO.list();

        recyclerListClients = findViewById(R.id.recyclerListClients);
        recyclerListClients.setAdapter(new ClientListAdapter(this, clients));
        recyclerListClients.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewClient(View view) {
        startActivity(new Intent(this, ClientNewActivity.class));
    }

    public void remove(View view, int clientID) {
        if (clientDAO.delete(clientID)) {
            Toast.makeText(this, "Usuário id: " + clientID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do usuário!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, ClientsActivity.class));
    }
}
