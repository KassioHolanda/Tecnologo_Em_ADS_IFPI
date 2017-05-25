package br.com.sistemadetransporteurbano;

public class Funcionario extends Pessoa{
	private EscalaFuncionario escalaFuncionario;
	

	public Funcionario(String nome, String cpf, EscalaFuncionario escalaFuncionario) {
		super(nome, cpf);
		this.escalaFuncionario = escalaFuncionario;
	}
	
	@Override
	public String getCpf() {
		return super.getCpf();
	}
	
	@Override
	public String getNome() {
		return super.getNome();
	}
	
	public EscalaFuncionario getEscala() {
		return escalaFuncionario;
	}

}
