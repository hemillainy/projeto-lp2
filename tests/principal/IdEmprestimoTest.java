package principal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import principal.emprestimo.IdEmprestimo;
import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;
/**
 * Testes da classe IdEmprestimo.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class IdEmprestimoTest {
	
	LocalDate data1;
	LocalDate data2;
	LocalDate data3;
	
	@Before
	public void inicializa() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		data1 = LocalDate.parse("11/08/2017", formato);
		data2 = LocalDate.parse("08/08/2017", formato);
		data3 = LocalDate.parse("08/08/2017", formato);
	}
	
	/**
	 * Teste do metodo equals.
	 * 
	 */
	@Test
	public void testEqualsObject() {
		Usuario user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		Usuario user2 = new Usuario("Geovane", "1234", "geovane.nascimento");
		Item i1 = new JogoTabuleiro("Xadrez", 59.99);
		Item i2 = new JogoTabuleiro("Cubo mágico", 29.99);
		user1.cadastraItem(i1);
		user2.cadastraItem(i2);
		
		
		
		IdEmprestimo id1 = new IdEmprestimo(user1, user2, user1.getItem("Xadrez"), data1);
		IdEmprestimo id2 = new IdEmprestimo(user2, user1, user2.getItem("Cubo mágico"), data2);
		IdEmprestimo id3 = new IdEmprestimo(user2, user1, user2.getItem("Cubo mágico"), data3);
		assertFalse(id1.equals(id2));
		assertTrue(id2.equals(id3));
		
	}

}
