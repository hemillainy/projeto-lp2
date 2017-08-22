

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import principal.emprestimo.Emprestimo;
import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

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
	
	Item i1;
	Item i2;
	
	Emprestimo emprestimo;
	Emprestimo emprestimo2;
	Emprestimo emprestimo3;

	LocalDate data1;
	LocalDate data2;
	LocalDate data3;
	
	/**
	 * Cria os objetos necessarios para os testes
	 * @throws ParseException
	 */
	@Before
	public void criaEmprestimo() {
		user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		user2 = new Usuario("Geovane", "1234", "geovane.nascimento");
		
		i1 = new JogoTabuleiro("Xadrez", 59.99);
		user1.cadastraItem(i1);
		i2 = new JogoTabuleiro("Cubo mágico", 29.99);
		user2.cadastraItem(i2);
		
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		data1 = LocalDate.parse("11/08/2017", formato);
		data2 = LocalDate.parse("08/08/2017", formato);
		data3 = LocalDate.parse("13/08/2017", formato);
		
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
		LocalDate data = LocalDate.of(2017, 8, 16);
		emprestimo.devolverItem(data);
		assertEquals("EMPRESTIMO - De: Cássio, Para: Geovane, Xadrez, 11/08/2017, 7 dias, ENTREGA: 16/08/2017", emprestimo.toString());
	}
	
	/**
	 * Teste do metodo devolverItem.
	 */
	@Test
	public void testDevolverItem() {
		emprestimo.devolverItem(data3);
		assertEquals("EMPRESTIMO - De: Cássio, Para: Geovane, Xadrez, 11/08/2017, 7 dias, ENTREGA: 13/08/2017" , emprestimo.toString());
	}
	
	/**
	 * Teste do metodo getDono.
	 */
	@Test
	public void testGetDono() {
		assertEquals(user1, emprestimo.getDono());
	}
	
	/**
	 * Teste do metodo getNomeDono.
	 */
	@Test
	public void testGetNomeDono() {
		assertEquals("Geovane", emprestimo2.getNomeDono());
	}
	
	/**
	 * Teste do metodo getRequerente.
	 */
	@Test
	public void testGetRequerente() {
		assertEquals(user2, emprestimo.getRequerente());
	}
	
	/**
	 * Teste do metodo getItem.
	 */
	@Test
	public void testGetItem() {
		assertEquals(i1, emprestimo.getItem());
	}
	
	/**
	 * Teste do metodo getNomoItem.
	 */
	@Test
	public void testGetNomeItem() {
		assertEquals("Cubo mágico", emprestimo2.getNomeItem());
	}
}
