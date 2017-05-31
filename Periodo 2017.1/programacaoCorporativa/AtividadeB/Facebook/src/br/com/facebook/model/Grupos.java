package br.com.facebook.model;

import java.util.List;

public class Grupos {
	private String nomeGrupo;
	private Perfil perfilAdministrador;
	private List<Perfil> listaParticipantes;
	
	public Grupos(String nomeGrupo, Perfil perfilAdministrador) {
		this.nomeGrupo = nomeGrupo;
		this.perfilAdministrador = perfilAdministrador;
	}
	
	public List<Perfil> getListaParticipantes() {
		return listaParticipantes;
	}
	
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	
	public Perfil getPerfilAdministrador() {
		return perfilAdministrador;
	}
	
	
}
