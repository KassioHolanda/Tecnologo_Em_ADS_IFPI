package com.android.biblio.biblio.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Titulo {
    private long id;
    private String nome;
    private String descricao;
    private String isbn;
    private long autor;
    private int estoque;
    private long categoria;
    @SerializedName("preco_aluguel")
    private float precoAluguel;
    private long editora;
    private String ano;

    public Titulo(String nome, String descricao, String isbn, long autor, long categoria, float precoAluguel, long editora, String ano, int estoque) {
        this.nome = nome;
        this.estoque = estoque;
        this.descricao = descricao;
        this.isbn = isbn;
        this.estoque = estoque;
        this.precoAluguel = precoAluguel;
        this.ano = ano;
        this.editora = editora;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getEstoque() {
        return estoque;
    }

    public float getPrecoAluguel() {
        return precoAluguel;
    }

    public String getAno() {
        return ano;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setPrecoAluguel(float precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAutor() {
        return autor;
    }

    public long getCategoria() {
        return categoria;
    }

    public long getEditora() {
        return editora;
    }
}
