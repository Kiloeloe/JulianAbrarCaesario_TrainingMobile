package com.example.julianabrarcaesario_trainingmobile.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.julianabrarcaesario_trainingmobile.R;

public class LoginActivity extends AppCompatActivity {

    Button login, toRegister;
    EditText loginUsername, loginPassword;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.btn_login);
        toRegister = findViewById(R.id.btn_toRegister);
        loginUsername = findViewById(R.id.et_loginUsername);
        loginPassword = findViewById(R.id.et_loginPassword);
        sharedPref = getSharedPreferences("account", MODE_PRIVATE);

        login.setOnClickListener(v -> {
            if(!loginUsername.getText().toString().equals(sharedPref.getString("account_username",""))){

                Toast.makeText(LoginActivity.this, "Username Invalid", Toast.LENGTH_SHORT).show();

            }else if(!loginPassword.getText().toString().equals(sharedPref.getString("account_password",""))){

                Toast.makeText(LoginActivity.this, "Password Invalid", Toast.LENGTH_SHORT).show();

            }else if(loginUsername.getText().toString().equals(sharedPref.getString("account_username","")) &&
                    loginPassword.getText().toString().equals(sharedPref.getString("account_password",""))){

                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                loginIntent.putExtra("account_username", sharedPref.getString("account_username",""));
                startActivity(loginIntent);
            }
        });


        toRegister.setOnClickListener(v ->{
            Intent toRegisterIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(toRegisterIntent);
        });
    }
}