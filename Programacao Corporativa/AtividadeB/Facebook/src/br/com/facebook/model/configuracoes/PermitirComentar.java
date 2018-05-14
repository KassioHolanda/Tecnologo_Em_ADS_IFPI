package br.com.facebook.model.configuracoes;

public class PermitirComentar {
	private boolean permitirComentar;
	
	PermitirComentar(boolean permitir){
		this.permitirComentar = permitir;
	}
	
	public PermitirComentar() {
		this.permitirComentar = true;
	}

	public boolean isPermitirComentar() {
		return permitirComentar;
	}
	
	public void setPermitirComentar(boolean permitir) {
		this.permitirComentar = permitir;
	}
}
