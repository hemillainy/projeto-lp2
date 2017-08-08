import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import itens.jogos.JogoTabuleiro;

public class JogoTabuleiroTest {
	
	JogoTabuleiro jogo;
	
	@Before
	public void criaJogoTabuleiro () {
		jogo = new JogoTabuleiro("Xadrez", 199);
	}
	
	@Test
	public void testtoString() {
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 199.0, Nao emprestado, COMPLETO", jogo.toString());
	}
	
	@Test
	public void testAdicionaPecaPerdida() {
		jogo.adicionaPecaPerdida("Peão");
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 199.0, Nao emprestado, COM PECAS PERDIDAS", jogo.toString());
	}
	
	@Test
	public void testEquals() {
		JogoTabuleiro jogo2 = new JogoTabuleiro("Damas", 50);
		assertFalse(jogo.equals(jogo2));
		JogoTabuleiro jogo3 = new JogoTabuleiro("Xadrez", 250);
		assertTrue(jogo.equals(jogo3));
		jogo.adicionaPecaPerdida("Bispo");
		jogo.adicionaPecaPerdida("Peão");
		jogo3.adicionaPecaPerdida("Rainha");
		assertFalse(jogo.equals(jogo3));
	}

}
