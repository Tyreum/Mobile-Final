package com.example.mobilefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, Activity_Login.class);
        startActivity(intent);
        finish();
    }
}