package com.example.pets.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pets.util.Connection;
import com.example.pets.models.User;

public class UserDAO {

    SQLiteDatabase database;

    public UserDAO(Context context) {
        database = Connection.getInstance(context);
    }

    public long insert(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("surname", user.getSurname());
        values.put("CPF", user.getCPF());
        values.put("password", user.getPassword());
        values.put("phone", user.getPhone());
        return database.insert("user", null, values);
    }

    public User find(long cpf){
        return null;
    }

}
