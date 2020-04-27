package com.example.pets.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class DatabaseFactory extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pets_app.db";
    private static final int VERSION = 1;
    public static final String[] USER_COLUMNS = {"id", "name", "surname", "CPF", "password", "phone", "admin"};
    public static final String[] CLIENT_COLUMNS = {"id", "name", "surname", "CPF", "email"};

    public DatabaseFactory(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        createTableUser(database);
        createTableClient(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        dropTableDropUser(database);
        dropTableDropClient(database);
    }

    public void createTableUser(SQLiteDatabase database) {
        String sql = "CREATE TABLE user(" +
                "id integer primary key autoincrement," +
                "nome varchar(25) not null, " +
                "sobrenome varchar(25) not null," +
                "cpf bigint not null unique, " +
                "senha varchar(8) not null, " +
                "celular bigint unique," +
                "admin boolean not null default 0);";
        database.execSQL(sql);
    }

    public void dropTableDropUser(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS user";
        database.execSQL(sql);
    }

    private void createTableClient(SQLiteDatabase database) {
        String sql = "CREATE TABLE user(" +
                "id integer primary key autoincrement," +
                "nome varchar(25) not null, " +
                "sobrenome varchar(25) not null," +
                "cpf bigint not null unique, " +
                "email varchar(50) unique)";
        database.execSQL(sql);
    }

    private void dropTableDropClient(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS client";
        database.execSQL(sql);
    }

}
