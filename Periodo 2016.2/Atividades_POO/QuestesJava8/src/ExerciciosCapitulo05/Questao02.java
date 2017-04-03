package ExerciciosCapitulo05;

import java.util.Random;

public class Questao02 {
	public static void main(String[] args) {
		String[] anos = { "janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro",
				"outubro", "novembro", "dezembro" };
		Random rand = new Random();

		int posicao = rand.nextInt(11);

		System.out.println("o mes sorteado foi: " + anos[posicao]);

	}
}
