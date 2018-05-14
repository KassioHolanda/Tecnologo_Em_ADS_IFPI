package cap03;

import javax.swing.JOptionPane;

public class If {
	public static void main(String[] args) {
		Object[] op = {"mascuino", "feminino"}; 
		String resp = (String) JOptionPane.showInputDialog(null, "Selecione o sexo:\n", "Pesquisa", JOptionPane.PLAIN_MESSAGE, null, op, "masculino");
		if (resp == null) {
			JOptionPane.showMessageDialog(null, "Voce é homem");
		} 
		if (resp == "masculino") {
			JOptionPane.showMessageDialog(null, "Voce é homem");
		} 
		if (resp == "feminino") {
			JOptionPane.showMessageDialog(null, "Voce é mulher");
		}
		System.exit(0);
	}	
}
