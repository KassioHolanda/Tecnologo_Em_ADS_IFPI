package br.com.facebook.model.perfil;

import java.util.ArrayList;
import java.util.List;

public class Grupos {
	private String fotoGrupo;
	private String fotoCapaGrupo;
	private String nomeGrupo;
	private Perfil perfilAdministrador;
	private List<Perfil> listaParticipantes;
	private List<Perfil> solicitacoesGrupo;

	public Grupos(String nomeGrupo, Perfil perfilAdministrador, String fotoGrupo, String fotoCapaGrupo) {
		this.fotoCapaGrupo = fotoCapaGrupo;
		this.fotoGrupo = fotoGrupo;
		this.nomeGrupo = nomeGrupo;
		this.perfilAdministrador = perfilAdministrador;
		listaParticipantes = new ArrayList<>();
		solicitacoesGrupo = new ArrayList<>();
	}

	public Grupos(String nomeGrupo, Perfil perfilAdministrador) {
		this.nomeGrupo = nomeGrupo;
		this.perfilAdministrador = perfilAdministrador;
	}

	public void solicitacaoGrupoBD(Perfil perfilSolicitado) {
		this.solicitacoesGrupo.add(perfilSolicitado);
	}

	public void aceitarSolicitacao(Perfil perfilSolicitante, boolean aceitar) {
		if (aceitar) {
			listaParticipantes.add(perfilSolicitante);
			perfilSolicitante.adicionarGrupoBD(this);
			solicitacoesGrupo.remove(perfilSolicitante);
		} else {
			solicitacoesGrupo.remove(perfilSolicitante);
		}
	}

	public String listarSolicitacoesAmizade() {
		String listaSolic = "";

		for (Perfil listaSolicitacoes : this.solicitacoesGrupo) {
			listaSolic += "Perfil: " + listaSolicitacoes.getNome() + " quer ser seu amigo\n";
		}

		return listaSolic;
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

	public List<Perfil> getSolicitacoesGrupo() {
		return solicitacoesGrupo;
	}

	public void setFotoCapaGrupo(String fotoCapaGrupo) {
		this.fotoCapaGrupo = fotoCapaGrupo;
	}

	public void setFotoGrupo(String fotoGrupo) {
		this.fotoGrupo = fotoGrupo;
	}
}
