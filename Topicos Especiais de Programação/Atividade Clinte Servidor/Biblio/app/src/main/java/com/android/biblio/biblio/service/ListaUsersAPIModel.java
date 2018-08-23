package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Titulo;
import com.android.biblio.biblio.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ListaUsersAPIModel {
    private int count;
    private String next;
    private String previus;
    private List<Usuario> results;

    public ListaUsersAPIModel() {
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

    public List<Usuario> getResults() {
        return results;
    }
}
