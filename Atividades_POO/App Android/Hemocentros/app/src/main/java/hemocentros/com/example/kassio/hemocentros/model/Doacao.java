package hemocentros.com.example.kassio.hemocentros.model;

import android.support.annotation.NonNull;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by kassio on 3/23/2017.
 */

public class Doacao extends SugarRecord implements Comparable<Doacao>{

    private Calendar calendar;
    private Doadores doador;
    private String hospital;
    private Campanhas campanha;
    private int quantidadeBolsas;

    private int qntSangueAP = 0;
    private int qntSangueAN = 0;
    private int qntSangueBP = 0;
    private int qntSangueBN = 0;
    private int qntSangueABP = 0;
    private int qntSangueABN = 0;
    private int qntSangueOP = 0;
    private int qntSangueON = 0;

    public Doacao(){

    }

    public Doacao(int quantidadeBolsas, Doadores doador, String hospital, Campanhas campanhas){
        this.quantidadeBolsas = quantidadeBolsas;
        this.doador = doador;
        this.hospital = hospital;
        this.campanha = campanhas;
        calendar = Calendar.getInstance();
    }

    public int getQuantidadeBolsas() {
        quantidadeBolsas = getQntSangueAP()+getQntSangueAN()+getQntSangueBP()+getQntSangueBN()+getQntSangueABP()+getQntSangueABN()+getQntSangueOP()+getQntSangueON();
        return quantidadeBolsas;
    }

    public void setQuantidadeBolsas(int quantidadeBolsas) {
        this.quantidadeBolsas += quantidadeBolsas;
    }

    public String getHospital() {
        return hospital;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Doadores getDoador(){
        return doador;
    }

    public Campanhas getCampanha() {
        return campanha;
    }





    public void setQntSangueAP(int qntSangueAP) {
        this.qntSangueAP += qntSangueAP;
    }

    public void setQntSangueAN(int qntSangueAN) {
        this.qntSangueAN += qntSangueAN;
    }

    public void setQntSangueBP(int qntSangueBP) {
        this.qntSangueBP += qntSangueBP;
    }

    public void setQntSangueBN(int qntSangueBN) {
        this.qntSangueBN += qntSangueBN;
    }

    public void setQntSangueABP(int qntSangueABP) {
        this.qntSangueABP += qntSangueABP;
    }

    public void setQntSangueABN(int qntSangueABN) {
        this.qntSangueABN += qntSangueABN;
    }

    public void setQntSangueOP(int qntSangueOP) {
        this.qntSangueOP += qntSangueOP;
    }

    public void setQntSangueON(int qntSangueON) {
        this.qntSangueON += qntSangueON;
    }


    public int getQntSangueAP() {
        return qntSangueAP;
    }

    public int getQntSangueAN() {
        return qntSangueAN;
    }

    public int getQntSangueBP() {
        return qntSangueBP;
    }

    public int getQntSangueBN() {
        return qntSangueBN;
    }

    public int getQntSangueABP() {
        return qntSangueABP;
    }

    public int getQntSangueABN() {
        return qntSangueABN;
    }

    public int getQntSangueOP() {
        return qntSangueOP;
    }

    public int getQntSangueON() {
        return qntSangueON;
    }



    @Override
    public int compareTo(@NonNull Doacao o) {
        if(this.quantidadeBolsas < o.quantidadeBolsas){
            return -1;
        }
        if(this.quantidadeBolsas > o.quantidadeBolsas){
            return 1;
        }
        return 0;
    }
}

