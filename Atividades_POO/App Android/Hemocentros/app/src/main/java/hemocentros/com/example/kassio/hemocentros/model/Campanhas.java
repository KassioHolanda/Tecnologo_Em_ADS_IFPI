package hemocentros.com.example.kassio.hemocentros.model;

import com.orm.SugarRecord;

import java.util.Calendar;

/**
 * Created by kassio on 29/03/17.
 */

public class Campanhas extends SugarRecord{

    private String descricao;
    private String tipoSangue;
    private int dia;
    private int mes;
    private int ano;


    public Campanhas(){

    }

    public Campanhas(String descricao, String tipoSangue, int dia, int mes, int ano){
        this.descricao = descricao;
        this.tipoSangue = tipoSangue;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoSangue() {
        return tipoSangue;
    }

    public void setTipoSangue(String tipoSangue) {
        this.tipoSangue = tipoSangue;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
