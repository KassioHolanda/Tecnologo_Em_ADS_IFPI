package br.com.facebook.app;

import br.com.facebook.model.Facebook;
import br.com.facebook.model.configuracoes.Configuracoes;
import br.com.facebook.model.perfil.Perfil;
import br.com.facebook.model.post.Post;

public class TestaFacebook {
	public static void main(String[] args) {
		Facebook facebook = new Facebook();

		Configuracoes configuracoes = new Configuracoes("123");

		Perfil primeiroPerfil = new Perfil("Kássio Holanda", "05/04/1997", configuracoes);
		facebook.adicionarPerfilBD(primeiroPerfil);

		Post post = new Post("Pensamento do Dia", "Todo Animal Morto é um animal sem vida");
		primeiroPerfil.adicionarPostBD(post);

		Perfil segundoPerfil = new Perfil("Karlos Jordano", "01/06/1999", configuracoes);
		facebook.adicionarPerfilBD(segundoPerfil);

		Post postDois = new Post("Sentimento", "Sentindo-se Triste");
		segundoPerfil.adicionarPostBD(postDois);

		// Aceitando Solicitacao
		primeiroPerfil.solicitacaoAmizadeBD(segundoPerfil);
		// Listando Solicitacoes
		System.out.println(primeiroPerfil.listarSolicitacoesAmizade());
		System.out.println(segundoPerfil.aceitarSolicitacao(primeiroPerfil, true));

		// Negando Solicitacoes
		segundoPerfil.solicitacaoAmizadeBD(primeiroPerfil);
		System.out.println(primeiroPerfil.aceitarSolicitacao(segundoPerfil, false));

		// primeiroPerfil.getConfiguracoes().getListaPerfisBloqueados().add(segundoPerfil);
		System.out.println(primeiroPerfil.getConfiguracoes().getPermitirComentar().isPermitirComentar());

		primeiroPerfil.alterarTipoAmizade(segundoPerfil, "Desconhecido");
		System.out.println(primeiroPerfil.mostrarTodosAmigos());

		// Consutando tipo Amigo
		System.out.println(segundoPerfil.consultarTipoAmigo(primeiroPerfil));
		System.out.println(primeiroPerfil.consultarTipoAmigo(segundoPerfil));

		System.out.println(facebook.mostrarFeed());

	}

}
