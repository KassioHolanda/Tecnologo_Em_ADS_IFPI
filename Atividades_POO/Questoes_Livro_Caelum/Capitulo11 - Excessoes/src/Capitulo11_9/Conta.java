package Capitulo11_9;

public class Conta {
	int saldo = 10000;
	
	
	
	public class SaldoInsuficienteException extends RuntimeException{
		private double saldo;

		public SaldoInsuficienteException(String message) {
			super(message);
		}
		
		void sacar(double valor){
			if (this.saldo < valor){
				throw new SaldoInsuficienteException("Saldo insuficiente, " + "Teste um valor menor");
			} else {
				this.saldo -= valor;
			}
		}
	}

}
