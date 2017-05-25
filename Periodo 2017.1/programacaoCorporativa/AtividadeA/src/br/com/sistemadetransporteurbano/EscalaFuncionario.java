package br.com.sistemadetransporteurbano;

public class EscalaFuncionario {
	private String horario;
	private Onibus onibus;
	
	public EscalaFuncionario(String horario, Onibus onibus) {
		this.horario = horario;
		this.onibus = onibus;
	}
	
	public Onibus getOnibus() {
		return onibus;
	}
	
	public String getHorario() {
		return horario;
	}
}
