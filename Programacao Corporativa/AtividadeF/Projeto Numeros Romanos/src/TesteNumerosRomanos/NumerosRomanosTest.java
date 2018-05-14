package TesteNumerosRomanos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.NumerosRomanos;

public class NumerosRomanosTest {

	NumerosRomanos numerosRomanos;

	@Before
	public void init() {
		numerosRomanos = new NumerosRomanos();
	}

	@Test
	public void consultarLetrasDentroDoSistemaNumeroRomano() {
		assertEquals(1, numerosRomanos.pegarNumero("I"), 0);
		assertEquals(5, numerosRomanos.pegarNumero("V"), 0);
		assertEquals(10, numerosRomanos.pegarNumero("X"), 0);
		assertEquals(50, numerosRomanos.pegarNumero("L"), 0);
		assertEquals(100, numerosRomanos.pegarNumero("C"), 0);
		assertEquals(500, numerosRomanos.pegarNumero("D"), 0);
		assertEquals(1000, numerosRomanos.pegarNumero("M"), 0);    
	}

	@Test
	public void letrasNaoPodemRepetirMaisDeTresVezes() {
		String romano;
		
		
	}

}
