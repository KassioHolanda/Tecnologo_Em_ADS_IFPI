package Exercicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {
	protected String nome;
	private List<Banco> contas = new ArrayList();
	static private Map<String, Banco> contas2 = new HashMap<String, Banco>();
	
	public Banco(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	void adicionar(Banco c){
		this.contas.add(c);
	}
	
	void pegaConta(int x){
		this.contas.get(x);
	}
	
	int pegaQuantidadeDeContas(){
		return contas.size();
	}
	
	String buscaPorNome(String nome){
		for (Banco object : contas) {
			object.equals(nome);
			return "nome encontrado";
		}
		return "nome nao encontrado";
	}
	
	
	
	//metodos para hashMap
	
	static void adicionar(String nome, Banco c){
		contas2.put(nome, c);
	}
	
	static String buscaPorNome2(String nome){
		if(contas2.containsKey(nome)){
			return "Chave encontrada";
		}
		return "Chave nao encontrada";
	}

	
	
}
