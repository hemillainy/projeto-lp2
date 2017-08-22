package principal.item;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import principal.item.blurays.Serie;

/**
 * Testes da classe Serie.
 * 
 * Projeto de Laboratorio de ProgamACAO 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class SerieTest {

	Serie serie;

	/**
	 * Instancia uma serie para ser utilizada no teste.
	 */
	@Before
	public void criaSerie() {
		serie = new Serie("Arrow", 35.63, 43, "DOZE_ANOS", "ACAO", 5);
	}

	/**
	 * Testa o toString de Serie.
	 */
	@Test
	public void testToString() {
		assertEquals("SERIE: Arrow, R$ 35.63, Nao emprestado, 43 min, DOZE_ANOS, ACAO, Temporada 5", serie.toString());
	}
}
