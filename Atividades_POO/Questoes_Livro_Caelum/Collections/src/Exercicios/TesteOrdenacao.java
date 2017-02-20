package Exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TesteOrdenacao {
	public static void main(String[] args) {
		List<ContaPoupanca> contas = new LinkedList();

		ContaPoupanca c1 = new ContaPoupanca();
		c1.setNumero(1973);
		c1.setNome("Kasiso");
		contas.add(c1);
		
		ContaPoupanca c2 = new ContaPoupanca();
		c2.setNumero(1462);
		c2.setNome("aLison");
		contas.add(c2);
		
		ContaPoupanca c3 = new ContaPoupanca();
		c3.setNumero(1462);
		c3.setNome("Carlos");
		contas.add(c3);
		
		
		/*
		for(int i = 0; i < 10; i++){
			ContaPoupanca i = new ContaPoupanca();
			Random random = new Random();
			int numero = random.nextInt(1000);
			i.setNumero(numero);
		}
		*///QUESTAO 07 TERMINAR...
		
		Collections.sort(contas);
			
		System.out.println("\n");
		for(int i = 0; i < contas.size(); i++){
			System.out.println("Numero: " + contas.get(i).getNumero() + " Nome: " + contas.get(i).getNome());
		}
		
		System.out.println(contas);
		
		/*
		
		imprimindo sort inverso, pode impirmir inverso atraves do Collection.reverse
		
		Collections.reverse(contas);
		System.out.println("\n");
		
		for(int i = 0; i < contas.size(); i++){
			System.out.println("Numero: " + contas.get(i).getNumero());
		}
		
		System.out.println("\n");
		
		EMABARALHANDO ARRAYS
		Collections.shuffle(contas);
		
		for(int i = 0; i < contas.size(); i++){
			System.out.println("Numero: " + contas.get(i).getNumero());
		}
		
		*/
	}
}
