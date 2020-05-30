package com.example.pets.activities.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pets.R;
import com.example.pets.activities.MainMenuActivity;
import com.example.pets.daos.PetDAO;
import com.example.pets.models.Pet;
import com.example.pets.utils.PetListAdapter;

import java.util.List;

public class PetActivity extends AppCompatActivity {

    private RecyclerView recyclerListPets;
    private PetDAO petDAO;
    private List<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pets_activity);

        petDAO = new PetDAO(this);
        pets = petDAO.list();

        recyclerListPets = findViewById(R.id.recyclerListPets);
        recyclerListPets.setAdapter(new PetListAdapter(this, pets));
        recyclerListPets.setLayoutManager(new LinearLayoutManager(this));
    }

    public void back(View view) {
        startActivity(new Intent(this, MainMenuActivity.class));
    }

    public void goToNewPet(View view) {
        startActivity(new Intent(this, PetNewActivity.class));
    }

    public void remove(View view, int petID) {
        if (petDAO.delete(petID)) {
            Toast.makeText(this, "Pet id: " + petID + " removido com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro na execução desta remoção do pet!", Toast.LENGTH_SHORT).show();
        }
        startActivity(new Intent(this, PetActivity.class));
    }
}
