package br.com.programafidelidade.domain;

public class Produto {
	private Cliente cliente;
	private String nome;
	private double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setPreco(double preco) {
		this.preco += preco;
	}
}
