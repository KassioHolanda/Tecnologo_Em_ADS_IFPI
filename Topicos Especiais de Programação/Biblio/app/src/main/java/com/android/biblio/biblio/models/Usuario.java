package com.android.biblio.biblio.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Usuario {
    @SerializedName("id")
    private long id;
    private String username;
    private String email;
    private String nome;
    @SerializedName("tipo_usuario")
    private String tipoUsuario;
    @SerializedName("password")
    private String senha;
    @SerializedName("minhas_reservas")
    private List<Reserva> minhasReservas;
    @SerializedName("meus_emprestimos")
    private List<Emprestimo> meusEmprestimos;


    public Usuario(String username, String senha) {
        this.username = username;
//        this.email = email;
//        this.nome = nome;
        this.senha = senha;
//        this.tipoUsuario = "USUÁRIO";
    }

    public Usuario(String username, String email, String nome, String tipoUsuario, String senha) {
        this.username = username;
        this.email = email;
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public List<Reserva> getMinhasReservas() {
        return minhasReservas;
    }

    public List<Emprestimo> getMeusEmprestimos() {
        return meusEmprestimos;
    }
}
