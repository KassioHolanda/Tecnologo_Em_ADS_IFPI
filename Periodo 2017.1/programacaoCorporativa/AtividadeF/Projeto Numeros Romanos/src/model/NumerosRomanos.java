package model;

import java.util.HashMap;
import java.util.Map;

public class NumerosRomanos {
	private Map<String, Integer> listaNumeroRomanos = new HashMap();
	
	
	public NumerosRomanos() {
		listaNumeroRomanos.put("I", 1);
		listaNumeroRomanos.put("V", 5);
		listaNumeroRomanos.put("X", 10);
		listaNumeroRomanos.put("L", 50);
		listaNumeroRomanos.put("C", 100);
		listaNumeroRomanos.put("D", 500);
		listaNumeroRomanos.put("M", 1000);
	}
	
	public Integer pegarNumero(String letra){
		return listaNumeroRomanos.get(letra); 
	}
	
	
	
	
}

