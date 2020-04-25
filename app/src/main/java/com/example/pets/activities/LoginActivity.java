package com.example.pets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pets.R;
import com.example.pets.dao.EmployeeDAO;
import com.example.pets.models.Employee;

public class LoginActivity extends AppCompatActivity {

    EditText inputLogin, inputPassword;
    TextView lblRemaningAttempts;
    Button btnLogin;
//    Employee employee;
//    EmployeeDAO employeeDAO = new EmployeeDAO(this.getApplicationContext());
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        inputLogin = findViewById(R.id.inputLogin);
        inputPassword = findViewById(R.id.inputPassword);
        lblRemaningAttempts = findViewById(R.id.lblRemaningAttempts);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();
            }
        });
    }

    public void Check() {
//        TODO sistema de consulta de um employee que retorna um objeto employee
//         será usado para a validação de acesso
//        employee = employeeDAO.find(Long.parseLong(inputLogin.getText().toString()));
//
        if (inputLogin.getText().toString().equals("admin") && inputPassword.getText().toString().equals("1234")) {
            Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainMenulActivity.class);
            startActivity(intent);

        } else {
            counter--;
            lblRemaningAttempts.setText("Número de tentativas restantes: " + String.valueOf(counter));

            Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show();
            if (counter == 0) {
                btnLogin.setEnabled(false);
            }
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
