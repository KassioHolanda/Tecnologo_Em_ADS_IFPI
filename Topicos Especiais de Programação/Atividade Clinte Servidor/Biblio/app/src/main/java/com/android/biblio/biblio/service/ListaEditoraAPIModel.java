package com.android.biblio.biblio.service;

import android.text.Editable;

import com.android.biblio.biblio.models.Autor;
import com.android.biblio.biblio.models.Editora;

import java.util.ArrayList;
import java.util.List;

public class ListaEditoraAPIModel {
    private int count;
    private String next;
    private String previus;
    private List<Editora> results;

    public ListaEditoraAPIModel() {
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

    public List<Editora> getResults() {
        return results;
    }
}
