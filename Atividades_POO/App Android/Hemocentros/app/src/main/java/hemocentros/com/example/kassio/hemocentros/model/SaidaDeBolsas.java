package hemocentros.com.example.kassio.hemocentros.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by kassio on 29/03/17.
 */

public class SaidaDeBolsas extends SugarRecord {

    private String hospital;
    private int dia;
    private int mes;
    private int ano;

    private int qntSangueAP;
    private int qntSangueAN;
    private int qntSangueBP;
    private int qntSangueBN;
    private int qntSangueABP;
    private int qntSangueABN;
    private int qntSangueOP;
    private int qntSangueON;


    public SaidaDeBolsas(){

    }

    public SaidaDeBolsas(String hospital, int qntSangue){
        this.hospital = hospital;
        this.dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.mes = Calendar.getInstance().get(Calendar.MONTH);
        this.ano = Calendar.getInstance().get(Calendar.YEAR);
    }

}
