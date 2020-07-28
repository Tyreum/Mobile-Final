package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Activity_AddBairro extends AppCompatActivity {
    private Button btnVoltar;
    private Button btnAdicionar;
    private EditText txtBairro;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_bairro);

        //API
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://10.0.2.2:5000/bairro";


        //config de requisição
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());


        //Elementos da activity
        txtBairro = (EditText) findViewById(R.id.etAddBairro);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Home();
            }
        });

        btnAdicionar = (Button) findViewById(R.id.btnAdicionarBairro);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject postparams = new JSONObject();
                try {
                    postparams.put("nome", txtBairro.getText());
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
                                        Toast.makeText(getApplicationContext(), "Bairro cadastrado com sucesso!!", Toast.LENGTH_SHORT).show();
                                        openActivity_Home();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Erro ao cadastrar bairro.", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {

                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error)  {
                                Toast.makeText(getApplicationContext(), "Erro de comunicação com o servidor...", Toast.LENGTH_SHORT).show();
                                error.printStackTrace();
                            }
                        });

                queue.add(jsonObjReq);
            }
        });
    }

    public void openActivity_Home(){
        Intent intent = new Intent(this, Activity_Home.class);
        startActivity(intent);
    }

}