package ExerciciosCapitulo05;

import java.util.Random;

import javax.swing.JOptionPane;

public class Questao03 {
	public static void main(String[] args) {
		Random rand = new Random();
		int[][] imagem = new int[40][40];
		String valores = " ";

		for (int linha = 0; linha < 40; linha++) {
			for (int coluna = 0; coluna < 40; coluna++) {
				imagem[linha][coluna] = rand.nextInt(255);
			}
		}
		
		for (int linha = 0; linha < imagem.length; linha++) {
			for (int coluna = 0; coluna < imagem[linha].length; coluna++) {
				valores += imagem[linha][coluna] + ",";
			}
		}
		
		JOptionPane.showMessageDialog(null, "Valores gerados: " + valores);
	}
}
