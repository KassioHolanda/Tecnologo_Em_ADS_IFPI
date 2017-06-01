package br.com.facebook.model;

import java.util.List;

public class Grupos {
	private String fotoGrupo;
	private String fotoCapaGrupo;
	private String nomeGrupo;
	private Perfil perfilAdministrador;
	private List<Perfil> listaParticipantes;

	public Grupos(String nomeGrupo, Perfil perfilAdministrador, String fotoGrupo, String fotoCapaGrupo){
		this.fotoCapaGrupo = fotoCapaGrupo;
		this.fotoGrupo = fotoGrupo;
		this.nomeGrupo = nomeGrupo;
		this.perfilAdministrador = perfilAdministrador;
	}
	
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
	
	public String getFotoCapaGrupo() {
		return fotoCapaGrupo;
	}
	
	public String getFotoGrupo() {
		return fotoGrupo;
	}
	
	public void setFotoCapaGrupo(String fotoCapaGrupo) {
		this.fotoCapaGrupo = fotoCapaGrupo;
	}
	
	public void setFotoGrupo(String fotoGrupo) {
		this.fotoGrupo = fotoGrupo;
	}
}
