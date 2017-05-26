package br.com.sisteamatransporteaereo.domain;

public class EscalaAviao {
	private String horarioDeSaida;
	private String localDeSaida;
	private String rota;
	private String destino;

	public EscalaAviao(String horarioDeSaida, String localDeSaida, String rota, String destino) {
		this.horarioDeSaida = horarioDeSaida;
		this.rota = rota;
		this.destino = destino;
		this.localDeSaida = localDeSaida;
	}

	public String getHorario() {
		return horarioDeSaida;
	}

	public String getRota() {
		return rota;
	}

	public String getDestino() {
		return destino;
	}
	
	public String getHorarioDeSaida() {
		return horarioDeSaida;
	}
	
	public String getLocalDeSaida() {
		return localDeSaida;
	}
	
}
