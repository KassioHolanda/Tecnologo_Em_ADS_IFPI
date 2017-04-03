package Exercicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestePerformace {
	public static void main(String[] args) {
		System.out.println("Iniciando 1...");
		Collection<Integer> teste = new ArrayList<>();
		long inicio = System.currentTimeMillis();
		
		int total = 50000;
		
		for(int i = 0; i < total; i++){
			teste.add(i);
		}
		
		for(int i = 0; i < total; i++) {
			teste.contains(i);
		}
		
		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto: " + tempo);
		
		
		
		System.out.println("Iniciando2...");
		Collection<Integer> teste2 = new HashSet<>();
		long inicio2 = System.currentTimeMillis();
		
		int total2 = 50000;
		
		for(int i = 0; i < total2; i++){
			teste2.add(i);
		}
		
		for(int i = 0; i < total2; i++) {
			teste2.contains(i);
		}
		
		long fim2 = System.currentTimeMillis();
		long tempo2 = fim2 - inicio2;
		System.out.println("Tempo gasto: " + tempo2);
	}
}
