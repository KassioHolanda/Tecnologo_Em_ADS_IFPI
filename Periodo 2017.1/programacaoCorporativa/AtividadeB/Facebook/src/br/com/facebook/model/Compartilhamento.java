package br.com.facebook.model;

public class Compartilhamento {
	private Perfil perfilQueCompartilhou;
	private Historia historiaCompartilhada;
	
	public Compartilhamento(Perfil perfilQueCompartilhou, Historia historiaCompartilhada) {
		this.perfilQueCompartilhou.getListaHistoria().add(historiaCompartilhada);
	}
	
	public Historia getHistoriaCompartilhada() {
		return historiaCompartilhada;
	}
	
	public Perfil getPerfilQueCompartilhou() {
		return perfilQueCompartilhou;
	}
	
}
