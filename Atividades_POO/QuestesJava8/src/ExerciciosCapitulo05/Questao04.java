package ExerciciosCapitulo05;

import java.util.Random;

import javax.swing.JOptionPane;

public class Questao04 {
	public static void main(String[] args) {
		Random rand = new Random();

		int[] par = new int[10];
		int[] impar = new int[10];

		for (int i = 0; i < 10; i++) {
			int numero = rand.nextInt(20);

			if (numero % 2 == 0) {
				par[i] = numero;
			} else {
				impar[i] = numero;
			}
		}

		String novosPares = " ";
		String novosImpares = " ";

		for (int i = 0; i < par.length; i++) {
			if (par[i] != 0) {
				novosPares += par[i] + " ";
			}
		}

		for (int i = 0; i < impar.length; i++) {
			if (impar[i] != 0) {
				novosImpares += impar[i] + " ";
			}
		}

		JOptionPane.showMessageDialog(null, "numeros Pares: " + novosPares + "\nNumers Impares: " + novosImpares);

	}
}
