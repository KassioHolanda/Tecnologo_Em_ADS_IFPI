package br.com.facebook.model;

public class Pessoa {
	private String nome;
	private String dataNascimento;
	
	public Pessoa(String nome, String dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getNome() {
		return nome;
	}
}
