import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.blurays.Filme;

public class FilmeTest {
	
	Filme filme;
	
	@Before
	public void criaFilme() {
		filme = new Filme("Guardioes da Galaxia", 12, 120, "DOZE_ANOS", "Acao", 2017);
	}
	
	@Test
	public void testToString() {
		assertEquals("FILME: Guardioes da Galaxia, R$ 12.0, Nao emprestado, 120 min, DOZE_ANOS, Acao, 2017", filme.toString());
	}
}
