package com.example.pets.daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pets.factories.DatabaseFactory;
import com.example.pets.models.Client;
import com.example.pets.utils.Connection;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    SQLiteDatabase database;

    public ClientDAO(Context context) {
        database = Connection.getInstance(context);
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
        Cursor cursor = database.query("client", DatabaseFactory.CLIENT_COLUMNS, null, null, null, null, null);

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

    public Client find(long cpf) {
        return null;
    }
}
