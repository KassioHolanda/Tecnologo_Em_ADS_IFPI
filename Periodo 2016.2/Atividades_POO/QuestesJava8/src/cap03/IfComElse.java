package cap03;

import javax.swing.*;

public class IfComElse {
	public static void main(String[] args) {
		String aux = JOptionPane.showInputDialog("Forneca o numero do mes: ");
		if (aux != null) {
			try {
				int mes = Integer.parseInt(aux);
				if (mes >=1 && mes <= 12){
					JOptionPane.showMessageDialog(null, "Numero do mes invalido!\n" + mes);
				} else {
					JOptionPane.showMessageDialog(null, "Numero do mes invalido!\n" + mes);
				}
			} catch (NumberFormatException erro){
			JOptionPane.showMessageDialog(null, "Digite apenas valores inteiros " + erro);
		}
	} else {
		JOptionPane.showMessageDialog(null, "operaacao cancelada");
	}
	System.exit(0);	
	}
}
