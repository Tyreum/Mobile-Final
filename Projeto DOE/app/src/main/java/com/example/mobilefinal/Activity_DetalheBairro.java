package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Activity_DetalheBairro extends AppCompatActivity {
    //Variáveis de Navegação
    private Button btnVoltar;

    //Variáveis TextView dos Bairros
    private TextView lstNomeBairros;
    private TextView lstIdBairros;

    //Variáveis Lista dos Alimentos
    private RequestQueue requestQueue;

    private TextView nomeAlimento;
    private TextView idAlimento;
    private TextView validadeAlimento;

    private ListView listView;
    String[] nomeAlimentos = new String[20];
    String[] idAlimentos = new String[20];
    String[] validadeAlimentos = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalhe_bairro);


        Intent intent = getIntent();
        String nomeReturn = intent.getStringExtra("name");
        String idReturn = intent.getStringExtra("id");

        //API
        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://10.0.2.2:5000/alimentos/"+idReturn;

        listView = findViewById(R.id.ListaAlimentos);

        // Requisição
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++){
                                JSONObject obj = response.getJSONObject(i);
                                String nome = obj.getString("alimento");
                                String id = obj.getString("id");
                                String validade = obj.getString("validade");

                                nomeAlimentos[i] = nome;
                                idAlimentos[i] = id;
                                validadeAlimentos[i] = validade;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Erro ao carregar dados...", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        queue.add(jsonArrayRequest);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Activity_DetalheBairro.class);
                intent.putExtra("name",nomeAlimentos[position]);
                intent.putExtra("id", idAlimentos[position]);
                intent.putExtra("validade", validadeAlimentos[position]);
                startActivity(intent);
            }
        });

        //POPANDO INFORMAÇÃO DA LISTA DOS BAIRROS
        //Config da Lista
        lstIdBairros = (TextView) findViewById(R.id.idBairro);
        lstNomeBairros = (TextView) findViewById(R.id.nomeBairro);

        lstNomeBairros.setText(nomeReturn);
        lstIdBairros.setText(idReturn);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Navegação
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_ListaBairro();
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return idAlimentos.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1 = getLayoutInflater().inflate(R.layout.load_alimentos, null);

            TextView name = view1.findViewById(R.id.lstnomeAlimento);
            TextView id = view1.findViewById(R.id.lstidAlimento);
            TextView validade = view1.findViewById(R.id.lstvalidadeAlimento);

            name.setText(nomeAlimentos[position]);
            id.setText(idAlimentos[position]);
            id.setText(validadeAlimentos[position]);

            return view1;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void openActivity_ListaBairro(){
        Intent intent = new Intent(this, Activity_ListaBairro.class);
        startActivity(intent);
    }
}