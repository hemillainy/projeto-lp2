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
	public void testGetItem() {
		assertEquals(59.99, usuario1.getItem("The 100").getPreco(), 0.01);
	}
	
	@Test
	public void testExibeDetalhesItem() {
		assertEquals("FILME: Liga da Justiça, R$ 14.0, Nao emprestado, 180 min, DEZESSEIS_ANOS, AÇÃO, 2017", usuario2.exibeDetalhesItem("Liga da Justiça"));
	}
	
	@Test
	public void testGetPreco() {
		assertEquals("10.00", usuario2.getPrecoItem("Tetris"));
	}
	
	
}
