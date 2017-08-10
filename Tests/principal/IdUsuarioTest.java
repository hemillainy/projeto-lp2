package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**.
 * Teste da classe IdUsuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class IdUsuarioTest {
	
	IdUsuario id1;
	IdUsuario id2;
	IdUsuario id3;
	
	/**
	 * Cria os IdUsuarios necessario para os testes.
	 */
	@Before
	public void criaIdUsuario() {
		 id1 = new IdUsuario("Cássio", "1234");
		 id2 = new IdUsuario("Geovane", "123");
		 id3 = new IdUsuario("Cássio", "1234");
	}
	
	/**
	 * Teste do metodo toString.
	 */
	@Test
	public void testToString() {
		assertEquals("Cássio 1234", id1.toString());
	}
	
	/**
	 * Teste do metodo equals.
	 */
	@Test
	public void testEqualsObject() {
		assertFalse(id1.equals(id2));
		assertTrue(id1.equals(id3));
	}

}
