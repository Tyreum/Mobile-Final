package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    private TextView txtRecover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Home();
            }
        });
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Registrar();
            }
        });
        txtRecover = (TextView) findViewById(R.id.txtRecover);
        txtRecover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_PassForgot();
            }
        });
    }
    public void openActivity_Home(){
        Intent intent = new Intent(this, Activity_Home.class);
        startActivity(intent);
    }
    public void openActivity_Registrar(){
        Intent intent = new Intent(this, Activity_Registrar.class);
        startActivity(intent);
    }
    public void openActivity_PassForgot(){
        Intent intent = new Intent(this, Activity_PassForgot.class);
        startActivity(intent);
    }
}