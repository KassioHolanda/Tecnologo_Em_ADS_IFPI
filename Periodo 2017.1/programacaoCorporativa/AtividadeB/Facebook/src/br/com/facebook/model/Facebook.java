package br.com.facebook.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Facebook {

	private List<Perfil> listaPerfis;
	private List<Grupos> listaGrupos;
	private static Facebook instance;

	public static Facebook getInstance() {
		if (Facebook.instance == null) {
			Facebook.instance = new Facebook();
		}
		return instance;
	}

	public Facebook() {
		listaPerfis = new ArrayList<>();
		listaGrupos = new ArrayList<>();
	}

	public String mostrarFeed() {

		String historias = "FEED DE NOTICIAS\n\n";
		for (Perfil perfis : listaPerfis) {
			Iterator<Historia> iteratorFeed = perfis.getListaHistoria().iterator();
			while (iteratorFeed.hasNext()) {
				Historia historia = iteratorFeed.next();
				historias += perfis.getNome().toUpperCase() + "\nTitulo: " + historia.getTitulo() + "\n   Historia: "
						+ historia.getHistoria() + "\n\n";
			}
		}

		return historias;
	}

	public void excluirTodosAmigos(Perfil perfil) {
		perfil.getListaAmigos().clear();
	}

	public void alterarTipoAmizade(Perfil perfil, Perfil perfilAlterar, TipoAmigo tipoAmigo, String tipoAmizade) {
		perfil.getListaAmigos().get(perfilAlterar).setTipoAmigo(tipoAmizade);
	}

	public void adicionarPerfilBD(Perfil perfil) {
		listaPerfis.add(perfil);
	}

	public void adicionarGrupoBD(Grupos grupo) {
		listaGrupos.add(grupo);
	}

	public List<Perfil> getListaPerfis() {
		return listaPerfis;
	}

	public List<Grupos> getListaGrupos() {
		return listaGrupos;
	}
}
