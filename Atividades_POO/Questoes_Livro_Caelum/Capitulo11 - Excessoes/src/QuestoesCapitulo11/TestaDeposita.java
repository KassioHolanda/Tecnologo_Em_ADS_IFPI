package QuestoesCapitulo11;

public class TestaDeposita {
	public static void main(String[] args) {
		Conta contapoupansa = new Conta();
		try {
			contapoupansa.deposita(-10);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(contapoupansa.getSaldo());
	}
}
