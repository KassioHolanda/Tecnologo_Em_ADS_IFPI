package Cap02;

public class OperadoresAritmeticos {
	public static void main(String[] args) {
		// declaração e inicialização de variaveis
		int x = 10;
		int y = 3;
		// varias operaçoes com as variaveis
		System.out.println("X = " + x);
		System.out.println("y: " + y);
		System.out.println("-x: " + (-x));
		System.out.println("X/y: " + (x/y));
		System.out.println("resto de x por y" + (x % y)); // resultado 1
		System.out.println("inteiro de x por y: " + (int) (x/y));
		System.out.println("X + 1: " + (++x));//resultado 11		
	}
}
