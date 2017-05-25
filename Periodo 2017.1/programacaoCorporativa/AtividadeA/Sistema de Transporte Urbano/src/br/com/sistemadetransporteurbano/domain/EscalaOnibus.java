package br.com.sistemadetransporteurbano.domain;

public class EscalaOnibus {
	private String horarioViajens;
	private Linha linha;

	public EscalaOnibus(String horarioViajens, Linha linha) {
		this.horarioViajens = horarioViajens;
		this.linha = linha;
	}

	public String getHorarioViajens() {
		return horarioViajens;
	}

	public Linha getLinha() {
		return linha;
	}
}
