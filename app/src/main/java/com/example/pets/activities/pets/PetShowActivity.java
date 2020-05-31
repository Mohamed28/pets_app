package com.example.pets.activities.pets;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pets.R;
import com.example.pets.daos.PetDAO;
import com.example.pets.models.Pet;

public class PetShowActivity extends AppCompatActivity {

    private Pet pet;
    private PetDAO petDAO;
    TextView textShowName, textShowSpecie, textShowBreed, textShowOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet_show_activity);
        petDAO = new PetDAO(this);
        pet = petDAO.find(getIntent().getExtras().getInt("id"));

        textShowName = findViewById(R.id.textShowName);
        textShowSpecie = findViewById(R.id.textShowSpecie);
        textShowBreed = findViewById(R.id.textShowBreed);
        textShowOwner = findViewById(R.id.textShowOwner);

        textShowName.setText(pet.getName());
        textShowSpecie.setText(String.valueOf(pet.getSpecie()));
        textShowBreed.setText(String.valueOf(pet.getBreed()));
        textShowOwner.setText(String.valueOf(pet.getOwner()));
    }

    public void back(View view) {
        startActivity(new Intent(this, PetsActivity.class));
    }
}
