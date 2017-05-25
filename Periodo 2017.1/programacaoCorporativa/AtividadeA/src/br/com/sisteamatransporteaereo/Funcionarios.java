package br.com.sisteamatransporteaereo;

public class Funcionarios extends Pessoa{
	private EscalaFuncionario escalaFuncionario;
	private Cargo cargo;
	
	public Funcionarios(String nome, String cpf, EscalaFuncionario escalaFuncionario, Cargo cargo) {
		super(nome, cpf);
		this.escalaFuncionario = escalaFuncionario;
		this.cargo = cargo;
	}

	public EscalaFuncionario getEscala() {
		return escalaFuncionario;
	}

	public Cargo getCargo() {
		return cargo;
	}
	
	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}

}
