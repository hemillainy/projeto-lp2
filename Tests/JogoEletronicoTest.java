import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.jogos.JogoEletronico;

/**
 * Testes da classe JogoEletronico. 
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 * 
 */
public class JogoEletronicoTest {

	JogoEletronico jogo;

	/**
	 * Inicializa um jogoEletronico para os testes.
	 */
	@Before
	public void criaJogoEletronico() {
		jogo = new JogoEletronico("GTA", 99.80, "X-Box");
	}

	/**
	 * Testa se a saida de toString de jogoEletronico esta conforme o esperado.
	 */
	@Test
	public void testToString() {
		assertEquals("JOGO ELETRONICO: GTA, R$ 99.8, Nao emprestado, X-Box", jogo.toString());
	}

	/**
	 * Testa o metodo equals de jogoEletronico. Verifica se funciona para dois
	 * jogos iguais e tambem para dois jogos diferentes.
	 */
	@Test
	public void testEquals() {
		JogoEletronico jogo2 = new JogoEletronico("GTA", 50.99, "X-Box");
		assertTrue(jogo.equals(jogo2));
		JogoEletronico jogo3 = new JogoEletronico("Mario", 0.00, "X-Box");
		assertFalse(jogo.equals(jogo3));
	}
}
