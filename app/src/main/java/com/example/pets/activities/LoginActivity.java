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

public class LoginActivity extends AppCompatActivity {

    EditText editLogin, editPassword;
    TextView textRemaningAttempts;
    Button buttonLogin;
//    User user;
//    UserDAO userDAO = new UserDAO(this.getApplicationContext());
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        textRemaningAttempts = findViewById(R.id.textRemaningAttempts);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Check();
            }
        });
    }

    public void Check() {
//        TODO sistema de consulta de um user que retorna um objeto user
//         será usado para a validação de acesso
//        user = userDAO.find(Long.parseLong(editLogin.getText().toString()));
//
        if (editLogin.getText().toString().equals("admin") && editPassword.getText().toString().equals("1234")) {
            Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainMenulActivity.class);
            startActivity(intent);

        } else {
            counter--;
            textRemaningAttempts.setText("Número de tentativas restantes: " + String.valueOf(counter));

            Toast.makeText(this, "Failed Login", Toast.LENGTH_SHORT).show();
            if (counter == 0) {
                buttonLogin.setEnabled(false);
            }
        }
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
