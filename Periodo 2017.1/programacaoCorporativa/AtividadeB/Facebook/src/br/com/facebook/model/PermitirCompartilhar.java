package br.com.facebook.model;

public class PermitirCompartilhar {
	private boolean permitirCompartilhar;

	public PermitirCompartilhar(boolean permitir) {
		this.permitirCompartilhar = permitir;
	}

	public PermitirCompartilhar() {
		this.permitirCompartilhar = true;
	}

	public boolean isPermitirCompartilhar() {
		return permitirCompartilhar;
	}

	public void setPermitirCompartilhar(boolean permitir) {
		this.permitirCompartilhar = permitir;
	}

}
