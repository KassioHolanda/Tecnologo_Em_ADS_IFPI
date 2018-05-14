package cap03;

import javax.swing.*;

public class IfComElseAnimado {
	public static void main(String[] args) {
		String aux = JOptionPane.showInputDialog("Forneca o numero do mes: ");
		if (aux != null) {
			try {
				int mes = Integer.parseInt(aux);
				if (mes == 1) {
					aux = "Janeiro";
				} else if (mes == 2) {
					aux = "fevereiro";
				} else {
					aux = "mes desconhecido";
				}
				JOptionPane.showMessageDialog(null, aux);
			} catch (NumberFormatException erro) {
				JOptionPane.showMessageDialog(null, "digite apenas valores inteiros" + erro);		}
			}
		}
	System.exit(0);
	}
}
