package br.com.sistemadecontrole.domain;

public class PermitirEdicaoUsuario {
	private boolean permitir;

	public PermitirEdicaoUsuario() {
		this.permitir = false;
	}

	public boolean getPermitirEdicaoUsuario() {
		return permitir;
	}
	
	public boolean setPermitirEdicaoUsuario(boolean permitir){
		return this.permitir = permitir;
	}
}
