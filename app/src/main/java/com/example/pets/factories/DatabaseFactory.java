package com.example.pets.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DatabaseFactory extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pets_app.db";
    private static final int VERSION = 1;
    public static final String[] USER_COLUMNS = {"id", "name", "surname", "CPF", "password", "phone", "admin"};
    private Context context;

    public DatabaseFactory(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        createTableUser(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        dropTableDropUser(database);
    }

    public void createTableUser(SQLiteDatabase database) {
        context.deleteDatabase(DATABASE_NAME);

        String sql = "CREATE TABLE user (" +
                "id integer primary key autoincrement," +
                "name varchar(25) not null," +
                "surname varchar(25) not null," +
                "CPF bigint not null unique, " +
                "password varchar(8) not null, " +
                "phone bigint unique," +
                "admin integer not null default 0)";
        try {
            database.execSQL(sql);
        } catch (SQLiteException e) {
            close();
            context.deleteDatabase(DATABASE_NAME);
        }
    }

    public void dropTableDropUser(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS user";
        database.execSQL(sql);
    }
}
