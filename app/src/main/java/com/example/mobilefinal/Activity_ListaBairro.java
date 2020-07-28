package com.example.mobilefinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_ListaBairro extends AppCompatActivity {
    ListView listView;
    private Button btnVoltar;

    String[] nomeBairros = {"Grajaú","Veleiros","Jordanópolis","jardim Aeroporto","Varginha","Parelheiros"};
    String[] idBairros = {"1","2","3","4","5","6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_bairro);

        listView = findViewById(R.id.ListaBairros);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Activity_DetalheBairro.class);
                intent.putExtra("name",nomeBairros[position]);
                intent.putExtra("id", idBairros[position]);
                startActivity(intent);
            }
        });

        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity_Home();
            }
        });
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return idBairros.length;
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

            View view1 = getLayoutInflater().inflate(R.layout.load_bairros, null);

            TextView name = (TextView) view1.findViewById(R.id.lstnomeBairro);
            TextView id = (TextView) view1.findViewById(R.id.lstidBairro);

            name.setText(nomeBairros[position]);
            id.setText(idBairros[position]);


            return view1;
        }
    }

    public void openActivity_Home(){
        Intent intent = new Intent(this, Activity_Home.class);
        startActivity(intent);
    }

}