package com.example.pets.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pets.factory.DatabaseFactory;

public class Connection {

    public static SQLiteDatabase getInstance(Context context) {
        DatabaseFactory database = new DatabaseFactory(context);
        return database.getWritableDatabase();
    }
}
