package principal.comparator;


import static org.junit.Assert.*;

import org.junit.Test;

import principal.comparator.ComparadorValor;
import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;

/**
 * 
 * Classe de testes da classe ComparadorValor.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ComparadorValorTest {

	@Test
	public void testCompare() {
		Item i1 = new JogoTabuleiro("Damas", 12.54);
		Item i2 = new JogoTabuleiro("Banco Imobiliário", 45.76);
		Item i3 = new JogoTabuleiro("Xadrez", 45.76);
		ComparadorValor cv = new ComparadorValor();
		assertTrue(cv.compare(i1, i2) < 0);
		assertTrue(cv.compare(i2, i3) == 0);
	}

}
