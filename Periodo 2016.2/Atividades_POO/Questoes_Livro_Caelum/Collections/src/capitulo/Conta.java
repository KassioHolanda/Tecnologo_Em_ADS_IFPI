package capitulo;

public class Conta {
	private double saldo;
	
	public void getDeposita(double valor){
		this.saldo += valor;
	}
	
	public double getSaldo() {
		return saldo;
	}
}
