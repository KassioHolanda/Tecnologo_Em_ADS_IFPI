/* Na área da eletrônica, em um circuito em série temos que a resistência equivalente (total) desse
circuito é obtida mediante a soma de todas
as resistências existentes (RE = r1 + r2 + ... + rn).
Faça uma classe que receba o valor de quatro
resistências ligadas em série, calcule e mostre a
resistência equivalente, a maior e a menor resistência,
conforme indica a Figura 3.17. */

package ExerciciosCapitulo03;

import javax.swing.JOptionPane;

public class Questao02 {
	public static void main(String[] args) {
		
		int maior = 0;
		int menor = 100000;
		
		String dado1 = JOptionPane.showInputDialog("digite a resistencia 1: ");
		int r1 = Integer.parseInt(dado1);
		
		String dado2 = JOptionPane.showInputDialog("digite a resistencia 2: ");
		int r2 = Integer.parseInt(dado2);
		
		String dado3 = JOptionPane.showInputDialog("digite a resistencia 3: ");
		int r3 = Integer.parseInt(dado3);
		
		String dado4 = JOptionPane.showInputDialog("digite a resistencia 4: ");
		int r4 = Integer.parseInt(dado4);
		
		if (r1 > maior) {
			maior = r1;
		}
		if (r2 > maior) {
			maior = r2;
		}
		if (r3 > maior) {
			maior = r3;
		}
		if (r4 > maior) {
			maior = r4;
		}
		
		
		if (r1 < r2 && r1 < r3 && r1 < r4) {
			menor = r1;
		}
		if (r2 < r1 && r2 < r3 && r2 < r4) {
			menor = r2;
		}
		if (r3 < r2 && r3 < r1 && r3 < r4) {
			menor = r3;
		}
		if (r4 < r2 && r4 < r3 && r4 < r1) {
			menor = r4;
		}
			
			
		JOptionPane.showMessageDialog(null, "Resistencias Fornecidas: \n" + r1 + ", " + r2 + ", " + r3 + ", " + r4 + "\nMenor resistencia: " + menor + "\nMaior Resistencia: " + maior);
	}
}
