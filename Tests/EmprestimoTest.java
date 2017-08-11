

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import principal.Emprestimo;
import principal.Usuario;

/**
 * 
 * Classe de testes da classe Emprestimo.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class EmprestimoTest {
	
	Usuario user1;
	Usuario user2;
	
	Emprestimo emprestimo;
	Emprestimo emprestimo2;
	Emprestimo emprestimo3;

	java.util.Date data1;
	java.util.Date data2;
	java.util.Date data3;
	
	/**
	 * Cria os objetos necessarios para os testes
	 * @throws ParseException
	 */
	@Before
	public void criaEmprestimo() throws ParseException  {
		user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		user2 = new Usuario("Geovane", "1234", "geovane.nascimento");
		
		user1.cadastraItem("Xadrez", 59.99);
		user2.cadastraItem("Cubo mágico", 29.99);
		
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		data1 = formato.parse("11/08/2017");
		data2 = formato.parse("08/08/2017");
		data3 = formato.parse("13/08/2017");
		
		emprestimo = new Emprestimo(user1, user2, user1.getItem("Xadrez"), data1, 7);
		emprestimo2 = new Emprestimo(user2, user1, user2.getItem("Cubo mágico"), data2, 5);
		emprestimo3 = new Emprestimo(user1, user2, user1.getItem("Xadrez"), data1, 7);
	}

	/**
	 * Teste para o metodo equals.
	 */
	@Test
	public void testEqualsObject() {
		assertFalse(emprestimo.equals(emprestimo2));
		assertTrue(emprestimo3.equals(emprestimo));
	}

	/**
	 * Teste do metodo toString.
	 */
	@Test
	public void testToString() {
		assertEquals("Cássio - Geovane - Xadrez - 7 - Fri Aug 11 00:00:00 BRT 2017", emprestimo.toString());
	}

}
