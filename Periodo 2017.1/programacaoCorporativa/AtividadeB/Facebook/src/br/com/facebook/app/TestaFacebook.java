package br.com.facebook.app;

import br.com.facebook.model.Configuracoes;
import br.com.facebook.model.Facebook;
import br.com.facebook.model.Historia;
import br.com.facebook.model.Perfil;

public class TestaFacebook {
	public static void main(String[] args) {
		Facebook facebook = new Facebook();

		Configuracoes configuracoes = new Configuracoes("123");

		Perfil primeiroPerfil = new Perfil("Kássio Holanda", "05/04/1997", configuracoes);

		Historia historia = new Historia("Pensamento do Dia", "Todo Animal Morto é um animal sem vida");
		primeiroPerfil.adicionarHistoriaBD(historia);

		Perfil segundoPerfil = new Perfil("Karlos Jordano", "01/06/1999", configuracoes);
		Historia historiaDois = new Historia("Sentimento", "Sentindo-se Triste");
		segundoPerfil.adicionarHistoriaBD(historiaDois);

		primeiroPerfil.solicitacaoAmizadeBD(segundoPerfil);
		System.out.println(segundoPerfil.aceitarSolicitacao(primeiroPerfil, true));

		segundoPerfil.solicitacaoAmizadeBD(primeiroPerfil);
		System.out.println(primeiroPerfil.aceitarSolicitacao(segundoPerfil, false));

		facebook.adicionarPerfilBD(primeiroPerfil);
		facebook.adicionarPerfilBD(segundoPerfil);

		System.out.println(facebook.mostrarFeed());

	}

}
