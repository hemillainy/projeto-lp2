import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import itens.jogos.JogoTabuleiro;

/**
 * Testes da classe JogoTabuleiro.
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class JogoTabuleiroTest {

	JogoTabuleiro jogo;

	/**
	 * Inicailiza um jogo de tabuleiro que sera usado pelos testes.
	 */
	@Before
	public void criaJogoTabuleiro() {
		jogo = new JogoTabuleiro("Xadrez", 199);
	}

	/**
	 * Testa se a saida de toString de jogoTabuleiro esta conforme o esperado.
	 */
	@Test
	public void testtoString() {
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 199.0, Nao emprestado, COMPLETO", jogo.toString());
	}

	/**
	 * Testa o adicionaPecaPerdida. Primeiro uma peca eh adicionada e depois faz-se
	 * a verificacao com auxilio do toString.
	 */
	@Test
	public void testAdicionaPecaPerdida() {
		jogo.adicionaPecaPerdida("Peão");
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 199.0, Nao emprestado, COM PECAS PERDIDAS", jogo.toString());
	}

	/**
	 * Testa o metodo equals de jogoTabuleiro. Verifica se funciona para dois
	 * jogos iguais e tambem para dois jogos diferentes.
	 */
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
