package br.com.sistemadecontrole;

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
