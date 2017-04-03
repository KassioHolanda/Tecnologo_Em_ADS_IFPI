package capitulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TesteOrdenação {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Sergio");
		lista.add("Paulo");
		lista.add("Guilherme");
		
		System.out.println(lista);
		
		Collections.sort(lista);
		
		System.out.println(lista);
		
		ContaCorrente c1 = new ContaCorrente(100);
		c1.getDeposita(500);
		ContaCorrente c2 = new ContaCorrente(100);
		c2.getDeposita(500);
		ContaCorrente c3 = new ContaCorrente(100);
		c3.getDeposita(500);
		
		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		
	}
}
