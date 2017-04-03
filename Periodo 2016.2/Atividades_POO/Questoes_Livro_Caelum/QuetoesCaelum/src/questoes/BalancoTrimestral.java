package questoes;

public class BalancoTrimestral {
	public static void main(String[] args){
		double gastosJaneiro = 15000;
		double gastosFevereiro = 23000;
		double gastosMarco = 17000;
		double gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
		double mediaMensal = (gastosJaneiro + gastosFevereiro + gastosMarco)/3;
		System.out.println("o gasto do trimestre é de: " + gastosTrimestre + "a media mensal é de: " + mediaMensal);
		
	}
}


