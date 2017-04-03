package Exercicios;

public class Conta {
	private double saldo;
	protected int numero;
	protected String nome;
	
	public void getDeposita(double valor){
		this.saldo += valor;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		return result;
	}
	//sem o hashcode o hashset guardara contas de numero repetido
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (numero != other.numero)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", numero=" + numero + ", nome=" + nome + "]";
	}

	

	
}
