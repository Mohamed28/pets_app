package com.example.pets.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.pets.util.Connection;
import com.example.pets.models.Employee;

public class EmployeeDAO {

    SQLiteDatabase database;

    public EmployeeDAO(Context context) {
        database = Connection.getInstance(context);
    }

    public long insert(Employee employee) {
        ContentValues values = new ContentValues();
        values.put("name", employee.getName());
        values.put("surname", employee.getSurname());
        values.put("CPF", employee.getCPF());
        values.put("password", employee.getPassword());
        values.put("phone", employee.getPhone());
        return database.insert("employee", null, values);
    }

    public Employee find(long cpf){
        return null;
    }

}
