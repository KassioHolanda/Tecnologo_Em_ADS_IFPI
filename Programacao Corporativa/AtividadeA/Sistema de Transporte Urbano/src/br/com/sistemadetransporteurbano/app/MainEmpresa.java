package br.com.sistemadetransporteurbano.app;

import br.com.sistemadetransporteurbano.domain.EmpresaOnibus;
import br.com.sistemadetransporteurbano.domain.EscalaFuncionario;
import br.com.sistemadetransporteurbano.domain.EscalaLinha;
import br.com.sistemadetransporteurbano.domain.Funcionario;
import br.com.sistemadetransporteurbano.domain.Linha;
import br.com.sistemadetransporteurbano.domain.Onibus;
import br.com.sistemadetransporteurbano.domain.Paradas;

public class MainEmpresa {

	public static void main(String[] args) {
		Onibus onibus = new Onibus(123312);
		Paradas paradas = new Paradas(13, "São Paulo");
		EscalaLinha escalaLinha = new EscalaLinha(onibus, "8:00", paradas);
		Linha linha = new Linha(escalaLinha, 405);

		EscalaFuncionario escalaFuncionario = new EscalaFuncionario("12:00", linha);
		Funcionario funcionario = new Funcionario("Kassio", "123", escalaFuncionario);

		EmpresaOnibus empresa = new EmpresaOnibus(funcionario, linha);

		System.out.println("Bairro Linha de Onibus: " + empresa.getLinha().getEscalaLinha().getParadas().getBairroParada());
	}

}
