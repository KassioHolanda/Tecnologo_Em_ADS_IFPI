package br.com.facebook.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FeedNoticias {
	private Perfil perfis;
	private List<Perfil> listaPerfis;
	private List<Historia> feedNoticias;
	private Iterator<Historia> perfisIterator;

	public FeedNoticias() {
		listaPerfis = new ArrayList<>();
		feedNoticias = new ArrayList<>();
		carregarFeedNoticias();
	}

	public void carregarFeedNoticias() {
		perfisIterator = perfis.getListaHistoria().iterator();
		while (perfisIterator.hasNext()) {
			Historia historias = perfisIterator.next();
			feedNoticias.add(historias);
		}
	}

	public Perfil getPerfis() {
		return perfis;
	}

	public List<Historia> getFeedNoticias() {
		return feedNoticias;
	}

	public List<Perfil> getListaPerfis() {
		return listaPerfis;
	}

	public Iterator<Historia> getPerfisIterator() {
		return perfisIterator;
	}
}
