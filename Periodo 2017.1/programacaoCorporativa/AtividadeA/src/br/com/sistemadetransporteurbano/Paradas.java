package br.com.sistemadetransporteurbano;

public class Paradas {
	private int identificadorParada;
	private String bairroParada;
	
	public Paradas(int identificadorParada, String bairroParada) {
		this.identificadorParada = identificadorParada;
		this.bairroParada = bairroParada;
	}
	
	public String getBairroParada() {
		return bairroParada;
	}
	
	public int getIdentificadorParada() {
		return identificadorParada;
	}
}
