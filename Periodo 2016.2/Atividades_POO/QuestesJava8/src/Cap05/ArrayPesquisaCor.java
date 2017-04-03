package Cap05;

import javax.swing.JOptionPane;

public class ArrayPesquisaCor {
	public static void main(String[] args) {
		String[] cores = {"verde", "amarelo", "azul", "vermelho", "preto"};
		String cor = JOptionPane.showInputDialog("forneca uma cor: ");
		String mensagem = "Cor nao encontrada";
		for (String elemento : cores) {
			if (elemento.equals(cor)) {
				mensagem = "Cor encontrada";
				break;
			}
		}
		JOptionPane.showMessageDialog(null, mensagem);
		System.exit(0);
	}
}
