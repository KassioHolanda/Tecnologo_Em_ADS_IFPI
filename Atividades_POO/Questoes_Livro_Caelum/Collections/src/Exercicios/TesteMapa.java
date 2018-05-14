package Exercicios;

import java.util.HashMap;
import java.util.Map;

public class TesteMapa {
	public static void main(String[] args) {
		//usado conta poupaca ao inves de contacorrte como diz no capitulo
		Conta c1 = new ContaPoupanca();
		c1.getDeposita(10000);
		
		Conta c2 = new ContaPoupanca();
		c2.getDeposita(10000);
		
		Map<String, Conta> mapaDeContas = new HashMap<>();
		
		mapaDeContas.put("Diretor", c1);
		mapaDeContas.put("Gerente", c2);
		
		Conta contaDoDiretor = mapaDeContas.get("Diretor");
		System.out.println(contaDoDiretor.getSaldo());
	}
}
