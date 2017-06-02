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
	private Calendar dataHistoria;

	public Post(String titulo, String historia, Perfil marcarPerfil) {
		this.titulo = titulo;
		this.marcarPerfil = marcarPerfil;
		this.listaDeComentarios = new ArrayList<>();
		this.dataHistoria = Calendar.getInstance();
		listaDeComentarios = new ArrayList<>();
		listaDeCurtidas = new ArrayList<>();
		listaCompartilhamento = new ArrayList<>();
	}

	public Post(String titulo, String historia) {
		this.titulo = titulo;
		this.historia = historia;
		this.marcarPerfil = null;
		this.listaDeComentarios = new ArrayList<>();
		this.dataHistoria = Calendar.getInstance();
		listaDeComentarios = new ArrayList<>();
		listaDeCurtidas = new ArrayList<>();
		listaCompartilhamento = new ArrayList<>();
	}
	
	public void curtirPost(Post post, String tipoCurtida){
		TipoCurtida tipoCurt = new TipoCurtida(tipoCurtida);
		listaDeCurtidas.add(tipoCurt);
	}

	public void comentarPost(Post post, String comentario){
		Comentarios coment = new Comentarios(comentario);
		listaDeComentarios.add(coment);
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

	public Calendar getDataHistoria() {
		return dataHistoria;
	}

	public String getHistoria() {
		return historia;
	}
}
