package br.com.facebook.model.perfil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.facebook.model.configuracoes.Configuracoes;
import br.com.facebook.model.post.Post;

public class Perfil extends Pessoa {
	private Configuracoes configuracoes;
	private List<Post> listaPost;
	private List<Perfil> listaSolicitacoesAmizade;
	private List<Amigos> listaAmigos;
	private List<Grupos> listaGrupos;
	private String fotoPerfil;
	private String fotoCapa;
	private Calendar data;

	public Perfil(String nome, String dataNascimento, Configuracoes configuracoes, String fotoPerfil, String fotoCapa) {
		super(nome, dataNascimento);
		this.configuracoes = configuracoes;
		this.fotoCapa = fotoCapa;
		this.fotoPerfil = fotoPerfil;

		data = Calendar.getInstance();
		listaAmigos = new ArrayList<>();
		listaPost = new ArrayList<>();
		listaGrupos = new ArrayList<>();
	}

	public Perfil(String nome, String dataNascimento, Configuracoes configuracoes) {
		super(nome, dataNascimento);
		this.configuracoes = configuracoes;

		data = Calendar.getInstance();
		listaAmigos = new ArrayList<>();
		listaSolicitacoesAmizade = new ArrayList<>();
		listaPost = new ArrayList<>();
	}

	public String alterarTipoAmizade(Perfil perfil, String tipoAmigo) {
		for (Amigos amigos : listaAmigos) {
			if (amigos.getPerfil().equals(perfil)) {
				amigos.getTipoAmigo().setTipoAmigo(tipoAmigo);
				return "ALteracao Concluida";
			} else {
				return "Perfil nao encontrado";
			}
		}
		return "Erro";
	}

	public String mostrarTodosAmigos() {
		String listaAmigos = "";
		for (Amigos amigos : this.listaAmigos) {
			listaAmigos += "Nome: " + amigos.getPerfil().getNome() + "\n";
		}
		return listaAmigos;
	}

	public void removerAmigoBD(Amigos amigos) {
		listaAmigos.remove(amigos);
	}

	public void limparListaSolicitacoes() {
		this.listaSolicitacoesAmizade.clear();
	}

	public void excluirTodosAmigos(Perfil perfil) {
		perfil.getListaAmigos().clear();
	}
	
	public void adicionarPostBD(Post post) {
		listaPost.add(post);
	}

	public void solicitacaoAmizadeBD(Perfil perfilSolicitado) {
		perfilSolicitado.getListaSolicitacoesAmizade().add(this);

		this.getListaSolicitacoesAmizade().add(perfilSolicitado);
	}
	

	public String listarSolicitacoesAmizade() {
		String listaSolic = "";

		for (Perfil listaSolicitacoes : this.listaSolicitacoesAmizade) {
			listaSolic += "Perfil: " + listaSolicitacoes.getNome() + " quer ser seu amigo\n";
		}

		return listaSolic;
	}
	
	public String aceitarSolicitacao(Perfil perfilSolicitante, boolean aceitar) {
		if (aceitar) {
			TipoAmigo tipo = new TipoAmigo();
			Amigos amigo = new Amigos(perfilSolicitante, tipo);
			listaAmigos.add(amigo);
			listaSolicitacoesAmizade.remove(this);
			return "Voce e " + perfilSolicitante.getNome() + " agora são amigos";
		} else {
			listaSolicitacoesAmizade.remove(this);
			return perfilSolicitante.getNome() + " foi apagado de sua lista de solicitações\n";
		}
	}

	public String consultarTipoAmigo(Perfil perfil) {
		for (Amigos amigos : listaAmigos) {
			if (amigos.getPerfil().equals(perfil)) {
				return amigos.getTipoAmigo().getTipoAmigo();
			}
		}
		return "Nao encontrado";
	}
	
	public Amigos consultarDadosAmigo(Perfil perfil){
		for (Amigos amigos : listaAmigos) {
			if(amigos.getPerfil().equals(perfil)){
				return amigos;
			}
		}
		return null;
	}
	
	public void adicionarGrupoBD(Grupos grupo){
		this.listaGrupos.add(grupo);
	}

	public String getFotoCapa() {
		return fotoCapa;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public Configuracoes getConfiguracoes() {
		return configuracoes;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

	public List<Post> getListaPost() {
		return listaPost;
	}

	public List<Amigos> getListaAmigos() {
		return listaAmigos;
	}

	public List<Perfil> getListaSolicitacoesAmizade() {
		return listaSolicitacoesAmizade;
	}
	
	public List<Grupos> getListaGrupos() {
		return listaGrupos;
	}

	@Override
	public String getDataNascimento() {
		// TODO Auto-generated method stub
		return super.getDataNascimento();
	}

	public Calendar getData() {
		return data;
	}

	public void setFotoCapa(String fotoCapa) {
		this.fotoCapa = fotoCapa;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

}
