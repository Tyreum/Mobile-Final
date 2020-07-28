package com.example.mobilefinal;

import java.util.Date;

public class Alimentos {
    private String nome;
    private String id;
    private Date validade;

    public Alimentos(){
    }

    public Alimentos(String nome, String id){
        this.nome = nome;
        this.id = id;
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

    public Date getValidade(){
        return validade;
    }

    public void setValidade(){
        this.validade = validade;
    }
}

