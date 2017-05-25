package br.com.sisteamatransporteaereo;

public class EscalaAviao {
	private String horario;
	private String rota;
	private String destino;
	
	public EscalaAviao(String horario, String rota, String destino) {
		this.horario = horario;
		this.rota = rota;
		this.destino = destino;
	}

	public String getHorario() {
		return horario;
	}

	public String getRota() {
		return rota;
	}

	public String getDestino() {
		return destino;
	}	
}
