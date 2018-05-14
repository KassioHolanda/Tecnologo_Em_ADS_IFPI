package ExerciciosCapitulo05;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Questao01 {
	public static void main(String[] args) {
		Double[] notas = new Double[5];
		Double media = 0.0;

		for (int i = 0; i < notas.length; i++) {
			int aux = i + 1;
			String mensagem = JOptionPane.showInputDialog("Nota " + aux + ":");
			notas[i] = (double) Float.parseFloat(mensagem);
			media += notas[i];
		}

		double imprimirMedia = (media / 5);
		System.out.println("A media é: " + imprimirMedia+"\n\n");

		Arrays.sort(notas);
		for (int i = 1; i <= 5; i++) {
			System.out.println(notas[i]);
		}

	}
}
