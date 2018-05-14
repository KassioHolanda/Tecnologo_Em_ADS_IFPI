package Exercicios;

public class ContaCorrente extends Conta{
	public void atualiza(double taxa){
		this.saldo = saldo * taxa * 2;
	}
	
	public void deposita(double valor){
		this.saldo += valor - 0.10;
	}
}
