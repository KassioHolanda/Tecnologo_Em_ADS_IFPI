import java.util.InputMismatchException;
import java.util.Scanner;

public class TestandoException {
	public static void main(String a[]) {
		Scanner teclado = new Scanner(System.in);
		int mes;
		String meses[] = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro" };

		mes = 999;
		while (mes != 0) {
			System.out.print("Digite o número do mês (0 para Fim): ");
			try {
				mes = teclado.nextInt();
				System.out.println("Nome do mês = " + meses[mes - 1]);
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!!!");
				teclado.nextLine();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Número do mês inválido!");
				teclado.nextLine();
			}

		}
		System.out.println("FIM DO PROGRAMA");
	}

}
