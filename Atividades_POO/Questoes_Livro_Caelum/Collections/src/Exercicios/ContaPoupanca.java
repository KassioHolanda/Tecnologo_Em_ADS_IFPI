package Exercicios;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca>{

	@Override
	public int compareTo(ContaPoupanca o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}



}
	