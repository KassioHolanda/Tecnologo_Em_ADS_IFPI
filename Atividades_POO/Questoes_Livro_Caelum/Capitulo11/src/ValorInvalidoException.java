
//public class ValorInvalidoException extends Exception{
public class ValorInvalidoException extends RuntimeException{
	public ValorInvalidoException(double valor) {
		super("Valor invalido: " + valor);
	}
}
