package Domain;

public class ContaPoupanca implements Conta{
	double saldo;
	
	public void atualiza(double taxa){
		this.saldo = saldo * taxa * 3;
	}

	@Override
	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public void deposita(double valor) {
		this.saldo += valor;
		
	}

	@Override
	public void saca(double valor) {
		this.saldo -= valor;
		
	}
}
