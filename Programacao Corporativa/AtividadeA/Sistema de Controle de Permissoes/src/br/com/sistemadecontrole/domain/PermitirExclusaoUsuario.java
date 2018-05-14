package br.com.sistemadecontrole.domain;

public class PermitirExclusaoUsuario {
	private boolean permitir;

	public PermitirExclusaoUsuario() {
		this.permitir = false;
	}

	public boolean getPermitirExclusaoUsuario() {
		return permitir;
	}
	
	public boolean setPermitirExclusaoUsuario(boolean permitir){
		return this.permitir = permitir;
	}
}
