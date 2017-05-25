package br.com.sistemadecontrole;

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

	protected void mudarPerfilAdministrador() {
		permitirCadastroNovoUsuario.setPermitirCadastroNovoUsuario(true);
		permitirEdicaoUsuario.setPermitirEdicaoUsuario(true);
		permitirExclusaoUsuario.setPermitirExclusaoUsuario(true);
		perfil = "Administrador";
	}

	protected void mudarPerfilPadrao() {
		permitirCadastroNovoUsuario.setPermitirCadastroNovoUsuario(true);
		permitirEdicaoUsuario.setPermitirEdicaoUsuario(false);
		permitirExclusaoUsuario.setPermitirExclusaoUsuario(false);
		perfil = "Padrao";
	}
	
	public String getPerfil() {
		return perfil;
	}
}
