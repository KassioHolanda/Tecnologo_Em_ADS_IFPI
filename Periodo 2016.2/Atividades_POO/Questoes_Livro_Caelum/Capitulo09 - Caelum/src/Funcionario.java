
abstract class Funcionario {
	protected String nome;
	protected String cpf;
	protected double salario;

	public double getBonificacao() {
		return this.salario * 1.2;
	}
}

// DESAFIO: PORQUE NOS ESTAMOS INSTANCIANDO A CONTA, ESTAMOS APENAS USANDO SEUS
// METODOS E COLOCANDO DENTRO DE UM ARRAY;