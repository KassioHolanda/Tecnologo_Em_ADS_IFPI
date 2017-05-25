package br.com.sistemadetransporteurbano.domain;

public class Onibus {
	private int numeroIdentificador;
	private EscalaOnibus escalaOnibus;
	
	public Onibus(int numeroIdentficador, EscalaOnibus escalaOnibus) {
		this.numeroIdentificador = numeroIdentficador;
		this.escalaOnibus = escalaOnibus;
	}

	public int getNumeroIdentificador() {
		return numeroIdentificador;
	}

	public EscalaOnibus getEscalaOnibus() {
		return escalaOnibus;
	}
}
