package principal;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class IdEmprestimoTest {
	
	/**
	 * Teste do metodo equals 
	 * @throws ParseException
	 */
	@Test
	public void testEqualsObject() throws ParseException {
		Usuario user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		Usuario user2 = new Usuario("Geovane", "1234", "geovane.nascimento");
		
		user1.cadastraItem("Xadrez", 59.99);
		user2.cadastraItem("Cubo mágico", 29.99);
		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date data1 = formato.parse("11/08/2017");
		java.util.Date data2 = formato.parse("08/08/2017");
		java.util.Date data3 = formato.parse("08/08/2017");
		
		IdEmprestimo id1 = new IdEmprestimo(user1, user2, user1.getItem("Xadrez"), data1);
		IdEmprestimo id2 = new IdEmprestimo(user2, user1, user2.getItem("Cubo mágico"), data2);
		IdEmprestimo id3 = new IdEmprestimo(user2, user1, user2.getItem("Cubo mágico"), data3);
		assertFalse(id1.equals(id2));
		assertTrue(id2.equals(id3));
		
	}

}
