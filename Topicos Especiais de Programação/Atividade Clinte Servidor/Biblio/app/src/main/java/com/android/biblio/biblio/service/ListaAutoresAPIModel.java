package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Titulo;

import java.util.ArrayList;
import java.util.List;

public class ListaAutoresAPIModel {

    private int count;
    private String next;
    private String previus;
    private List<Autor> results;

    public ListaAutoresAPIModel() {
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

    public List<Autor> getResults() {
        return results;
    }

}
