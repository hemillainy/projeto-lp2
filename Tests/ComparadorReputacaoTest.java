


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import principal.comparator.ComparadorReputacao;
import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

/**
 * 
 * Classe de testes da classe ComparadorReputacao.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ComparadorReputacaoTest {

	/**
	 * Teste do metodo compare.
	 */
	@Test
	public void testCompare() {
		Usuario user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		Usuario user2 = new Usuario("Hemillainy", "321", "hemillainy.santos");
		Usuario user3 = new Usuario("Geovane", "159", "geovane.nascimento");
		Usuario user4 = new Usuario("Patricia", "105", "patricia.g");
		Item item = new JogoTabuleiro("Banco Imobiliário", 45.76);
		user2.cadastraItem(item);
		ComparadorReputacao cr = new ComparadorReputacao();
		assertTrue(cr.compare(user1, user2) > 0);
		assertTrue(cr.compare(user4, user3) == 0);
	}

}
