package br.com.facebook.model;

public class Compartilhamento {
	private Perfil perfilQueCompartilhou;
	private Post historiaCompartilhada;

	public Compartilhamento(Perfil perfilQueCompartilhou, Post historiaCompartilhada) {
		this.perfilQueCompartilhou.getListaHistoria().add(historiaCompartilhada);
	}

	public Post getHistoriaCompartilhada() {
		return historiaCompartilhada;
	}

	public Perfil getPerfilQueCompartilhou() {
		return perfilQueCompartilhou;
	}

}
