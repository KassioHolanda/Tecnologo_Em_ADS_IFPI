package br.com.facebook.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Perfil extends Pessoa {
	private Configuracoes Configuracoes;
	private List<Historia> listaHistoria;
	private List<Grupos> listaGrupos;
	private Map<Perfil, TipoAmigo> listaAmigos;
	private String fotoPerfil;
	private String fotoCapa;

	public Perfil(String nome, String dataNascimento, Configuracoes configuracoes, String fotoPerfil, String fotoCapa) {
		super(nome, dataNascimento);
		this.Configuracoes = configuracoes;
		this.fotoCapa = fotoCapa;
		this.fotoPerfil = fotoPerfil;
		listaAmigos = new HashMap<>();
		listaHistoria = new ArrayList<>();
		listaGrupos = new ArrayList<>();
	}
	
	public Perfil(String nome, String dataNascimento, Configuracoes configuracoes) {
		super(nome, dataNascimento);
		this.Configuracoes = configuracoes;
		listaAmigos = new HashMap<>();
		listaHistoria = new ArrayList<>();
		listaGrupos = new ArrayList<>();
	}

	@Override
	public String getDataNascimento() {
		// TODO Auto-generated method stub
		return super.getDataNascimento();
	}
	
	public void adicionarAmigo(TipoAmigo tipoAmigo, Perfil perfil){
		listaAmigos.put(perfil, tipoAmigo);
	}
	
	public void removerAmigo(Perfil perfil){
		listaAmigos.remove(perfil);
	}

	public String getFotoCapa() {
		return fotoCapa;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public Configuracoes getConfiguracoes() {
		return Configuracoes;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	public List<Historia> getListaHistoria() {
		return listaHistoria;
	}

	public List<Grupos> getListaGrupos() {
		return listaGrupos;
	}
	
	public Map<Perfil, TipoAmigo> getListaAmigos() {
		return listaAmigos;
	}

}
