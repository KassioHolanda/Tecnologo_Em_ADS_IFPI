package capitulo;

import java.util.ArrayList;
import java.util.List;
          

public class TestandoArraysList {
	public static void main(String[] args) {
		ArrayList lista = new ArrayList<String>();
		
		lista.add("kassio");
		lista.add("Lucas");
		lista.add("holanda");
		
		ContaCorrente conta1 = new ContaCorrente(1000);
		conta1.getDeposita(100);
		
		ContaCorrente conta2 = new ContaCorrente(1000);
		conta2.getDeposita(140);
		
		ContaCorrente conta3 = new ContaCorrente(1000);
		conta3.getDeposita(230);
		
		List contas = new ArrayList();
		contas.add(conta1);
		contas.add(conta2);
		contas.add(conta3);
		
		System.out.println(contas.size());
		
		for (int i = 0; i < contas.size(); i++){
			System.out.println(contas.get(i));
		}
		
		for (int i = 0; i < contas.size(); i++){
			ContaCorrente cc = (ContaCorrente) contas.get(i);
			System.out.println(cc.getSaldo());
		}
	
	}
}
