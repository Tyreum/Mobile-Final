package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class Activity_Registrar extends AppCompatActivity {
    private Button btnNewRegister;
    private EditText txtEmail;
    private EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registrar);

        //API
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://10.0.2.2:5000/cadastrar";

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());

        txtEmail = (EditText) findViewById(R.id.etRegistrarEmail);
        txtSenha = (EditText) findViewById(R.id.etRegistrarSenha);


        btnNewRegister = (Button) findViewById(R.id.btnNewRegister);
        btnNewRegister.setOnClickListener(new View.OnClickListener() {
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
                                        Toast.makeText(getApplicationContext(), "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                                        openActivity_Registrar();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Ocorreu um erro ao registrar o usuário.", Toast.LENGTH_SHORT).show();
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
    public void openActivity_Registrar(){
        Intent intent = new Intent(this, Activity_Login.class);
        startActivity(intent);
    }
}