package Capitulo11_9;

public class SaldoInsuficienteException extends RuntimeException {
	private double saldo = 1000;

	public SaldoInsuficienteException(String message) {
		super(message);
	}

	void sacar(double valor) {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente, " + "Teste um valor menor");
		} else {
			this.saldo -= valor;
		}
	}
	
	void depositar(double valor){
		this.saldo += valor;
	}
	
	
}
