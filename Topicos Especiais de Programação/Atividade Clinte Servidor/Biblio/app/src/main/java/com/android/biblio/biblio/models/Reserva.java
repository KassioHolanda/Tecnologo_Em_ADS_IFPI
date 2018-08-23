package com.android.biblio.biblio.models;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.Date;

public class Reserva {
    @SerializedName("id")
    private long id;
    @SerializedName("titulo")
    private long titulo;
    @SerializedName("usuario")
    private long usuario;
    @SerializedName("data_reserva")
    private Date dataReserva;
    private boolean ative;

    public Reserva(long titulo, long usuario, Date dataReserva, boolean ative) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.dataReserva = dataReserva;
        this.ative = ative;
    }

    public long getId() {
        return id;
    }

    public long getTitulo() {
        return titulo;
    }

    public long getUsuario() {
        return usuario;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public boolean isAtive() {
        return ative;
    }
}
