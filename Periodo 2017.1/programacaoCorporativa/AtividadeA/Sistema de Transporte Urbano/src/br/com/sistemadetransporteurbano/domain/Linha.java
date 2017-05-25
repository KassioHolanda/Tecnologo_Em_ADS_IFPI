package br.com.sistemadetransporteurbano.domain;

public class Linha {
	private Paradas paradas;
	private int numeroLinha;
	
	public Linha(Paradas paradas, int numeroLinha) {
		this.paradas = paradas;
		this.numeroLinha = numeroLinha;
	}
	
	
	public int getNumeroLinha() {
		return numeroLinha;
	}
	
	public Paradas getParadas() {
		return paradas;
	}
}
