package br.com.facebook.app;

import br.com.facebook.model.Configuracoes;
import br.com.facebook.model.Facebook;
import br.com.facebook.model.Post;
import br.com.facebook.model.Perfil;

public class TestaFacebook {
	public static void main(String[] args) {
		Facebook facebook = new Facebook();

		Configuracoes configuracoes = new Configuracoes("123");

		Perfil primeiroPerfil = new Perfil("Kássio Holanda", "05/04/1997", configuracoes);

		Post historia = new Post("Pensamento do Dia", "Todo Animal Morto é um animal sem vida");
		primeiroPerfil.adicionarHistoriaBD(historia);

		Perfil segundoPerfil = new Perfil("Karlos Jordano", "01/06/1999", configuracoes);
		Post historiaDois = new Post("Sentimento", "Sentindo-se Triste");
		segundoPerfil.adicionarHistoriaBD(historiaDois);

		//Aceitando Solicitacao
		primeiroPerfil.solicitacaoAmizadeBD(segundoPerfil);
		//Listando Solicitacoes
		System.out.println(primeiroPerfil.listarSolicitacoesAmizade());
		System.out.println(segundoPerfil.aceitarSolicitacao(primeiroPerfil, true));
		
		//Negando Solicitacoes
		segundoPerfil.solicitacaoAmizadeBD(primeiroPerfil);
		System.out.println(primeiroPerfil.aceitarSolicitacao(segundoPerfil, false));
	
		facebook.adicionarPerfilBD(primeiroPerfil);
		facebook.adicionarPerfilBD(segundoPerfil);

		primeiroPerfil.alterarTipoAmizade(segundoPerfil, "Desconhecido");
		System.out.println(primeiroPerfil.mostrarTodosAmigos());

		System.out.println(facebook.mostrarFeed());

	}

}
