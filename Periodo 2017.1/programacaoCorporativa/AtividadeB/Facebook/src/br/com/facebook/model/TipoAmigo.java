package br.com.facebook.model;

public class TipoAmigo {
	private String tipoAmigo;

	private final static String USUARIO_PADRAO = "Padrao";
	private final static String FAMILIA_PRIMO = "Primo";
	private final static String FAMILIA_IRMAO = "Irmao";
	private final static String FAMILIA_PAI = "Pai";
	private final static String FAMILIA_MAE = "Mae";

	public TipoAmigo(String tipoAmigo) {
		this.tipoAmigo = tipoAmigo;
	}

	public TipoAmigo() {
		this.tipoAmigo = TipoAmigo.USUARIO_PADRAO;
	}

	public void alterarParaPrimo() {
		this.tipoAmigo = TipoAmigo.FAMILIA_PRIMO;
	}

	public String getTipoAmigo() {
		return tipoAmigo;
	}

	public void setTipoAmigo(String tipoAmigo) {
		this.tipoAmigo = tipoAmigo;
	}
}
