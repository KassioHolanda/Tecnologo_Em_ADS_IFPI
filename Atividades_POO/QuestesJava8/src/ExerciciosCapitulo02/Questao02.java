package ExerciciosCapitulo02;

import java.util.Scanner;

public class Questao02 {
	public static void main(String[] args) {
		Integer pontosLider, pontosLanterna, diferenca;
		Scanner dado;
		
		try {
			System.out.println("Quantos pontos tem o lider do campeonato: ");
			dado = new Scanner(System.in);
			pontosLider = dado.nextInt();
			
			System.out.println("Quantos pontos tem o lanterna do campeonato");
			dado = new Scanner(System.in);
			pontosLanterna = dado.nextInt();
			
			diferenca = (pontosLider - pontosLanterna) / 3;
			System.out.println("A diferença de vitorias é de: " + diferenca);
		} catch (NumberFormatException erro) {
			System.out.println("houve um erro na conversao, digite apenas caracteres numericos");
			// TODO: handle exception
		}
	}
}
