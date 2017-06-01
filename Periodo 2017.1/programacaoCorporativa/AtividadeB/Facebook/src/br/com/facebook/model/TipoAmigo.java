package br.com.facebook.model;

public class TipoAmigo {
	private String tipoAmigo;
	
	public TipoAmigo(String tipoAmigo) {
		this.tipoAmigo = tipoAmigo;
	}
	
	public TipoAmigo(){
		this.tipoAmigo = "Padrao";
	}
	
	public String getTipoAmigo() {
		return tipoAmigo;
	}
}
