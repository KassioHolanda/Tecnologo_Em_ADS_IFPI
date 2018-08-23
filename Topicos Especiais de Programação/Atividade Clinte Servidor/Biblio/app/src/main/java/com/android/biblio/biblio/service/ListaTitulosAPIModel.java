package com.android.biblio.biblio.service;

import com.android.biblio.biblio.models.Titulo;

import java.util.ArrayList;
import java.util.List;

public class ListaTitulosAPIModel {
    private int count;
    private String next;
    private String previus;
    private List<Titulo> results;

    public ListaTitulosAPIModel() {
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

    public List<Titulo> getResults() {
        return results;
    }
}
