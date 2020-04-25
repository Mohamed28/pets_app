package com.example.pets.factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class DatabaseFactory extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pets_app.db";
    private static final int VERSION = 1;

    public DatabaseFactory(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
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
        String sql = "CREATE TABLE user(" +
                "id integer primary key autoincrement," +
                "nome varchar(25), " +
                "sobrenome varchar(25), " +
                "cpf bigint, " +
                "senha varchar(8), " +
                "celular bigint);";
        database.execSQL(sql);
    }

    public void dropTableDropUser(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS user";
        database.execSQL(sql);
    }
}
