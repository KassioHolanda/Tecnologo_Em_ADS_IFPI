package Exercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Desafios {
	public static void main(String[] args) {
		Set<DesafiosComparable> numeros = new TreeSet<>();
		for (int i = 0; i < 1000; i++) {
			DesafiosComparable numerosOrdenados = new DesafiosComparable(i);
			numeros.add(numerosOrdenados);
		}
		//System.out.println(numeros);
		
		
		//usando array list
		
		List numerosList = new ArrayList<>();
		for(int i = 0; i < 1000; i++){
			numerosList.add(i);
		}
		
		Collections.reverse(numerosList);
		System.out.println(numerosList);
	}

}


