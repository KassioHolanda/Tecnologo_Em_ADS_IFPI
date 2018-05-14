package App;

import Domain.Circulo;
import Domain.Retangulo;
import Interfaces.AreaCalculavel;

public class Teste {
	public static void main(String[] args) {
		AreaCalculavel area = new Retangulo(3, 2);
		System.out.println(area.calculaArea());
		
		AreaCalculavel circulo = new Circulo(3);
		System.out.println(circulo.calculaArea());
	}
}
