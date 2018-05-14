package App;

import Domain.ContaCorrente;
import Domain.GerenciadorDeImpostoDeRenda;
import Domain.SeguroDeVida;

public class TesteGerenciadorDeImpostoDeRenda {
	public static void main(String[] args) {
		GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
		SeguroDeVida seguro = new SeguroDeVida();
		
		gerenciador.adiciona(seguro);
		
		ContaCorrente cc = new ContaCorrente();
		cc.deposita(1000);
		
		gerenciador.adiciona(cc);
		
		System.out.println(gerenciador.getTotal());
		
		System.out.printf("O saldo é: %.2f", cc.getSaldo());
	}
}
