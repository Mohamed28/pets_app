package com.example.pets.activities.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.activities.StartActivity;
import com.example.pets.daos.ClientDAO;
import com.example.pets.daos.PetDAO;
import com.example.pets.models.Pet;

public class PetNewActivity extends AppCompatActivity {
    private EditText editId, editName, editSpecies, editBreed, editClient;
    private ClientDAO ownerDAO;
    private PetDAO petDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_new_activity);
        editName = findViewById(R.id.editName);
        editSpecies = findViewById(R.id.editSpecie);
        editBreed = findViewById(R.id.editBreed);
        editClient = findViewById(R.id.editClient);
        petDAO = new PetDAO(this);
        ownerDAO = new ClientDAO(this);
    }

    // TODO método para escurecer o fundo do input quando este estiver com focus

    public void save(View view) {
        try {
            petDAO.insert(new Pet(
                    editName.getText().toString(),
                    editSpecies.getText().toString(),
                    editBreed.getText().toString(),
                    ownerDAO.find(Integer.parseInt(editClient.getText().toString())))
            );

            Toast.makeText(this, "Novo pet inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, PetNewActivity.class));
        }
        startActivity(new Intent(this, StartActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
