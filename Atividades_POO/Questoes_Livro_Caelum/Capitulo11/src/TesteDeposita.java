
public class TesteDeposita {
	public static void main(String[] args) {
		Conta novo = new Conta();
		try {
			novo.deposita(-100);
		} catch (ValorInvalidoException e){
			System.out.println(e.getMessage());
		}
	}
}
