package br.com.facebook.model;

import java.util.ArrayList;
import java.util.List;

public class Configuracoes {
	private PermitirComentar permitirComentar;
	private PermitirCurtir permitirCurtir;
	private PermitirCompartilhar permitirCompartilhar;
	private List<Perfil> listaPerfisBloqueados;
	private String senha;

	public Configuracoes(String senha) {
		listaPerfisBloqueados = new ArrayList<>();
		permitirCurtir = new PermitirCurtir();
		permitirComentar = new PermitirComentar();
		permitirCompartilhar = new PermitirCompartilhar();
		this.senha = senha;
	}

	public void bloquearPerfil(Perfil perfil) {
		listaPerfisBloqueados.add(perfil);
	}

	public void removerPerfilBloqueado(Perfil perfil) {
		listaPerfisBloqueados.remove(perfil);
	}

	public PermitirCurtir getPermitirCurtir() {
		return permitirCurtir;
	}
	
	public List<Perfil> getListaPerfisBloqueados() {
		return listaPerfisBloqueados;
	}

	public String getSenha() {
		return senha;
	}

	public PermitirComentar getPermitirComentar() {
		return permitirComentar;
	}
	
	public PermitirCompartilhar getPermitirCompartilhar() {
		return permitirCompartilhar;
	}
}
