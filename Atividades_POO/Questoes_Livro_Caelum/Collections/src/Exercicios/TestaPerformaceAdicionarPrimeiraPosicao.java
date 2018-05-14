package Exercicios;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestaPerformaceAdicionarPrimeiraPosicao {
 public static void main(String[] args) {
	System.out.println("Iniciando 1...");
	long inicio = System.currentTimeMillis();
	
	List<Integer> teste = new LinkedList<>();
	
	for(int i =0; i < 30000; i++){
		teste.add(0, i);
	}
	
	for(int i = 0; i < 30000; i++){
		teste.get(i);
	}
	
	long fim = System.currentTimeMillis();
	double tempo = (fim - inicio)/1000.0;
	System.out.println("Tempo gasto: " + tempo);
	
	
	//teste dois
	System.out.println("Iniciando 2...");
	long inicio2 = System.currentTimeMillis();
	
	List<Integer> teste2 = new ArrayList<>();
	
	
	for(int i =0; i < 30000; i++){
		teste2.add(0, i);
	}
	
	
	for(int i = 0; i < 30000; i++){
		teste2.get(i);
	}
	
	long fim2 = System.currentTimeMillis();
	double tempo2 = (fim2 - inicio2)/1000.0;
	System.out.println("Tempo gasto: " + tempo2);
}
}
