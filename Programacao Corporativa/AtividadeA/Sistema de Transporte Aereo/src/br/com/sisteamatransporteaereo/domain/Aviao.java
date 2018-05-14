package br.com.sisteamatransporteaereo.domain;

public class Aviao {
	private int numeroIdentificador;
	private int numeroVagas;
	private EscalaAviao escalaAviao;
	
	public Aviao(int numeroIdentificador, int numeroVagas, EscalaAviao escalaAviao) {
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
