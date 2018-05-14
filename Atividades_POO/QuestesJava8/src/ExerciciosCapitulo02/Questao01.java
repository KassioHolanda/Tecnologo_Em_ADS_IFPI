/* Usando a classe BufferedReader para entrada de dados, crie uma classe que receba o valor de um
produto e a porcentagem de desconto, calcule e mostre o valor do desconto e o valor do produto
com o desconto. Observação: o valor do desconto é calculado por meio da fórmula: valor do desconto
= valor do produto * percentual de desconto / 100.*/

package ExerciciosCapitulo02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Questao01 {
	public static void main(String[] args) {
		String s;
		float valorDoProduto, porcentagem, desconto;
		BufferedReader dado;
		try {
			System.out.println("Qual o valor do produto");
			dado = new BufferedReader(new InputStreamReader(System.in));
			s = dado.readLine();
			valorDoProduto = Float.parseFloat(s);
			
			System.out.println("Qual a porcentagem do desconto");
			dado = new BufferedReader(new InputStreamReader(System.in));
			s = dado.readLine();
			porcentagem = Float.parseFloat(s);
			
			desconto = ((valorDoProduto * porcentagem)/100);
			
			System.out.println("o desconto do produto foi de: " + desconto);
		} catch (IOException erro) {
			System.out.println("Houve um erro na entrada de dados" + erro.toString());
		} catch (NumberFormatException erro) {
			System.out.println("Houve um erro na conversao, digite apenas caracteres numericos" + erro.toString());
				
		}

	}
}
