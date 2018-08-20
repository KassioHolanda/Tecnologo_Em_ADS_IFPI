package com.android.biblio.biblio.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Emprestimo {
    @SerializedName("id")
    private long id;
    @SerializedName("usuario")
    private long usuario;
    @SerializedName("quantidade_dias")
    private int quantidadeDias;
    @SerializedName("data_emprestimo")
    private Date dataEmprestimo;
    @SerializedName("data_devolucao")
    private Date dataDevolucao;
    @SerializedName("titulo")
    private long titulo;

    public Emprestimo(long titulo, long usuario, int quantidadeDias, Date dataEmprestimo) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.quantidadeDias = quantidadeDias;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
    }


    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public long getUsuario() {
        return usuario;
    }

    public long getTitulo() {
        return titulo;
    }
}
