package br.com.sistemadetransporteurbano.domain;

public class EmpresaOnibus {
	private Funcionario funcionario;
	private Linha linha;

	public EmpresaOnibus(Funcionario funcionario, Linha linha) {
		this.funcionario = funcionario;
		this.linha = linha;

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public Linha getLinha() {
		return linha;
	}

}
