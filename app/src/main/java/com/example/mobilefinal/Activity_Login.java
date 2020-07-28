package com.example.mobilefinal;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.media.MediaCas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Cache;
import com.android.volley.DefaultRetryPolicy;
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

import org.json.JSONArray;
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
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        //API
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://10.0.2.2:5000/login";

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());

        txtEmail = (EditText) findViewById(R.id.edLogin);
        txtSenha = (EditText) findViewById(R.id.etSenha);

        //Navegação
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
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


                    final JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, postparams,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        Log.d("Resposta", response.getString(("status")));
                                        Boolean status = response.getBoolean("status");
                                        Log.d("STATUS", status.toString());
                                        if(status == true){
                                            Toast.makeText(getApplicationContext(), "Bem vindo!", Toast.LENGTH_SHORT).show();
                                            openActivity_Home();
                                        }
                                        else {
                                            Toast.makeText(getApplicationContext(), "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                                        }
                                    } catch (JSONException e) {

                                        e.printStackTrace();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error)  {
                                    Toast.makeText(getApplicationContext(), "Erro pra carregar os dados...", Toast.LENGTH_SHORT).show();
                                    error.printStackTrace();
                                }
                            });

                    queue.add(jsonObjReq);
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