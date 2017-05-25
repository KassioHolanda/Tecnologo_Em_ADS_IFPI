package br.com.sistemadetransporteurbano;

import java.util.ArrayList;

public class EmpresaOnibus {
	private Funcionario funcionario;
	private Onibus onibus;
	private ArrayList<Onibus> onibusEmpresa;
	private ArrayList<Funcionario> funcionarioEmpresa;
	
	public EmpresaOnibus(Funcionario funcionario, Onibus onibus) {
		this.funcionario = funcionario;
		this.onibus = onibus;
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
	
	public Onibus getOnibus() {
		return onibus;
	}

}
