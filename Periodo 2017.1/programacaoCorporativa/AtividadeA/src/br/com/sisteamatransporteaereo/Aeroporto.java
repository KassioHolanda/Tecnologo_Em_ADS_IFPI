package br.com.sisteamatransporteaereo;

public class Aeroporto {
	private Funcionarios funcionarios;
	private CompanhiaAerea companhiaAerea;

	public Aeroporto(Funcionarios funcionarios, CompanhiaAerea companhiaAerea) {
		this.funcionarios = funcionarios;
		this.companhiaAerea = companhiaAerea;
	}

	public CompanhiaAerea getCompanhiaAerea() {
		return companhiaAerea;
	}

	public Funcionarios getFuncionarios() {
		return funcionarios;
	}
}
