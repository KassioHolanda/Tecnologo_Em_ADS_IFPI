package br.com.sistemadetransporteurbano.domain;

public class Linha {
	private EscalaLinha escalaLinha;
	private int numeroLinha;
	
	public Linha(EscalaLinha escalaLinhas, int numeroLinha) {
		this.numeroLinha = numeroLinha;
		this.escalaLinha = escalaLinhas;
	}
	
	
	public int getNumeroLinha() {
		return numeroLinha;
	}
	
	public EscalaLinha getEscalaLinha() {
		return escalaLinha;
	}
}
