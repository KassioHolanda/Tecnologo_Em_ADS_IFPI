package br.com.sistemadetransporteurbano;

public class MainEmpresa {
	
	public static void main(String[] args) {
		Paradas paradas = new Paradas(13, "São Paulo");
		Linha linha = new Linha(paradas, 1);
		EscalaOnibus escalaOnibus = new EscalaOnibus("12:30", linha);
		Onibus onibus = new Onibus(1, escalaOnibus);
		EscalaFuncionario escalaFuncionario = new EscalaFuncionario("12:00", onibus);
		Funcionario funcionario = new Funcionario("Kassio", "123", escalaFuncionario);
		
		
		System.out.println("Bairro Linha de Onibus: " + funcionario.getEscalaFuncionario().getOnibus().getEscalaOnibus().getLinha().getParadas().getBairroParada());
		
	}
	
}
