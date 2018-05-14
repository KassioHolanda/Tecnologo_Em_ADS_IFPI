package br.com.sisteamatransporteaereo.domain;

public class CompanhiaAerea {
	private Aviao aviao;
	private String nome;
	private Funcionarios funcionarios;
	
	public CompanhiaAerea(Aviao aviao, Funcionarios funcionarios) {
		this.aviao = aviao;
		this.nome = "JacaAviacoes";
		this.funcionarios = funcionarios;
	}
	
	public Aviao getAviao() {
		return aviao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Funcionarios getFuncionarios() {
		return funcionarios;
	}
	
}
