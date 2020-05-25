package com.example.pets.activities.clients;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.activities.MainMenuActivity;
import com.example.pets.activities.users.UsersActivity;
import com.example.pets.daos.ClientDAO;
import com.example.pets.models.User;

public class ClientEditActivity extends AppCompatActivity {
    private EditText editName, editSurname, editCPF, editEmail;
    private ClientDAO clientDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_new_activity);
        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editCPF = findViewById(R.id.editCPF);
        clientDAO = new ClientDAO(this);
    }

    public void save(View view) {
        try {
            Toast.makeText(this, "Novo funcionário inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, ClientsActivity.class));
    }
}
