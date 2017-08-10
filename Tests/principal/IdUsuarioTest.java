package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IdUsuarioTest {
	
	IdUsuario id1;
	IdUsuario id2;
	
	@Before
	public void criaIdUsuario() {
		 id1 = new IdUsuario("Cássio", "1234");
		 id2 = new IdUsuario("Geovane", "123");
	}
	
	/**
	 * Teste do metodo toString
	 */
	@Test
	public void testToString() {
		assertEquals("Cássio 1234", id1.toString());
	}
	
	/**
	 * Teste do metodo equals
	 */
	@Test
	public void testEqualsObject() {
		assertFalse(id1.equals(id2));
		IdUsuario id3 = new IdUsuario("Cássio", "1234");
		assertTrue(id1.equals(id3));
	}

}
