package com.example.pets.factories;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseFactory extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "pets_app.db";
    public static final int VERSION = 1;
    public static final String[] USER_COLUMNS = {"id", "name", "surname", "CPF", "password", "phone", "role", "admin"};
    public static final String[] ClIENT_COLUMNS = {"id", "name", "surname", "CPF", "email"};
    public static final String[] PRODUCT_COLUMNS = {"id", "name", "category", "price",};
    private Context context;

    public DatabaseFactory(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        createTableUser(database);
        createTableClient(database);
        createTableProduct(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        dropTableDropUser(database);
        dropTableDropClient(database);
        dropTableDropProduct(database);
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
                "role TINYINT," +
                "admin INTEGER NOT NULL DEFAULT 0)";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void createTableClient(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS client (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(25) NOT NULL," +
                    "surname VARCHAR(25) NOT NULL," +
                    "CPF BIGINT NOT NULL UNIQUE, " +
                    "email VARCHAR(25) NOT NULL);";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void createTableProduct(SQLiteDatabase database) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS product (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name VARCHAR(25) NOT NULL," +
                    "category TYNYINT NOT NULL," +
                    "price DECIMAL NOT NULL);";
            database.execSQL(sql);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    public void dropTableDropUser(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS user";
        database.execSQL(sql);
    }

    public void dropTableDropClient(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS client";
        database.execSQL(sql);
    }

    public void dropTableDropProduct(SQLiteDatabase database) {
        String sql = "DROP TABLE IF EXISTS product";
        database.execSQL(sql);
    }
}
