package com.example.mobilefinal;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.media.MediaCas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.EventListener;
import java.util.EventObject;

public class Activity_Login extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;
    private TextView txtRecover;
    private EditText txtEmail;
    private EditText txtSenha;

    //API PEDRO
    final RequestQueue queue = Volley.newRequestQueue(this);
    final String url = "http://127.0.0.1:5000/login";

    //RequestQueue
    Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
    Network network = new BasicNetwork(new HurlStack());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        //Navegação das páginas e atribuição do conteúdo no banco
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject postparams = new JSONObject();
                try {
                    postparams.put("email", txtEmail.getText());
                    postparams.put("senha", txtSenha.getText());
                }
                catch (JSONException e){
                    e.printStackTrace();
                }
                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, postparams,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        });
                queue.add(jsonObjReq);
            }
        });

        //Navegação
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

    public void openActivity_Registrar(){
        Intent intent = new Intent(this, Activity_Registrar.class);
        startActivity(intent);
    }
    public void openActivity_PassForgot(){
        Intent intent = new Intent(this, Activity_PassForgot.class);
        startActivity(intent);
    }

}