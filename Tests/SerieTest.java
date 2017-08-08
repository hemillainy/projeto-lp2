import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.blurays.Serie;

public class SerieTest {

	Serie serie;

	@Before
	public void criaSerie() {
		serie = new Serie("Arrow", 35.63, 43, "DOZE_ANOS", "Acao", 5);
	}

	@Test
	public void testToString() {
		assertEquals("SERIE: Arrow, R$ 35.63, Nao emprestado, 43 min, DOZE_ANOS, Acao, Temporada 5", serie.toString());
	}
}
