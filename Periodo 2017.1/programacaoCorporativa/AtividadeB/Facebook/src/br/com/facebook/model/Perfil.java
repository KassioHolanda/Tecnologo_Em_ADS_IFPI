package br.com.facebook.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Perfil extends Pessoa {
	private Configuracoes Configuracoes;
	private List<Historia> listaHistoria;
	private Map<Perfil, Perfil> listaSolicitacoesAmizade;
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
	}

	public Perfil(String nome, String dataNascimento, Configuracoes configuracoes) {
		super(nome, dataNascimento);
		this.Configuracoes = configuracoes;
		listaAmigos = new HashMap<>();
		listaHistoria = new ArrayList<>();
	}

	@Override
	public String getDataNascimento() {
		// TODO Auto-generated method stub
		return super.getDataNascimento();
	}

	public void adicionarAmigoBD(TipoAmigo tipoAmigo, Perfil perfil) {
		listaAmigos.put(perfil, tipoAmigo);
	}

	public void removerAmigoBD(Perfil perfil) {
		listaAmigos.remove(perfil);
	}
	
	public void adicionarHistoriaBD(Historia historia){
		listaHistoria.add(historia);
	}
	
	public void solicitacaoAmizadeBD(Perfil perfilSolicitado, Perfil perfilSolicitante){
		listaSolicitacoesAmizade.put(perfilSolicitado, perfilSolicitante);
	}
	
	public void aceitarSolicitacao(Perfil perfilSolicitado, Perfil perfilSolicitante, boolean aceitar){
		if(aceitar){
			TipoAmigo tipo = new TipoAmigo();
			listaAmigos.put(perfilSolicitante, tipo);
			listaSolicitacoesAmizade.remove(perfilSolicitado);
		} else {
			listaSolicitacoesAmizade.remove(perfilSolicitado);
		}
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

	public Map<Perfil, TipoAmigo> getListaAmigos() {
		return listaAmigos;
	}

}
