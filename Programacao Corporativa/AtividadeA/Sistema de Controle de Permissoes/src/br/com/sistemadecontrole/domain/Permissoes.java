package br.com.sistemadecontrole.domain;

public class Permissoes {
	private PermitirCadastroNovoUsuario permitirCadastroNovoUsuario;
	private PermitirExclusaoUsuario permitirExclusaoUsuario;
	private PermitirEdicaoUsuario permitirEdicaoUsuario;
	private String perfil;
	// Exemplo de permissoes

	public Permissoes() {
		this.permitirCadastroNovoUsuario = new PermitirCadastroNovoUsuario();
		this.permitirEdicaoUsuario = new PermitirEdicaoUsuario();
		this.permitirExclusaoUsuario = new PermitirExclusaoUsuario();
		mudarPerfilPadrao();
		perfil = "Padrao";
	}

	public void mudarPerfilAdministrador() {
		permitirCadastroNovoUsuario.setPermitirCadastroNovoUsuario(true);
		permitirEdicaoUsuario.setPermitirEdicaoUsuario(true);
		permitirExclusaoUsuario.setPermitirExclusaoUsuario(true);
		perfil = "Administrador";
	}

	public void mudarPerfilPadrao() {
		permitirCadastroNovoUsuario.setPermitirCadastroNovoUsuario(true);
		permitirEdicaoUsuario.setPermitirEdicaoUsuario(false);
		permitirExclusaoUsuario.setPermitirExclusaoUsuario(false);
		perfil = "Padrao";
	}
	
	public String getPerfil() {
		return perfil;
	}
}
