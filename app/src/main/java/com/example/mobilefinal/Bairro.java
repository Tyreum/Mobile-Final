package com.example.mobilefinal;

public class Bairro {
    private String nome;
    private String id;

    public Bairro(){
    }

    public Bairro(String nome, String id){
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
