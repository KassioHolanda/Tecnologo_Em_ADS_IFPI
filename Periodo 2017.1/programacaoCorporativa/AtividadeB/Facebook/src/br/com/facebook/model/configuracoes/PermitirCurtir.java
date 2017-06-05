package br.com.facebook.model.configuracoes;

public class PermitirCurtir {
	private boolean permitirCurtir;
	
	public PermitirCurtir(boolean permitir) {
		this.permitirCurtir = permitir;
	}
	
	public PermitirCurtir() {
		this.permitirCurtir = true;
	}
	
	public void setPermitirCurtir(boolean permitirCurtirFotos) {
		this.permitirCurtir = true;
	}

	public boolean isPermitirCurtir() {
		return permitirCurtir;
	}
}
