package capitulo;

public class EmpregadoDaFaculdade {
	private String nome;
	private double salario;
	double getGastos(){
		return this.salario;
	}
	
	String getInfo(){
		return "nome: " + this.nome + " com salario " + this.salario;
	}
	
	public double getSalario() {
		return salario;
	}
}
