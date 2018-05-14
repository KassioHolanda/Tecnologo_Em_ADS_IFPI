package capitulo;

public class Gerente {
	String nome;
	String cpf;
	double salario;
	int senha;
	int numeroDeFuncionarioGerenciados;
	
	public boolean autentica(int senha){
		System.out.println("Acesso permitido");
		return true;
//	} else {
//		System.out.println("Acesso Negado");
//		return false;
	}
	
}
