package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Activity_Registrar extends AppCompatActivity {
    private Button btnRegister;
    private EditText txtEmail;
    private EditText txtSenha;

    //API PEDRO
    final RequestQueue queue = Volley.newRequestQueue(this);
    final String url = "http://127.0.0.1:5000/cadastrar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

    }
    public void openActivity_Registrar(){
        Intent intent = new Intent(this, Activity_Registrar.class);
        startActivity(intent);
    }
}