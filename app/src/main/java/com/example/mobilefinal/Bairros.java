package com.example.mobilefinal;

public class Bairros {
    private String nome;
    private String id;

    public Bairros(){
    }

    public Bairros(String nome, String id){
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
}
