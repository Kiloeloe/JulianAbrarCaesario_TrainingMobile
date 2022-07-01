package com.example.julianabrarcaesario_trainingmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button logout;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = findViewById(R.id.btn_logout);
        username = findViewById(R.id.tv_username);

        Intent intent = getIntent();
        String tempUsername = intent.getStringExtra("account_username");

        username.setText(tempUsername);

        logout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
        });
    }
}