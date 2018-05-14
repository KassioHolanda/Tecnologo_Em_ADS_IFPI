package hemocentros.com.example.kassio.hemocentros.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by kassio on 3/23/2017.
 */

public class Hospital extends SugarRecord implements Serializable {
    private String nome;
    private String contatos;

    public Hospital(){
    }

    public Hospital(String nome, String contatos){
        this.nome = nome;
        this.contatos = contatos;
    }

    public String getNome() {
        return nome;
    }

    public String getContatos() {
        return contatos;
    }

    @Override
    public String toString() {
        return this.nome;
    }


}
