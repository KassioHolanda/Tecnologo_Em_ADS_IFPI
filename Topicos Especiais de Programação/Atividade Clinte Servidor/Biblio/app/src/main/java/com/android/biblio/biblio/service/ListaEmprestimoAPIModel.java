package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Editora;
import com.android.biblio.biblio.models.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class ListaEmprestimoAPIModel {
    private int count;
    private String next;
    private String previus;
    private List<Emprestimo> results;

    public ListaEmprestimoAPIModel() {
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

    public List<Emprestimo> getResults() {
        return results;
    }
}

