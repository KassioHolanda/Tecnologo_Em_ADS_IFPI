package Cap02;
import java.util.*;
public class EntradaComScanner {
	public static void main(String[] args) {
		float largura, comprimento, area, perimetro;
		Scanner sc;
		
		try {
			System.out.println("Entre com o comprimento");
			sc = new Scanner(System.in);
			comprimento = sc.nextFloat();
			
			System.out.println("entre com largura");
			sc = new Scanner(System.in);
			largura = sc.nextFloat();
			
			area = comprimento * largura;
			perimetro = comprimento * 2 + largura * 2;
			System.out.println("area do retangulo: " + area);
			System.out.println("perimentro do retangulo: " + perimetro);
		} catch (NumberFormatException erro) {
			System.out.println("houve um erro na conversao, digite apenas caracteres numericos");
			// TODO: handle exception
		}
	}
}
