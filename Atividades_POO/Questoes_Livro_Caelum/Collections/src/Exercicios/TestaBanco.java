package Exercicios;

import java.util.HashMap;
import java.util.Map;

public class TestaBanco {
	public static void main(String[] args) {
		Banco c1 = new Banco("kassio");

		c1.adicionar(c1);
		System.out.println(c1.buscaPorNome("kassio"));
		System.out.println(c1.pegaQuantidadeDeContas());
		System.out.println(c1);
		
		//testando com HashMap
		Banco.adicionar(c1.getNome(), c1);
		System.out.println(Banco.buscaPorNome2(c1.getNome()));
	
	}
}
