package br.com.sistemadecontrole.domain;

public class Empresa {
	private Funcionario funcionario;
	private String nome;
	
	public Empresa(Funcionario funcionario) {
		this.nome = "JacaSoftware";
		this.funcionario = funcionario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
}
