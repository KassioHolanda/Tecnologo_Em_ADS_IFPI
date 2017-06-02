package br.com.facebook.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Post {
	private String titulo;
	private String historia;
	private Perfil marcarPerfil;
	private List<Comentarios> listaDeComentarios;
	private List<TipoCurtida> listaDeQualificacoes;
	private List<Compartilhamento> listaCompartilhamento;
	private Calendar dataHistoria;

	public Post(String titulo, String historia, Perfil marcarPerfil) {
		this.titulo = titulo;
		this.marcarPerfil = marcarPerfil;
		this.listaDeComentarios = new ArrayList<>();
		this.dataHistoria = Calendar.getInstance();
		listaDeComentarios = new ArrayList<>();
		listaDeQualificacoes = new ArrayList<>();
		listaCompartilhamento = new ArrayList<>();
	}

	public Post(String titulo, String historia) {
		this.titulo = titulo;
		this.historia = historia;
		this.marcarPerfil = null;
		this.listaDeComentarios = new ArrayList<>();
		this.dataHistoria = Calendar.getInstance();
		listaDeComentarios = new ArrayList<>();
		listaDeQualificacoes = new ArrayList<>();
		listaCompartilhamento = new ArrayList<>();
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

	public List<TipoCurtida> getListaDeQualificacoes() {
		return listaDeQualificacoes;
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
