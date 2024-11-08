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

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    Button btnLogin;
    EditText etNameLogin, etPasswordLogin;
    TextView tvGoToSignup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHelper = new DatabaseHelper(this);
        etNameLogin = findViewById(R.id.et_name_login);
        etPasswordLogin = findViewById(R.id.et_password_login);
        tvGoToSignup = findViewById(R.id.tv_go_to_signup);
        btnLogin = findViewById(R.id.btn_login);

        tvGoToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLoggedId = dbHelper.checkUser(etNameLogin.getText().toString(), etPasswordLogin.getText().toString());
                if (isLoggedId) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}
