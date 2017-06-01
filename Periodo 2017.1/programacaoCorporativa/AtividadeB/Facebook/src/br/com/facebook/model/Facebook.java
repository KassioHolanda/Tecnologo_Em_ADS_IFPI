package br.com.facebook.model;

import java.util.ArrayList;
import java.util.List;

public class Facebook {
	private List<Perfil> listaPerfis;
	private List<Grupos> listaGrupos;
	private FeedNoticias feedNoticias;
	private static Facebook instance;

	public static Facebook getInstance() {
		if (Facebook.instance == null) {
			Facebook.instance = new Facebook();
		}
		return instance;
	}

	public Facebook() {

	}

	public Facebook(FeedNoticias feedNoticias) {
		listaPerfis = new ArrayList<>();
		listaGrupos = new ArrayList<>();
		this.feedNoticias = feedNoticias;

	}

	public void adicionarPerfilBD(Perfil perfil) {
		listaPerfis.add(perfil);
	}
	
	public void adicionarGrupoBD(Grupos grupo){
		listaGrupos.add(grupo);
	}

	public FeedNoticias getFeedNoticias() {
		return feedNoticias;
	}

	public List<Perfil> getListaPerfis() {
		return listaPerfis;
	}

	public List<Grupos> getListaGrupos() {
		return listaGrupos;
	}
}
