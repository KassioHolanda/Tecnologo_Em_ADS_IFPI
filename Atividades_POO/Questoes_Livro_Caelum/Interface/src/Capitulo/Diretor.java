package Capitulo;

public class Diretor extends Funcionario implements Autenticavel{
	private int senha;

	public boolean autentica(int senha){
		if(this.senha != senha){
			return false;
		}
		
		return true;
	}
}

