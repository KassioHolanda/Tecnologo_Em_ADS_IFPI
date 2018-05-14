/* Considere a seguinte informação a respeito do cálculo da aposentadoria. Para se aposentar por idade,
as mulheres precisam ter atingido 60 anos de idade e os homens, 65. Já na aposentadoria por
tempo de contribuição, o tempo mínimo exigido é de 30 anos para as mulheres e de 35 anos para os
homens. Com base nessas informações, elabore uma classe que receba a idade de uma pessoa, seu
sexo e a quantidade de anos de contribuição. A seguir, calcule a quantidade de anos que falta de contribuição
para se aposentar, ou então emita a mensagem: “você já tem o direito a aposentadoria”. */

package ExerciciosCapitulo02;

import javax.swing.JOptionPane;

public class Questao05 {
	public static void main(String[] args) {
		String dado1 = JOptionPane.showInputDialog("Qual a sua idade: ");
		int idade = Integer.parseInt(dado1);
		
		String dado2 = JOptionPane.showInputDialog("selecione seu sexo(1 - masculino, 2 - feminino: ");
		int sexo = Integer.parseInt(dado2);
		
		String dado3 = JOptionPane.showInputDialog("por quantos anos voce trabalhou: ");
		int trabalho = Integer.parseInt(dado3);
		
		int aposentarHomem = 65 - idade;
		int aposentarMulher = 60 - idade;
		
		int contribuicaoHomem = 35 - trabalho;
		int contribuicaoMulher = 30 - trabalho;
		
		if (sexo == 1){
			if (idade >= 65) {
				JOptionPane.showMessageDialog(null, "Voce ja tem idade para se aposentar");
			}
		} if (sexo == 1){
			if (idade < 65){
				JOptionPane.showMessageDialog(null, "Voce nao tem idade para se aposentar, ainda faltam " + contribuicaoHomem + " anos de contribuição, e " + aposentarHomem + " anos de idade para aposentar");
			}
		} if (sexo ==2) {
			if (idade >= 60) {
				JOptionPane.showMessageDialog(null, "Voce ja tem idade para se aposentar");
			}
		} if(sexo ==2) {
			if (idade < 60){
				JOptionPane.showMessageDialog(null, "Voce nao tem idade para se aposentar, ainda faltam " + contribuicaoHomem + " anos de contribuição, e " + aposentarHomem + " anos de idade para aposentar");
			}
		}	
	}
}
