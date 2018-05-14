package Exercicios;

public class ContaPoupanca extends Conta{
	public void atualiza(double taxa){
		this.saldo = saldo * taxa * 3;
	}
}
