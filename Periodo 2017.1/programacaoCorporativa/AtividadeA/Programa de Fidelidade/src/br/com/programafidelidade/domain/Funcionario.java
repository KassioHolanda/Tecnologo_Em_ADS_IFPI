package br.com.programafidelidade.domain;

public class Funcionario extends Pessoa{
	private double Salario;
	private String horarioDeTrabalho;
	private int identificadoEstabelicimento;
	
	public Funcionario(String nome, String cpf, String horarioDeTrabalho, int identificadorEstabelecimento) {
		super(nome, cpf);
		this.horarioDeTrabalho = horarioDeTrabalho;
		this.identificadoEstabelicimento = identificadorEstabelecimento;
		this.Salario = 1200.00;
	}
	
	
	public void getAumentoFuncionario(Funcionario funcionario, double valor){
		funcionario.Salario += valor;
	}
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}
	
	public String getHorarioDeTrabalho() {
		return horarioDeTrabalho;
	}
	
	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}
	
	public int getIdentificadoEstabelicimento() {
		return identificadoEstabelicimento;
	}
	
	public double getSalario() {
		return Salario;
	}

}
