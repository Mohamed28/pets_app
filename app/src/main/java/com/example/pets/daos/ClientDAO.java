package com.example.pets.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.pets.daos.seeds.ClientsSeeds;
import com.example.pets.factories.DatabaseFactory;
import com.example.pets.models.Client;
import com.example.pets.models.Client;
import com.example.pets.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    SQLiteDatabase database;

    public ClientDAO(Context context) {
        database = Connection.getInstance(context);
        ClientsSeeds.install(this);
    }

    public long insert(Client client) {
        ContentValues values = new ContentValues();
        values.put("name", client.getName());
        values.put("surname", client.getSurname());
        values.put("CPF", client.getCPF());
        values.put("email", client.getEmail());
        return database.insert("client", null, values);
    }

    public List<Client> list() {
        List<Client> clients = new ArrayList<>();
        Cursor cursor = database.query("client", DatabaseFactory.ClIENT_COLUMNS, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Client client = new Client();
            client.setId(cursor.getInt(0));
            client.setName(cursor.getString(1));
            client.setSurname(cursor.getString(2));
            client.setCPF(cursor.getLong(3));
            client.setEmail(cursor.getString(4));
            clients.add(client);
        }

        return clients;
    }

    public Client find(int id) {
        Client client = new Client();
        final String WHERE = "client.id=" + id;
        Cursor cursor = database.query("client", DatabaseFactory.USER_COLUMNS, WHERE, null, null, null, null);

        try {
            cursor.moveToFirst();
            client.setId(cursor.getInt(0));
            client.setName(cursor.getString(1));
            client.setSurname(cursor.getString(2));
            client.setCPF(cursor.getLong(3));
            client.setEmail(cursor.getString(4));

        } catch (SQLiteException e) {
            database.close();
        }
        return client;
    }

    public Client find(long cpf) {
        return null;
    }

    public void update(Client client) {
        String sql = "";
    }

    public boolean delete(int id) {
        final String WHERE = "client.id=" + id;
        try {
            database.delete("client", WHERE, null);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
