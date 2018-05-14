package cap03;

import javax.swing.JOptionPane;

public interface SwitchCase {
	public static void main(String[] args) {
		String mes = (String) JOptionPane.showInputDialog("Forneça o numero do mes: ");
		if (mes != null) {
			switch (mes) {
			case "1":
				mes = "janeiro";
				break;
			case "2":
				mes = "fevereiro";
			default:
				mes = "mes desconhecido";
				break;
			}
			JOptionPane.showMessageDialog(null, mes);
		}
		System.out.println(0);
	}
}
