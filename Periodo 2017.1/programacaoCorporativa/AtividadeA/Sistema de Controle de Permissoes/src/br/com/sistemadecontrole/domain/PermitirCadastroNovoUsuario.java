package br.com.sistemadecontrole.domain;

public class PermitirCadastroNovoUsuario {
	private boolean permitir;

	public PermitirCadastroNovoUsuario() {
		this.permitir = false;
	}

	public boolean getPermitirCadastroNovoUsuario() {
		return permitir;
	}
	
	public boolean setPermitirCadastroNovoUsuario(boolean permitir){
		return this.permitir = permitir;
	}

}
