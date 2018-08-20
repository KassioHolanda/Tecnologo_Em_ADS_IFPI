package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ListaCategoriaAPIModel {

    private int count;
    private String next;
    private String previus;
    private List<Categoria> results;

    public ListaCategoriaAPIModel() {
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

    public List<Categoria> getResults() {
        return results;
    }

}


