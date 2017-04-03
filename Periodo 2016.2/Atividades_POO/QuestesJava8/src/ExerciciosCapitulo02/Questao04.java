/* Usando a classe JOptionPane para entrada de dados, elabore uma classe que receba a nota de
duas provas e de um trabalho. Calcule e mostre a média e o resultado final (aprovado ou reprovado).
Para calcular a média utilize a fórmula seguinte: média = (nota da prova 1 + nota da prova 2 +
nota do trabalho) / 3. Considere que a média mínima para aprovação é 6. */

package ExerciciosCapitulo02;

import javax.swing.JOptionPane;

public class Questao04 {
	public static void main(String[] args) {
		
		String dado1 = JOptionPane.showInputDialog("qual a nota1: ");
		Float nota1 = Float.parseFloat(dado1);
		
		String dado2 = JOptionPane.showInputDialog("qual a nota2: ");
		Float nota2 = Float.parseFloat(dado2);
		
		String dado3 = JOptionPane.showInputDialog("qual a nota do trabalho: ");
		Float trabalho = Float.parseFloat(dado3);
		
		Float media = (nota1 + nota2 + trabalho)/3;
		
		if (media >= 6) {
			JOptionPane.showMessageDialog(null,"voce esta aprovado");
		} else {
			JOptionPane.showMessageDialog(null, "vai estudade de novo, tu nao passou");
		}
		
	}
}
