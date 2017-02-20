package ExerciciosCapitulo03;

import javax.swing.JOptionPane;

public class Questao03 {
	public static void main(String[] args) {
		String login = JOptionPane.showInputDialog("Digite seu login: ");

		for (int cont = 3; cont > 0; cont--) {
			switch (login) {
			case "java08":
				String senha = JOptionPane.showInputDialog("Digite sua senha: ");
				switch (senha) {
				case "java08":
					JOptionPane.showMessageDialog(null, "Login e Senha aceitos");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Falha, verifique seu login e senha\nVoce so tem 2 tentativas");
					break;
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Falha, verifique seu login e senha\nVoce so tem 1 tentativas");
				break;

			}
		}
	}
}
