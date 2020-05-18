package com.example.pets.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

import com.example.pets.daos.seeds.UsersSeeds;
import com.example.pets.factories.DatabaseFactory;
import com.example.pets.models.User;
import com.example.pets.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private SQLiteDatabase database;

    public UserDAO(Context context) {
        database = Connection.getInstance(context);
//        UsersSeeds.install(this);
    }

    public void insert(User user) {
        try {
            ContentValues values = new ContentValues();
            values.put("name", user.getName());
            values.put("surname", user.getSurname());
            values.put("CPF", user.getCPF());
            values.put("password", user.getPassword());
            values.put("phone", user.getPhone());
            values.put("role", user.getRole());
            values.put("admin", user.isAdmin());
            database.insert("user", null, values);
        } catch (SQLiteException e) {
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
            user.setRole(cursor.getInt(6));
            user.setAdmin((cursor.getInt(7) == 1));
            users.add(user);
        }

        return users;
    }

    public User find(int id) {
        User user = new User();
        final String WHERE = "user.id=" + id;
        Cursor cursor = database.query("user", DatabaseFactory.USER_COLUMNS, WHERE, null, null, null, null);

        try {
            cursor.moveToFirst();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setSurname(cursor.getString(2));
            user.setCPF(cursor.getLong(3));
            user.setPassword(cursor.getString(4));
            user.setPhone(cursor.getLong(5));
            user.setRole(cursor.getInt(6));
            user.setAdmin((cursor.getInt(7) == 1));

        } catch (SQLiteException e) {
            database.close();
        }
        return user;
    }

    public User findByCPF(long cpf) {
        return null;
    }

    public void update(User user) {
        String sql = "";

    }

    public boolean delete(int id) {
        final String WHERE = "user.id=" + id;
        try {
            database.delete("user", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
