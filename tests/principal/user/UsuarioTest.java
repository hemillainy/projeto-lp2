package principal.user;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import principal.emprestimo.Emprestimo;
import principal.item.Item;
import principal.item.blurays.Filme;
import principal.item.blurays.Serie;
import principal.item.blurays.Show;
import principal.item.jogos.JogoEletronico;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

/**
 * Testes da classe Usuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 * 
 */
public class UsuarioTest {

	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;

	Item i1;
	Item i2;
	Item i3;
	Item i4;
	Item i5;

	/**
	 * Inicializaco de 3 usuarios basicos para auxilio nos testes. Alguns itens
	 * tambem sao cadastrados.
	 */
	@Before
	public void CriaUsuario() {
		usuario1 = new Usuario("Cássio", "123456", "cassio.cordeiro");
		usuario2 = new Usuario("Geovane", "1234567", "geovane.silva");
		usuario3 = new Usuario("Hemillainy", "12345678", "hemillainy.santos");

		i1 = new JogoTabuleiro("Damas", 1.99);
		i2 = new Filme("Liga da Justiça", 14.00, 180, "DEZESSEIS_ANOS", "ACAO", 2017);
		i3 = new JogoEletronico("Tetris", 10.00, "OUTRO");
		i4 = new Show("Mares", 500, 120, "QUATORZE_ANOS", "Bruno Mars", 11);
		i5 = new Serie("The 100", 59.99, 43, "DEZESSEIS_ANOS", "DRAMA", 1);

		usuario1.cadastraItem(i1);
		usuario2.cadastraItem(i2);
		usuario3.cadastraItem(i3);
		usuario1.cadastraItem(i4);
		usuario2.cadastraItem(i5);
	}

	/**
	 * Testa se a saida do getEmail esta conforme o esperado.
	 */
	@Test
	public void testGetEmail() {
		assertEquals("cassio.cordeiro", usuario1.getEmail());
	}

	/**
	 * Testa se a saida do getNome esta conforme o esperado.
	 */
	@Test
	public void testGetNome() {
		assertEquals("Geovane", usuario2.getNome());
	}

	/**
	 * Testa se a saida do getTelefone esta conforme o esperado.
	 */
	@Test
	public void testGetTelefone() {
		assertEquals("12345678", usuario3.getTelefone());
	}

	/**
	 * Testa o metodo setEmail. Primeiro o metodo e invocado e depois com
	 * auxilio de getEmail eh verificado se o email realmente foi alterado.
	 */
	@Test
	public void testSetEmail() {
		usuario1.setEmail("cassio.eduardo");
		assertEquals("cassio.eduardo", usuario1.getEmail());
	}

	/**
	 * Testa o metodo setTelefone. Primeiro o metodo e invocado e depois com
	 * auxilio de getTelefone eh verificado se o telefone realmente foi
	 * alterado.
	 */
	@Test
	public void testSetTelefone() {
		usuario2.setTelefone("147");
		assertEquals("147", usuario2.getTelefone());
	}

	/**
	 * Testa se a saida do toString para o usuario3 esta conforme o esperado.
	 */
	@Test
	public void testToString() {
		assertEquals("Hemillainy, hemillainy.santos, 12345678", usuario3.toString());
	}

	/**
	 * Testa o equals verificando se dois usuarios realmente sao iguais ou nao.
	 */
	@Test
	public void testEquals() {
		Usuario usuario4 = new Usuario("Geovane", "1234567", "geovane.silva");
		assertTrue(usuario2.equals(usuario4));
		assertFalse(usuario3.equals(usuario4));
	}

	/**
	 * Testa o metodo getItem para um item cadastrado no usuario2.
	 */
	@Test
	public void testGetItem() {
		assertEquals(14.0, usuario2.getItem("Liga da Justiça").getPreco(), 0.01);
	}

	/**
	 * Testa o metodo getReputacao.
	 */
	@Test
	public void testGetReputacao() {
		assertEquals(25.09, usuario1.getReputacao(), 0.01);
	}

	/**
	 * Testa o metodo removeItem().
	 */
	@Test
	public void testRemoveItem() {
		usuario1.removerItem("Damas");
		assertEquals(null, usuario1.getItem("Damas"));
	}

	/**
	 * Testa o metodo adicionarPecaPerdida().
	 */
	@Test
	public void adicionarPecaPerdida() {
		usuario1.adicionarPecaPerdida("Damas", "preta");
		assertEquals("JOGO DE TABULEIRO: Damas, R$ 1.99, Nao emprestado, COM PECAS PERDIDAS",
				usuario1.getItem("Damas").toString());
	}

	/**
	 * Testa o metodo hasItem().
	 */
	@Test
	public void testHasItem() {
		assertEquals(true, usuario1.hasItem("Damas"));
		assertEquals(false, usuario2.hasItem("Damas"));
	}

	/**
	 * Testa os metodos addEmprestimo() e getEmprestimo().
	 */
	@Test
	public void testGetEmprestimo() {
		String data = "22/06/2017";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		usuario1.addEmprestimo(new Emprestimo(usuario1, usuario2, i1, LocalDate.parse(data, dtf), 7));
		assertEquals(1, usuario1.getEmprestimos().size());
	}

	/**
	 * Testa o metodo podePegarEmprestado().
	 */
	@Test
	public void testPodePegarEmprestado() {
		assertEquals(true, usuario1.podePegarEmprestado());
	}

	/**
	 * Testa o metodo getPeriodo().
	 */
	@Test
	public void testGetPeriodo() {
		assertEquals(7, usuario1.getPeriodo());
	}

	/**
	 * Testa o compareTo().
	 */
	@Test
	public void testCompareTo() {
		assertEquals(-4, usuario1.compareTo(usuario2));
	}
}
