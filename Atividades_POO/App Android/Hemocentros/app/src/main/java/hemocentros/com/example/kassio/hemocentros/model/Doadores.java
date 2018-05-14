package hemocentros.com.example.kassio.hemocentros.model;

import android.support.annotation.NonNull;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by kassio on 3/23/2017.
 */

public class Doadores extends SugarRecord {
    private String nome;
    private String sexo;
    private String tipoDeSangue;
    private String contatos;



    public Doadores(){
    }

    public Doadores(String nome, String sexo, String tipoDeSangue, String contatos) {
        this.nome = nome;
        this.sexo = sexo;
        this.tipoDeSangue = tipoDeSangue;
        this.contatos = contatos;
    }


    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTipoDeSangue() {
        return tipoDeSangue;
    }

    public String getContatos() {
        return contatos;
    }

    @Override
    public String toString() {
        return nome;
    }


}
