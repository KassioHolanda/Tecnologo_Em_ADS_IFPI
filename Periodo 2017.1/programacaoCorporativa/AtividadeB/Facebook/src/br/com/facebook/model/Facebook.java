package br.com.facebook.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.facebook.model.perfil.Grupos;
import br.com.facebook.model.perfil.Perfil;
import br.com.facebook.model.post.Post;

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
			Iterator<Post> iteratorFeed = perfis.getListaPost().iterator();
			while (iteratorFeed.hasNext()) {
				Post historia = iteratorFeed.next();
				historias += perfis.getNome().toUpperCase() + "\nTitulo: " + historia.getTitulo() + "\n   Historia: "
						+ historia.getHistoria() + "\n Curtidas: " + historia.getListaDeCurtidas().size()+"\n\n";
			}
		}
		return historias;
	}

	public void excluirTodosAmigos(Perfil perfil) {
		perfil.getListaAmigos().clear();
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
