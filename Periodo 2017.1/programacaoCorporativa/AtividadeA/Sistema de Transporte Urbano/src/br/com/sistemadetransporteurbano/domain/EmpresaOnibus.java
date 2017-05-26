package br.com.sistemadetransporteurbano.domain;

import java.util.ArrayList;

public class EmpresaOnibus {
	private Funcionario funcionario;
	private Linha linha;
	private ArrayList<Onibus> onibusEmpresa;
	private ArrayList<Funcionario> funcionarioEmpresa;
	
	public EmpresaOnibus(Funcionario funcionario, Linha linha) {
		this.funcionario = funcionario;
		this.linha = linha;
		this.onibusEmpresa = new ArrayList<>();
		this.funcionarioEmpresa = new ArrayList<>();
	}
	
	public void adicionarFuncionarioEmpresa(Funcionario funcionario) {
		funcionarioEmpresa.add(funcionario);
	}
	
	public void adicionarOnibusEmpresa(Onibus onibus){
		this.onibusEmpresa.add(onibus);
	}
	
	public ArrayList<Funcionario> getFuncionarioEmpresa() {
		return funcionarioEmpresa;
	}
	
	public ArrayList<Onibus> getOnibusEmpresa() {
		return onibusEmpresa;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public Linha getLinha() {
		return linha;
	}

}
