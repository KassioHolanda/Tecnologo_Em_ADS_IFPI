package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ListaReservaAPIModel {

    private int count;
    private String next;
    private String previus;
    private List<Reserva> results;

    public ListaReservaAPIModel() {
        this.results = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevius() {
        return previus;
    }

    public List<Reserva> getResults() {
        return results;
    }

}
