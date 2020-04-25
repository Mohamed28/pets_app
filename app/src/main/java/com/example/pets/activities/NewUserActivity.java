package com.example.pets.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pets.R;
import com.example.pets.dao.UserDAO;
import com.example.pets.models.User;

public class NewUserActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editSurname;
    private EditText editCPF;
    private EditText editPassword;
    private EditText editPhone;
    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user_activity);
    }

    // TODO meétodo para escurecer o fundo do input quando este estive com focus

    public void save(View view) {
        try {
            editName = findViewById(R.id.editName);
            editSurname = findViewById(R.id.editSurname);
            editCPF = findViewById(R.id.editCPF);
            editPassword = findViewById(R.id.editPassword);
            editPhone = findViewById(R.id.editPhone);

            userDAO.insert(new User(
                    editName.getText().toString(),
                    editSurname.getText().toString(),
                    Long.parseLong(editCPF.getText().toString()),
                    editPassword.getText().toString(),
                    Long.parseLong(editPhone.getText().toString()))
            );

            Toast.makeText(this, "Novo funcionário inserido com sucesso!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Falha ao tentar gravar dados, verifique os dados e tente novamente", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, NewUserActivity.class));
        }
        startActivity(new Intent(this, StartActivity.class));
    }

    public void back(View view) {
        startActivity(new Intent(this, StartActivity.class));
    }
}
