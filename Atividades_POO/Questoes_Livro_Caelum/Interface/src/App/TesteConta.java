package App;

import Domain.Conta;
import Domain.ContaCorrente;
import Interfaces.Tributavel;

public class TesteConta {
	public static void main(String[] args) {
		Conta c  = new ContaCorrente();
		Tributavel t = new ContaCorrente();
	}
}
