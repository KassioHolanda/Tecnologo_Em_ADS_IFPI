package QuestoesCapitulo11;

public class Conta {
	double saldo = 10000;

	public double getSaldo() {
		return saldo;
	}

	void deposita(double valor) {
		if (valor < 0) {
			throw new ValorInvalidoException("VOce tentou depositar um numero negativo");
		} else {
			this.saldo += valor;
		}
	}
	
}