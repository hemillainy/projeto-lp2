import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import principal.*;

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

	/**
	 * Inicializaco de 3 usuarios basicos para auxilio nos testes. Alguns itens
	 * tambem sao cadastrados.
	 */
	@Before
	public void CriaUsuario() {
		usuario1 = new Usuario("Cássio", "123456", "cassio.cordeiro");
		usuario2 = new Usuario("Geovane", "1234567", "geovane.silva");
		usuario3 = new Usuario("Hemillainy", "12345678", "hemillainy.santos");

		usuario1.cadastraItem("Damas", 1.99);
		usuario2.cadastraItem("Liga da Justiça", 14.00, 180, "AÇÃO", "DEZESSEIS_ANOS", 2017);
		usuario3.cadastraItem("Tetris", 10.00, "Mini Game");
		usuario1.cadastraItem("The 100", 59.99, "Octavia linda", 43, "DEZESSEIS_ANOS", "Drama", 1);
		usuario2.cadastraBluRayShow("Mares", 500, 120, "QUATORZE_ANOS", "Bruno Mars", 11);
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
	 * Testa o metodo que exibe detalhes de um item para um item cadastrado no
	 * usuario 2.
	 */
	@Test
	public void testExibeDetalhesItem() {
		assertEquals("FILME: Liga da Justiça, R$ 14.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, AÇÃO, 2017",
				usuario2.exibeDetalhesItem("Liga da Justiça"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testExibeDetalhesItemInvallido() {
		usuario3.exibeDetalhesItem(null);
		usuario2.exibeDetalhesItem("");
		usuario1.exibeDetalhesItem("   ");
		usuario3.exibeDetalhesItem("Cubo mágico");
	}

	/**
	 * Testa o metodo getPrecoItem em um item cadastrado no usuario3.
	 */
	@Test
	public void testGetPrecoItem() {
		assertEquals("10.0", usuario3.getPrecoItem("Tetris"));
	}

	/**
	 * Testa o metodo getNomeItem em um item cadastrado no usuario1.
	 */
	@Test
	public void testGetNomeItem() {
		assertEquals("The 100", usuario1.getNomeItem("The 100"));
	}

	/**
	 * Testa o metodo getPrecoItem para um item nao cadastrado. Uma excecao eh
	 * esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetPrecoItemInvalido() {
		usuario2.getPrecoItem("Naruto");
	}

	/**
	 * Testa o metodo getNomeItem para um item nao cadastrado. Uma excecao eh
	 * esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetNomeItemInvalido() {
		usuario3.getNomeItem("Box GOT");
	}

	/**
	 * Testa o metodo que remove o item de um usuario. Primeiro o item eh
	 * removido do usuario1 e depois tenta-se pegar o nome do item removido. Uma
	 * excecao eh esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoverItem() {
		usuario1.removerItem("Damas");
		usuario1.getNomeItem("Damas");
	}

	/**
	 * Testa o metodo que remove o item de um usuario para um item naon
	 * cadastrado no usuario. Uma excecao eh esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoverItemInvalido() {
		usuario3.getNomeItem("Box GOT");
	}

	/**
	 * 
	 */
	@Test
	public void testAlteraNomeItem() {
		usuario2.atualizaNomeItem("Liga da Justiça", "Flashpoint");
		assertEquals("Flashpoint", usuario2.getNomeItem("Flashpoint"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAlteraNomeItemInvalido() {
		usuario1.atualizaNomeItem("Jogos Vorazes", "X-men");
		usuario1.getNomeItem("X-men");
	}

	@Test
	public void testAtualizaPrecoItem() {
		usuario3.atualizaPrecoItem("Tetris", "50.00");
		assertEquals("50.0", usuario3.getPrecoItem("Tetris"));
	}

	@Test
	public void testAdicionaPecaPerdida() {
		usuario1.adicionarPecaPerdida("Damas", "1 peça preta");
		assertEquals("JOGO DE TABULEIRO: Damas, R$ 1.99, Nao emprestado, COM PECAS PERDIDAS",
				usuario1.exibeDetalhesItem("Damas"));
	}

	@Test
	public void testEquals() {
		Usuario usuario4 = new Usuario("Geovane", "1234567", "geovane.silva");
		assertTrue(usuario2.equals(usuario4));
		assertFalse(usuario3.equals(usuario4));
	}

	@Test
	public void testGetItem() {
		assertEquals(14.0, usuario2.getItem("Liga da Justiça").getPreco(), 0.01);
	}

	@Test
	public void testGetItemInvalido() {
		assertEquals(null, usuario3.getItem("Damas"));
	}

}
