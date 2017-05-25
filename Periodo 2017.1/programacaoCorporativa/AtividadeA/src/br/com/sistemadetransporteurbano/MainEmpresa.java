package br.com.sistemadetransporteurbano;

import br.com.sistemadecontrole.Empresa;

public class MainEmpresa {
	
	public static void main(String[] args) {
		Paradas paradas = new Paradas(13, "São Paulo");
		Linha linha = new Linha(paradas, 1);
		EscalaOnibus escalaOnibus = new EscalaOnibus("12:30", linha);
		Onibus onibus = new Onibus(1, escalaOnibus);
		EscalaFuncionario escalaFuncionario = new EscalaFuncionario("12:00", onibus);
		Funcionario funcionario = new Funcionario("Kassio", "123", escalaFuncionario);
		
		EmpresaOnibus empresa = new EmpresaOnibus(funcionario, onibus);
		
		
		System.out.println("Bairro Linha de Onibus: " + empresa.getFuncionario().getEscalaFuncionario().getOnibus().getEscalaOnibus().getLinha().getParadas().getBairroParada());
		
	}
	
}
