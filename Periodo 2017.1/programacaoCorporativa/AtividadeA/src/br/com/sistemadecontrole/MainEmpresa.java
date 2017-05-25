package br.com.sistemadecontrole;

public class MainEmpresa {
	public static void main(String[] args) {
		Funcionario funcionario = new Funcionario("Kassio", "123");
		Empresa empresa = new Empresa(funcionario);
		
		
		System.out.println("Tipo de perfil: " + empresa.getFuncionario().getPermissoes().getPerfil());
		
		//Mudando perfil para ADM
		empresa.getFuncionario().getPermissoes().mudarPerfilAdministrador();
		System.out.println("Tipo de Perfil: " + empresa.getFuncionario().getPermissoes().getPerfil());

	}
}
