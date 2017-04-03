/* Usando JOptionPane, elabore uma classe que receba o nome de um produto e o seu valor. O desconto
deve ser calculado de acordo com o valor fornecido conforme a Tabela 3.1. Utilizando a estrutura
if-else, apresente em tela o nome do produto, valor original do produto e o novo valor depois de
ser realizado o desconto. Caso o valor digitado seja menor que zero, deve ser emitida uma mensagem
de aviso. A Figura 3.16 ilustra a execução do Exercício 3.1. */

package ExerciciosCapitulo03;

import javax.swing.JOptionPane;

public class Questao01 {
	public static void main(String[] args) {
			
		String nome = JOptionPane.showInputDialog("Qual o nome do produto: ");
		
		String dado = JOptionPane.showInputDialog("qual o valor do produto; ");
		Float valor = Float.parseFloat(dado);
		
		if (valor >= 50 && valor < 200){
            JOptionPane.showMessageDialog(null, "Nome do produto: "+ nome +"\nValor original do produto: "+valor +"\nValor do produto com desconto: " +(valor -(valor * 5/100)));
        }
        else if(valor >= 200 && valor < 500){
            JOptionPane.showMessageDialog(null, "Nome do produto: "+ nome +"\nValor original do produto: "+valor +"\nValor do produto com desconto: " +(valor -(valor * 6/100)));
        }
        else if(valor >= 500 && valor < 1000){
            JOptionPane.showMessageDialog(null, "Nome do produto: "+ nome +"\nValor original do produto: "+valor +"\nValor do produto com desconto: " +(valor -(valor * 7/100)));
        }        
        else if(valor >= 1000){
            JOptionPane.showMessageDialog(null, "Nome do produto: "+ nome +"\nValor original do produto: "+valor +"\nValor do produto com desconto: " +(valor -(valor * 8/100)));
        }        
        else if(valor < 0){
            JOptionPane.showMessageDialog(null, "Valor invalido");
        }        
        JOptionPane.showMessageDialog(null, "Nome do produto: "+ nome +"\nValor original do produto: "+valor +"\nValor do produto com desconto: " +valor);
	}
}
