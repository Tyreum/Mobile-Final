package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_PassForgot extends AppCompatActivity {
    private Button btnValidCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pass_forgot);

        btnValidCode = (Button) findViewById(R.id.btnValidCode);
        btnValidCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity_Login.class);
                startActivity(intent);
            }
        });
    }
}