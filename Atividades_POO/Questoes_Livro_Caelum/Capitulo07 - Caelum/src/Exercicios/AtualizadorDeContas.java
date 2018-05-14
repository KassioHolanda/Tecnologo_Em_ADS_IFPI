package Exercicios;

public class AtualizadorDeContas {
	private double saldoTotal = 0;
	private double selic;
	
	public AtualizadorDeContas(double selic){
		this.selic = selic;
	}
	
	public void roda(Conta c){
		System.out.println("Saldo anterior: " + c.getSaldo());
		saldoTotal = c.getSaldo() + selic;
		System.out.println("Saldo final: " + saldoTotal);
	}
	
	public double getSaldoTotal() {
		return saldoTotal;
	}
}
