package com.example.pets.activities.clients;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.activities.StartActivity;
import com.example.pets.daos.ClientDAO;
import com.example.pets.models.Client;

public class ClientNewActivity extends AppCompatActivity {
    private EditText editName, editSurname, editCPF, editEmail;
    private ClientDAO clientDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_new_activity);
        clientDAO = new ClientDAO(this);
        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editCPF = findViewById(R.id.editCPF);
        editEmail = findViewById(R.id.editEmail);
    }

    public void save(View view) {
        try {
            clientDAO.insert(new Client(
                    editName.getText().toString(),
                    editSurname.getText().toString(),
                    Long.parseLong(editCPF.getText().toString()),
                    editEmail.getText().toString())
            );

            Toast.makeText(this, "Novo funcionário inserido com sucesso!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ClientsActivity.class));

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ClientNewActivity.class));
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, ClientsActivity.class));
    }
}
