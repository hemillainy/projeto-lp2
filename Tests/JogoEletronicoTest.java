import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.jogos.JogoEletronico;

public class JogoEletronicoTest {

	JogoEletronico jogo;

	@Before
	public void criaJogoEletronico() {
		jogo = new JogoEletronico("GTA", 99.80, "X-Box");
	}

	@Test
	public void testToString() {
		assertEquals("JOGO ELETRONICO: GTA, R$ 99.8, Nao emprestado, X-Box", jogo.toString());
	}

	@Test
	public void testEquals() {
		JogoEletronico jogo2 = new JogoEletronico("GTA", 50.99, "X-Box");
		assertTrue(jogo.equals(jogo2));
		JogoEletronico jogo3 = new JogoEletronico("Mario", 0.00, "X-Box");
		assertFalse(jogo.equals(jogo3));
	}
}
