package co.com.prueba_cyxtera;

import static org.junit.Assert.*;

import org.junit.Test;

import co.com.prueba_cyxtera.utilidades.ValidarNumero;

/**
 * Esta clase unitaria valida la funcionalidad si es numero o letra
 * @author Luis Gabriel
 *
 */
public class TestNumero {

	@Test
	public void testEsNumero() {
		String cadena = "29";
		boolean esNumero = ValidarNumero.isNumeric(cadena);
		assertTrue(esNumero);
	}
	
	@Test
	public void testNoEsNumero() {
		String cadena = "suma";
		boolean esNumero = ValidarNumero.isNumeric(cadena);
		assertFalse(esNumero);
	}
	
}
