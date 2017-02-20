package capitulo;

import java.util.*;

public class TestandoList {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(1000);
		List lista = new ArrayList();
		lista.add("Uma string");
		lista.add(cc);

		List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
		//ou List<ContaCorrente> contas = new ArrayList<>();
		contas.add(cc);

		for (int i = 0; i < contas.size(); i++) {
			ContaCorrente conta = contas.get(i);
			System.out.println(conta.getSaldo());
		}
	}
}
