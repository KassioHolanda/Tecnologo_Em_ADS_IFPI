package br.com.facebook.model;

public class PermitirVisualizarFotos {
	private boolean permitirCurtirFotos;
	
	PermitirVisualizarFotos(boolean permitir){
		this.permitirCurtirFotos = true;
	}

	public boolean isPermitir() {
		return permitirCurtirFotos;
	}
	
	public void setPermitir(boolean permitir) {
		this.permitirCurtirFotos = permitir;
	}
}
