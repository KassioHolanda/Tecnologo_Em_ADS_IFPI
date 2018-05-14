package br.com.sisteamatransporteaereo.domain;

public class SistemaAeroporto {
	private Aeroporto aeroporto;
	
	public SistemaAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}
	
	public Aeroporto getAeroporto() {
		return aeroporto;
	}
}
