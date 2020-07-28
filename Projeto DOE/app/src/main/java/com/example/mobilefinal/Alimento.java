package com.example.mobilefinal;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Alimento {
    private String nome;
    private String id;

    //Converção da Data
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String validade = dateFormat.format(date);

    public Alimento(){
    }

    public Alimento(String nome, String id, String validade){
        this.nome = nome;
        this.id = id;
        this.validade = validade;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getId(){
        return id;
    }

    public void setId(){
        this.id = id;
    }

    public String getValidade(){
        return validade;
    }

    public void setValidade(){
        this.validade = validade;
    }
}
