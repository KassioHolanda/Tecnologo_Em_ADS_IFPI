package br.com.facebook.model.post;

import java.util.List;

public class Comentarios {
	private String comentario;
	private List<Resposta> respostaComentario;

	public Comentarios(String comentario) {
		this.comentario = comentario;
	}

	public void adicionarRespostaAoComentario(Resposta resposta) {
		respostaComentario.add(resposta);
	}

	public String getComentario() {
		return comentario;
	}

	public List<Resposta> getRespostaComentario() {
		return respostaComentario;
	}

}
