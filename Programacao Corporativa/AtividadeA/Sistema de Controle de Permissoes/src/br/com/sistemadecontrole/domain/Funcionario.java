package br.com.sistemadecontrole.domain;

public class Funcionario extends Pessoa{
	private Permissoes permissoes;

	public Funcionario(String nome, String cpf) {
		super(nome, cpf);
		this.permissoes = new Permissoes();		
	}
	
	public void funcionarioAdministrador(){
		permissoes.mudarPerfilAdministrador();
	}
	
	public void funcioanarioPadrao(){
		permissoes.mudarPerfilPadrao();
	}

	public Permissoes getPermissoes() {
		return permissoes;
	}
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}
	
	@Override
	public String getCpf() {
		// TODO Auto-generated method stub
		return super.getCpf();
	}
}
