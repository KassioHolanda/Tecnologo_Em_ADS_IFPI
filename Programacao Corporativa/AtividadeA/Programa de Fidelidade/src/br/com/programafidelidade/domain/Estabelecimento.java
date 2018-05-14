package br.com.programafidelidade.domain;

public class Estabelecimento {
	private Funcionario funcionarios;
	private String nome;
	private String endereco;
	private Produto produto;
	
	public Estabelecimento(Funcionario funcionarios, String nome, String endereco, Produto produto) {
		this.funcionarios = funcionarios;
		this.nome = nome;
		this.endereco = endereco;
		this.produto = produto;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Funcionario getFuncionarios() {
		return funcionarios;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Produto getProduto() {
		return produto;
	}
}
