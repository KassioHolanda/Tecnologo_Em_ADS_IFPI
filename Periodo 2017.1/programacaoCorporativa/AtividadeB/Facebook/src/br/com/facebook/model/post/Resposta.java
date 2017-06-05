package br.com.facebook.model.post;

import br.com.facebook.model.perfil.Perfil;

public class Resposta {
	private String resposta;
	private Perfil marcarPerfil;

	public Resposta(String resposta, Perfil marcarPerfil) {
		this.resposta = resposta;
		this.marcarPerfil = marcarPerfil;
	}

	public Resposta(String resposta) {
		this.resposta = resposta;
	}

	public Perfil getMarcarPerfil() {
		return marcarPerfil;
	}

	public String getResposta() {
		return resposta;
	}
}
