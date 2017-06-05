package br.com.facebook.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Post {
	private String titulo;
	private String historia;
	private Perfil marcarPerfil;
	private List<Comentarios> listaDeComentarios;
	private List<TipoCurtida> listaDeCurtidas;
	private List<Compartilhamento> listaCompartilhamento;
	private Calendar dataPost;

	public Post(String titulo, String historia, Perfil marcarPerfil) {
		this.titulo = titulo;
		this.marcarPerfil = marcarPerfil;
		this.listaDeComentarios = new ArrayList<>();
		this.dataPost = Calendar.getInstance();
		listaDeComentarios = new ArrayList<>();
		listaDeCurtidas = new ArrayList<>();
		listaCompartilhamento = new ArrayList<>();
	}

	public Post(String titulo, String historia) {
		this.titulo = titulo;
		this.historia = historia;
		this.marcarPerfil = null;
		this.listaDeComentarios = new ArrayList<>();
		this.dataPost = Calendar.getInstance();
		listaDeComentarios = new ArrayList<>();
		listaDeCurtidas = new ArrayList<>();
		listaCompartilhamento = new ArrayList<>();
	}

	public void curtirPost(Perfil perfilCurtiu, Perfil perfilPostou, Post post, String tipoCurtida) {
		if (perfilPostou.getConfiguracoes().getPermitirCurtirFotos().isPermitirCurtirFotos()
				&& !perfilPostou.getConfiguracoes().getListaPerfisBloqueados().contains(perfilCurtiu)) {
			TipoCurtida tipoCurt = new TipoCurtida(tipoCurtida);
			listaDeCurtidas.add(tipoCurt);
		}
	}

	public void comentarPost(Perfil perfilComentou, Perfil perfilPostou, Post post, String comentario) {
		if (perfilPostou.getConfiguracoes().getPermitirCurtirFotos().isPermitirCurtirFotos()
				&& !perfilPostou.getConfiguracoes().getListaPerfisBloqueados().contains(perfilComentou)) {
			Comentarios coment = new Comentarios(comentario);
			listaDeComentarios.add(coment);
		}
	}

	public void compartilharPost(Perfil perfilCompartilhou, Perfil perfilPostou, Post post, String comentario) {
		if (perfilPostou.getConfiguracoes().getPermitirCompartilharFotos().isPermitir()
				&& !perfilPostou.getConfiguracoes().getListaPerfisBloqueados().contains(perfilCompartilhou)) {
			Compartilhamento compartilhamento = new Compartilhamento(perfilCompartilhou, this);
			listaCompartilhamento.add(compartilhamento);
			perfilCompartilhou.getListaPost().add(this);
		}
	}

	public List<Comentarios> getListaDeComentarios() {
		return listaDeComentarios;
	}

	public Perfil getMarcarPerfil() {
		return marcarPerfil;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<TipoCurtida> getListaDeCurtidas() {
		return listaDeCurtidas;
	}

	public List<Compartilhamento> getListaCompartilhamento() {
		return listaCompartilhamento;
	}

	public Calendar getDataPost() {
		return dataPost;
	}

	public String getHistoria() {
		return historia;
	}
}
