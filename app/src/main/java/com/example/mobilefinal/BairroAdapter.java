package com.example.mobilefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BairroAdapter extends ArrayAdapter<Bairro>{

    private final Context context;
    private final ArrayList<Bairro> bairros;

    public BairroAdapter(Context context, ArrayList<Bairro> bairros) {
        super(context, R.layout.layout_lista_bairro, bairros);
        this.context = context;
        this.bairros = bairros;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.load_bairros, parent, false);
        TextView nomeBairro = (TextView) rowView.findViewById(R.id.lstnomeBairro);
        TextView id = (TextView) rowView.findViewById(R.id.lstnomeBairro);

        nomeBairro.setText(bairros.get(position).getNome());
        id.setText(bairros.get(position).getId());

        return rowView;
    }

}
