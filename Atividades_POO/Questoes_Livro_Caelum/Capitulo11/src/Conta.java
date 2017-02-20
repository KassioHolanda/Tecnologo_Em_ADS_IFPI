
public class Conta {
	double saldo;
	
	public void deposita(double valor) {// throws ValorInvalidoException{
		if(valor < 0){
			throw new ValorInvalidoException(valor);
		} else {
			this.saldo = valor;
		}
	}
	
	
}
