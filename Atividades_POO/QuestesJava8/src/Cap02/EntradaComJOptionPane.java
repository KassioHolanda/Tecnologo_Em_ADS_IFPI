package Cap02;

import javax.swing.JOptionPane;

public class EntradaComJOptionPane {
	public static void main(String[] args) {
		String aux;
		float largura, comprimento, area, perimetro;
		try {
			aux = JOptionPane.showInputDialog("entre com o comprimento");
			comprimento = Float.parseFloat(aux);
			
			aux = JOptionPane.showInputDialog("entre com a largura: ");
			largura = Float.parseFloat(aux);
			
			area = comprimento * largura;
			perimetro = comprimento * 2 + largura * 2;
			JOptionPane.showMessageDialog(null, "Area: " + area +", perimetro: " + perimetro);
		} catch (NumberFormatException erro) {
			JOptionPane.showMessageDialog(null, "Houve erro na conversao, digite apenas caracteres numericos" + erro.toString());
			// TODO: handle exception
		}
		System.exit(0);
	}
}
