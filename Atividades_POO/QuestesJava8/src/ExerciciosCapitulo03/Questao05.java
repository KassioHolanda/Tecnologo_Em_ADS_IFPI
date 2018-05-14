package ExerciciosCapitulo03;

import javax.swing.JOptionPane;

public class Questao05 {
	public static void main(String[] args) {
		String op = JOptionPane.showInputDialog("qual questao vc deseja: \n1 - 1\n2 - 2\n3 - 3\n4 - \n5 - 5");

		switch (op) {
		case "1":
			String nome = JOptionPane.showInputDialog("Qual o nome do produto: ");

			String dado = JOptionPane.showInputDialog("qual o valor do produto; ");
			Float valor = Float.parseFloat(dado);

			if (valor >= 50 && valor < 200) {
				JOptionPane.showMessageDialog(null, "Nome do produto: " + nome + "\nValor original do produto: " + valor
						+ "\nValor do produto com desconto: " + (valor - (valor * 5 / 100)));
			} else if (valor >= 200 && valor < 500) {
				JOptionPane.showMessageDialog(null, "Nome do produto: " + nome + "\nValor original do produto: " + valor
						+ "\nValor do produto com desconto: " + (valor - (valor * 6 / 100)));
			} else if (valor >= 500 && valor < 1000) {
				JOptionPane.showMessageDialog(null, "Nome do produto: " + nome + "\nValor original do produto: " + valor
						+ "\nValor do produto com desconto: " + (valor - (valor * 7 / 100)));
			} else if (valor >= 1000) {
				JOptionPane.showMessageDialog(null, "Nome do produto: " + nome + "\nValor original do produto: " + valor
						+ "\nValor do produto com desconto: " + (valor - (valor * 8 / 100)));
			} else if (valor < 0) {
				JOptionPane.showMessageDialog(null, "Valor invalido");
			}
			JOptionPane.showMessageDialog(null, "Nome do produto: " + nome + "\nValor original do produto: " + valor
					+ "\nValor do produto com desconto: " + valor);

			break;
		case "2":
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

			JOptionPane.showMessageDialog(null, "Resistencias Fornecidas: \n" + r1 + ", " + r2 + ", " + r3 + ", " + r4
					+ "\nMenor resistencia: " + menor + "\nMaior Resistencia: " + maior);

			break;
		case "3":
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
						JOptionPane.showMessageDialog(null,
								"Falha, verifique seu login e senha\nVoce so tem 2 tentativas");
						break;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Falha, verifique seu login e senha\nVoce so tem 1 tentativas");
					break;
				case "4":
					String dados = JOptionPane.showInputDialog(null, "Informe um numero: ");
					int numero = Integer.parseInt(dados);
					JOptionPane.showMessageDialog(null,
							(numero + "x 1 = " + (numero * 1)) + "\n" + (numero + "x 2 = " + (numero * 2)) + "\n"
									+ (numero + "x 3 = " + (numero * 3)) + "\n" + (numero + "x 4 = " + (numero * 4))
									+ "\n" + (numero + "x 5 = " + (numero * 5)) + "\n"
									+ (numero + "x 6 = " + (numero * 6)) + "\n" + (numero + "x 7 =" + (numero * 7))
									+ "\n" + (numero + "x 8 = " + (numero * 8)) + "\n"
									+ (numero + "x 9 = " + (numero * 9)) + "\n" + (numero + "x 10 = " + (numero * 10)));
					break;
				
				}
			}
		}
	}
}