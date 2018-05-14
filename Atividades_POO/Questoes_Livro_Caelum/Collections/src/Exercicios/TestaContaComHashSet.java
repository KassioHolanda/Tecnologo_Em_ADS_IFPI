package Exercicios;

import java.util.HashSet;
import java.util.Set;

public class TestaContaComHashSet {
	public static void main(String[] args) {
		
		Set<Conta> contaSet= new HashSet<>();
		Conta conta = new Conta();
		
		conta.nome = "kassio";
		conta.numero = 2;
		conta.getDeposita(100);
		
		contaSet.add(conta);
		
		Conta conta2 = new Conta();
		
		conta2.nome = "Lucas";
		conta2.numero = 2;
		conta2.getDeposita(1010);
		
		contaSet.add(conta2);
		
		
		
		
		System.out.println(contaSet);		
	}
}	
