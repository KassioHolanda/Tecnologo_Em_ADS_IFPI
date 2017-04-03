package Domain;

public interface Conta {

	public double getSaldo();

	public void deposita(double valor);
	
	public void saca(double valor);
	
	abstract void atualiza(double taxa);
}




