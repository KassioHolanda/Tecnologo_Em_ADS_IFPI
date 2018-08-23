package com.android.biblio.biblio.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Livro {
    private long id;
    private int numero;
    private Titulo titulo;
    @SerializedName("data_cadastro")
    private Date dataCadastro;

    public Livro(int numero, Titulo titulo, Date dataCadastro) {
        this.numero = numero;
        this.titulo = titulo;
        this.dataCadastro = dataCadastro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getNumero() {
        return numero;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }
}
