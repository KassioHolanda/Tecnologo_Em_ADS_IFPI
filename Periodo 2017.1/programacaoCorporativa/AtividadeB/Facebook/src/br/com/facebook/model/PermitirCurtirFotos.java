package br.com.facebook.model;

public class PermitirCurtirFotos {
	private boolean permitirCurtirFotos;
	
	public PermitirCurtirFotos(boolean permitirCurtirFotos) {
		this.permitirCurtirFotos = permitirCurtirFotos;
	}
	
	public void setPermitirCurtirFotos(boolean permitirCurtirFotos) {
		this.permitirCurtirFotos = true;
	}

	public boolean isPermitirCurtirFotos() {
		return permitirCurtirFotos;
	}
}
