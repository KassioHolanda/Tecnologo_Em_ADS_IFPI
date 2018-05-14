package Exercicios;

public abstract class Conta {
	protected double saldo;
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void deposita(double valor){
		this.saldo += valor;
	}
	
	public void saca(double valor){
		this.saldo -= valor;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	abstract void atualiza(double taxa);
}




