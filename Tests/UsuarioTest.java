import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import principal.*;

public class UsuarioTest {

	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;

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

	@Test
	public void testGetEmail() {
		assertEquals("cassio.cordeiro", usuario1.getEmail());
	}

	@Test
	public void testGetNome() {
		assertEquals("Geovane", usuario2.getNome());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("12345678", usuario3.getTelefone());
	}

	@Test
	public void testSetEmail() {
		usuario1.setEmail("cassio.eduardo");
		assertEquals("cassio.eduardo", usuario1.getEmail());
	}

	@Test
	public void testSetTelefone() {
		usuario2.setTelefone("147");
		assertEquals("147", usuario2.getTelefone());
	}

	@Test
	public void testToString() {
		assertEquals("Hemillainy, hemillainy.santos, 12345678", usuario3.toString());
	}

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

	@Test
	public void testGetPrecoItem() {
		assertEquals("10.0", usuario3.getPrecoItem("Tetris"));
	}

	@Test
	public void testGetNomeItem() {
		assertEquals("The 100", usuario1.getNomeItem("The 100"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetPrecoItemInvalido() {
		usuario2.getPrecoItem("Naruto");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetNomeItemInvalido() {
		usuario3.getNomeItem("Box GOT");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoverItem() {
		usuario1.removerItem("Damas");
		usuario1.getNomeItem("Damas");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoverItemInvalido() {
		usuario3.getNomeItem("Box GOT");
	}

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
