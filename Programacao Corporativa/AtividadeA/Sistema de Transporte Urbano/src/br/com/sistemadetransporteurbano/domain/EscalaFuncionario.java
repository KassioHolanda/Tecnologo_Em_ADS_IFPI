package br.com.sistemadetransporteurbano.domain;

public class EscalaFuncionario {
	private String horario;
	private Linha linha;
	
	public EscalaFuncionario(String horario, Linha linha) {
		this.horario = horario;
		this.linha = linha;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public Linha getLinha() {
		return linha;
	}
}
