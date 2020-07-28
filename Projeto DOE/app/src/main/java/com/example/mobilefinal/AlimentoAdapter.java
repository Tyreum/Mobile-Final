package com.example.mobilefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AlimentoAdapter extends ArrayAdapter<Alimento> {

    private final Context context;
    private final ArrayList<Alimento> alimentos;

    public AlimentoAdapter(Context context, ArrayList<Alimento> alimentos) {
        super(context, R.layout.layout_detalhe_bairro, alimentos);
        this.context = context;
        this.alimentos = alimentos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.load_alimentos, parent, false);
        TextView nomeBairro = (TextView) rowView.findViewById(R.id.lstnomeAlimento);
        TextView id = (TextView) rowView.findViewById(R.id.lstnomeAlimento);
        TextView validade = (TextView) rowView.findViewById(R.id.lstvalidadeAlimento);

        nomeBairro.setText(alimentos.get(position).getNome());
        id.setText(alimentos.get(position).getId());
        validade.setText(alimentos.get(position).getValidade());

        return rowView;
    }

}
