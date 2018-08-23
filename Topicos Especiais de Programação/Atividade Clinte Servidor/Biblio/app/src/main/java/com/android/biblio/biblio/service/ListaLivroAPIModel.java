package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Livro;
import com.android.biblio.biblio.models.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ListaLivroAPIModel {

    private int count;
    private String next;
    private String previus;
    private List<Livro> results;

    public ListaLivroAPIModel() {
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

    public List<Livro> getResults() {
        return results;
    }

}
