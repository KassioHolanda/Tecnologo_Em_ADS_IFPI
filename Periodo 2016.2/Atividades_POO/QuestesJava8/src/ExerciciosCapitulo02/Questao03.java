/* O Imposto sobre a Transmissão de Bens Móveis (ITBI) é aplicado sobre o valor de um imóvel a
ser negociado. A base de cálculo do ITBI (o valor a ser considerado no cálculo) será o maior valor
entre o valor de transação (o valor negociado) e o valor venal de referência (fornecido pela
Prefeitura). Com base nisso, elabore uma classe que receba o valor da transação, o valor venal e
o percentual de imposto. Após isso, encontre o maior valor e aplique o percentual sobre ele. Ao
final, apresente o valor do imposto a ser pago. Observação: o valor do imposto a ser pago é calculado
por meio da fórmula: valor do imposto = maior valor * percentual / 100. Para entrada e saída
de dados utilize a classe JOptionPane. */

package ExerciciosCapitulo02;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Questao03 {
	public static void main(String[] args) {
		String aux;
		float valorTransacao, valorVenal, percentualImposto, valorImposto, maiorValor;
		try {
			aux = JOptionPane.showInputDialog("qual o valor da transação: ");
			valorTransacao = Float.parseFloat(aux);
			
			aux = JOptionPane.showInputDialog("qual o valor venal: ");
			valorVenal = Float.parseFloat(aux);
			
			aux = JOptionPane.showInputDialog("qual o percentual de imposto: ");
			percentualImposto = Float.parseFloat(aux);
			
			if (valorTransacao > valorVenal){
				maiorValor = valorTransacao;
			} else {
				maiorValor = valorVenal;
			}
			
			valorImposto = (maiorValor * percentualImposto) / 100;
			
			JOptionPane.showMessageDialog(null, "Valor do imposto: " + valorImposto);
		} catch (NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Houve erro na conversao, digite apenas caracteres numericos" + erro.toString());
			// TODO: handle exception
		}
		System.exit(0);
	}
}
