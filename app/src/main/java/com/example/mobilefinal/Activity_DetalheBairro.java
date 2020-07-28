package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Activity_DetalheBairro extends AppCompatActivity {
    private Button btnVoltar;
    private TextView lstNomeBairros;
    private TextView lstIdBairros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detalhe_bairro);

        //Config da Lista
        lstIdBairros = (TextView) findViewById(R.id.idBairro);
        lstNomeBairros = (TextView) findViewById(R.id.nomeBairro);

        Intent intent = getIntent();
        String nomeReturn = intent.getStringExtra("name");
        String idReturn = intent.getStringExtra("id");

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