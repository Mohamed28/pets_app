package com.example.pets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pets.R;
import com.example.pets.dao.EmployeeDAO;
import com.example.pets.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class NewEmployeeActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editSurname;
    private EditText editCPF;
    private EditText editPassword;
    private EditText editPhone;
    private EmployeeDAO employeeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_employee_activity);
    }

    // TODO meétodo para escurecer o fundo do input quando este estive com focus

    public void save(View view) {
        try {
            editName = findViewById(R.id.editName);
            editSurname = findViewById(R.id.editSurname);
            editCPF = findViewById(R.id.editCPF);
            editPassword = findViewById(R.id.editPassword);
            editPhone = findViewById(R.id.editPhone);

            employeeDAO.insert(new Employee(
                    editName.getText().toString(),
                    editSurname.getText().toString(),
                    Long.parseLong(editCPF.getText().toString()),
                    editPassword.getText().toString(),
                    Long.parseLong(editPhone.getText().toString()))
            );

            Toast.makeText(this, "Novo funcionário inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, NewEmployeeActivity.class));
        }
        startActivity(new Intent(this, StartActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
