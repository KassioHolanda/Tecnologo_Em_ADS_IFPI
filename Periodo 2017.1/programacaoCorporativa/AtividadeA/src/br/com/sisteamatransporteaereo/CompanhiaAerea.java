package br.com.sisteamatransporteaereo;

public class CompanhiaAerea {
	private int numeroIdentificador;
	private int numeroVagas;
	private EscalaAviao escalaAviao;
	
	public CompanhiaAerea(int numeroIdentificador, int numeroVagas, EscalaAviao escalaAviao) {
		this.numeroIdentificador = numeroIdentificador;
		this.escalaAviao = escalaAviao;
	}

	public int getNumeroIdentificador() {
		return numeroIdentificador;
	}

	public int getNumeroVagas() {
		return numeroVagas;
	}

	public EscalaAviao getEscalaAviao() {
		return escalaAviao;
	}	
}
