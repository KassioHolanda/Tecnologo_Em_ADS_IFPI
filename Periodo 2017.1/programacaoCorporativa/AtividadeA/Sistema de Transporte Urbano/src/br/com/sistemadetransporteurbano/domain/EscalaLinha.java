package br.com.sistemadetransporteurbano.domain;

public class EscalaLinha {
	private Onibus onibus;
	private String horarioViajens;
	private Paradas paradas;

	public EscalaLinha(Onibus onibus, String horarioViajens, Paradas paradas) {
		this.onibus = onibus;
		this.horarioViajens = horarioViajens;
		this.paradas = paradas;
	}

	public String getHorarioViajens() {
		return horarioViajens;
	}
	
	public Paradas getParadas() {
		return paradas;
	}
	
	public Onibus getOnibus() {
		return onibus;
	}

	
}
