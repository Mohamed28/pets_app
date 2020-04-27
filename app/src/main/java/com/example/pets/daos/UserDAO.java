package com.example.pets.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.pets.factories.DatabaseFactory;
import com.example.pets.models.User;
import com.example.pets.utils.Connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAO {

    SQLiteDatabase database;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public UserDAO(Context context) {
        database = Connection.getInstance(context);
        User seed = new User("Teste_1", "Teste_2", 11122233345L, "12345", 11900001111L, true);
        insert(seed);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void insert(User user) {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("surname", user.getSurname());
        values.put("CPF", user.getCPF());
        values.put("password", user.getPassword());
        values.put("phone", user.getPhone());
        values.put("admin", Boolean.compare(user.getAdmin(), false));


        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(user);
        System.out.println(values);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        try {
            database.insert("user", null, values);

        } catch (SQLiteException e) {
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(user);
            System.out.println(values);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            e.printStackTrace();
        }
    }

    public List<User> list() {
        List<User> users = new ArrayList<>();
        Cursor cursor = database.query("user", DatabaseFactory.USER_COLUMNS, null, null, null, null, null);

        while (cursor.moveToNext()) {
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setSurname(cursor.getString(2));
            user.setCPF(cursor.getLong(3));
            user.setPassword(cursor.getString(4));
            user.setPhone(cursor.getLong(5));
            user.setAdmin((cursor.getInt(0) == 1));
            users.add(user);
        }

        return users;
    }

    public User find(long cpf) {
        return null;
    }

}
