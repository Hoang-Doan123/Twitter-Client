package com.example.twitterclient;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.twitterclient.database.DatabaseHelper;

public class SignupActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private EditText etName, etPassword, etEmail;
    private TextView tvGoToLogin;
    private Button btnSignup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        etName = findViewById(R.id.et_name);
        etPassword = findViewById(R.id.et_password);
        etEmail = findViewById(R.id.et_email);
        tvGoToLogin = findViewById(R.id.tv_go_to_login);
        btnSignup = findViewById(R.id.btn_signup);
        dbHelper = new DatabaseHelper(this);

        tvGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name, password, email;
                name = etName.getText().toString();
                password = etPassword.getText().toString();
                email = etEmail.getText().toString();
                // Check whether data fields empty or not
                if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill out all fields.", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (dbHelper.checkUserName(name)) {
                        Toast.makeText(SignupActivity.this, "User Already Exists", Toast.LENGTH_LONG).show();
                        return;
                    }
                    boolean isInserted = dbHelper.insertData(name, password, email);
                    if (isInserted) {
                        Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(SignupActivity.this, "Signup Failed", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
