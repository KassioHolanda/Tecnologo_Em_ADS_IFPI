package br.com.facebook.model.perfil;

import java.util.Calendar;

public class Amigos {
	private Perfil perfil;
	private Calendar data;
	private TipoAmigo tipoAmigo;
	
	public Amigos(Perfil perfil, TipoAmigo tipoAmigo){
		this.perfil = perfil;
		this.data = Calendar.getInstance();
		this.tipoAmigo = tipoAmigo;		
	}
	
	public Amigos(Perfil perfil){
		this.perfil = perfil;
		this.tipoAmigo = new TipoAmigo();
		this.data = Calendar.getInstance();
	}
	
	public Calendar getData() {
		return data;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}
	
	public TipoAmigo getTipoAmigo() {
		return tipoAmigo;
	}
}
