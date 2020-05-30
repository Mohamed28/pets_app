package com.example.pets.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.pets.factories.DatabaseFactory;
import com.example.pets.models.Pet;
import com.example.pets.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private SQLiteDatabase database;
    private Context context;

    public PetDAO(Context context) {
        this.context = context;
        database = Connection.getInstance(context);
//        PetsSeeds.install(this);
    }

    public void insert(Pet pet) {
        try {
            ContentValues values = new ContentValues();
            values.put("id", pet.getId());
            values.put("name", pet.getName());
            values.put("species", pet.getSpecie());
            values.put("breed", pet.getBreed());
            values.put("owner", pet.getOwner());
            database.insert("pet", null, values);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public List<Pet> list() {
        List<Pet> pets = new ArrayList<>();

        try {
            Cursor cursor = database.query("pet", DatabaseFactory.ClIENT_COLUMNS, null, null, null, null, null);

            while (cursor.moveToNext()) {
                Pet pet = new Pet();
                pet.setId(cursor.getInt(0));
                pet.setName(cursor.getString(1));
                pet.setSpecie(cursor.getString(2));
                pet.setBreed(cursor.getString(3));
                pet.setOwner(cursor.getString(4));
                pets.add(pet);
            }
        } catch (SQLException e) {
            Toast.makeText(context, "O banco está criado, porém, vazio.", Toast.LENGTH_SHORT).show();
        }

        return pets;
    }

    public Pet find(int id) {
        Pet pet = new Pet();
        final String WHERE = "pet.id=" + id;

        try {
            Cursor cursor = database.query("pet", DatabaseFactory.PET_COLUMNS, WHERE, null, null, null, null);
            cursor.moveToFirst();
            pet.setId(cursor.getInt(0));
            pet.setName(cursor.getString(1));
            pet.setSpecie(cursor.getString(2));
            pet.setBreed(cursor.getString(3));
            pet.setOwner(cursor.getString(4));

        } catch (SQLiteException e) {
            database.close();
        }
        return pet;
    }

    public Pet find(long cpf) {
        return null;
    }

    public void update(Pet pet) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "pet.id=" + id;

        try {
            database.delete("pet", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
