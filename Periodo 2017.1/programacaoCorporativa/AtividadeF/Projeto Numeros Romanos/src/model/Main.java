package model;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		NumerosRomanos numeros = new NumerosRomanos();
		Map quantidadeLetras = new HashMap();
		
		
		String numero = "XVV";
		System.out.println(numero.split("")[1]);
		for(int i = 0; i < numero.length(); i++){
			///System.out.println(numero.substring(i));
			if(quantidadeLetras.containsKey(numero.split("")[i])){
				quantidadeLetras.replace(numero.split("")[i] ), quantidadeLetras.get((numero.split("")[i].hashCode() + 1));
			} else {
				quantidadeLetras.put(numero.split("")[i], 1);
			}
			
		}
		//System.out.println(quantidadeLetras.get("V"));
	}
}
