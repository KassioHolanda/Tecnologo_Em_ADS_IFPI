package capitulo;

public class ContaCorrente implements Comparable<ContaCorrente>{
	private double saldo;
	
	
	public void getDeposita(double valor) {
		this.saldo += valor;
	}
	
	public ContaCorrente(){
		
	}
	
	public ContaCorrente(double saldo) {
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return saldo;
	}

	@Override
	public int compareTo(ContaCorrente o) {
		if (this.saldo < o.saldo){
			return -1;
		}
		if (this.saldo > o.saldo){
			return 1;
		}
		return 0;
	}
}
