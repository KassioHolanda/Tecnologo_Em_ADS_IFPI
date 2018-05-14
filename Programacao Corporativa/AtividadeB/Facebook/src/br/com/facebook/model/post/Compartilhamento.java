package br.com.facebook.model.post;

import br.com.facebook.model.perfil.Perfil;

public class Compartilhamento {
	private Perfil perfilQueCompartilhou;
	private Post postCompartilhada;

	public Compartilhamento(Perfil perfilQueCompartilhou, Post postCompartilhado) {
		this.perfilQueCompartilhou.getListaPost().add(postCompartilhada);
	}

	public Post getPostCompartilhada() {
		return postCompartilhada;
	}

	public Perfil getPerfilQueCompartilhou() {
		return perfilQueCompartilhou;
	}

}
