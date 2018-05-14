package Domain;

import Interfaces.Tributavel;

public class ContaCorrente implements Conta, Tributavel{
	double saldo;
	
	public void atualiza(double taxa){
		this.saldo = saldo * taxa * 2;
	}
	
	public void deposita(double valor){
		this.saldo += valor - 0.10;
	}

	@Override
	public double calculaTributos() {
		return this.getSaldo() * 0.01;
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public void saca(double valor) {
		this.saldo -= valor;
		
	}
}
