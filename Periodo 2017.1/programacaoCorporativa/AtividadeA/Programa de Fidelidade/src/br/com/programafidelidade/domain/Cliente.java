package br.com.programafidelidade.domain;

public class Cliente extends Pessoa{
	private int numeroDeCompras;
	private double descontos;

	public Cliente(String nome, String cpf) {
		super(nome, cpf);
		this.descontos = 0;
		this.numeroDeCompras = 0;
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}
	
	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}

	public int getNumeroDeCompras() {
		return numeroDeCompras;
	}

	public void setNumeroDeCompras(int numeroDeCompras) {
		this.numeroDeCompras += numeroDeCompras;
	}

	public double getDescontos() {
		return descontos;
	}

	public void setDescontos(double desconto) {
		this.descontos -= desconto;
	}
	
	
}
