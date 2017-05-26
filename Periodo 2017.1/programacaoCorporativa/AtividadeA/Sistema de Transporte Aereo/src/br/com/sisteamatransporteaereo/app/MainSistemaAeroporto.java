package br.com.sisteamatransporteaereo.app;

import br.com.sisteamatransporteaereo.domain.Aeroporto;
import br.com.sisteamatransporteaereo.domain.Aviao;
import br.com.sisteamatransporteaereo.domain.Cargo;
import br.com.sisteamatransporteaereo.domain.CompanhiaAerea;
import br.com.sisteamatransporteaereo.domain.EscalaAviao;
import br.com.sisteamatransporteaereo.domain.EscalaFuncionario;
import br.com.sisteamatransporteaereo.domain.Funcionarios;
import br.com.sisteamatransporteaereo.domain.SistemaAeroporto;

public class MainSistemaAeroporto {
	public static void main(String[] args) {
		EscalaFuncionario escalaFuncionario = new EscalaFuncionario("12:30");
		Cargo cargo = new Cargo("Piloto");
		Funcionarios funcionarios = new Funcionarios("Kassio", "123", escalaFuncionario, cargo);
		
		EscalaAviao escalaAviao = new EscalaAviao("12:00","Brasil", "Passando pela Argentina, e fazendo um parada na Espanha", "Inglaterra");
		Aviao aviao = new Aviao(1, 80, escalaAviao);
		
		Cargo cargo2 = new Cargo("Atendente");
		Funcionarios funcionarios2 = new Funcionarios("Karlos", "234", escalaFuncionario, cargo2);
		
		CompanhiaAerea companhiaAerea= new CompanhiaAerea(aviao, funcionarios2);
		
		Aeroporto aeroporto = new Aeroporto(funcionarios, companhiaAerea);
		SistemaAeroporto sistemAeroporto = new SistemaAeroporto(aeroporto);
		
		
		System.out.println("Local de Saida: " + sistemAeroporto.getAeroporto().getCompanhiaAerea().getAviao().getEscalaAviao().getLocalDeSaida());
	}
}
