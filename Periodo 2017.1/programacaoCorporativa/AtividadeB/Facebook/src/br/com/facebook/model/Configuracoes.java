package br.com.facebook.model;

import java.util.ArrayList;
import java.util.List;

public class Configuracoes {
	private PermitirVisualizarFotos permitirVisualizarFotos;
	private PermitirCurtirFotos permitirCurtirFotos;
	private List<Perfil> listaPerfisBloqueados;
	private String senha;
	
	public Configuracoes(String senha) {
		listaPerfisBloqueados = new ArrayList<>();
		this.senha = senha;
	}
	
	public List<Perfil> getListaPerfisBloqueados() {
		return listaPerfisBloqueados;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void bloquearPerfil(Perfil perfil){
		listaPerfisBloqueados.add(perfil);
	}
	
	public void removerPerfilBloqueado(Perfil perfil){
		listaPerfisBloqueados.remove(perfil);
	}
	
	public PermitirCurtirFotos getPermitirCurtirFotos() {
		return permitirCurtirFotos;
	}
	
	public PermitirVisualizarFotos getPermitirVisualizarFotos() {
		return permitirVisualizarFotos;
	}
}
