package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Home extends AppCompatActivity {
    private Button btnAddBairro;
    private Button btnAddAlimento;
    private Button btnVerBairro;
    private Button btnVerAlimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        btnAddBairro = (Button) findViewById(R.id.btnAddBairro);
        btnAddBairro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_AddBairro();
            }
        });
        btnAddAlimento = (Button) findViewById(R.id.btnAddAlimento);
        btnAddAlimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_AddAlimento();
            }
        });
        btnVerBairro = (Button) findViewById(R.id.btnVerBairro);
        btnVerBairro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_ListaBairro();
            }
        });

    }
    public void openActivity_AddBairro(){
        Intent intent = new Intent(this, Activity_AddBairro.class);
        startActivity(intent);
    }
    public void openActivity_AddAlimento(){
        Intent intent = new Intent(this, Activity_AddBairro.class);
        startActivity(intent);
    }
    public void openActivity_ListaBairro(){
        Intent intent = new Intent(this, Activity_ListaBairro.class);
        startActivity(intent);
    }
}