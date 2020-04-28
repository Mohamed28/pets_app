package com.example.pets.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseFactory extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "pets_app.db";
    private static final int VERSION = 1;
    public static final String[] USER_COLUMNS = {"id", "name", "surname", "CPF", "password", "phone", "admin"};
    public static final String[] CLIENT_COLUMNS = {"id", "name", "surname", "CPF", "email"};
    private Context context;

    public DatabaseFactory(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
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
        try {
        String sql = "CREATE TABLE IF NOT EXISTS user (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(25) NOT NULL," +
                "surname VARCHAR(25) NOT NULL," +
                "CPF BIGINT NOT NULL UNIQUE, " +
                "password VARCHAR(8) NOT NULL, " +
                "phone BIGINT UNIQUE," +
                "admin INTEGER NOT NULL DEFAULT 0)";
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
