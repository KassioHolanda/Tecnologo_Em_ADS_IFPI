package TesteNumerosRomanos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.NumerosRomanos;

public class NumerosRomanosTest {

	NumerosRomanos numerosRomanos;
	
	@Before
	public void init(){
		numerosRomanos = new NumerosRomanos();
	}
	
	@Test
	public void consultarLetrasDentroDoSistemaNumeroRomano() {
		assertEquals(1, numerosRomanos.pegarNumero("K"), 0);
	}

}
