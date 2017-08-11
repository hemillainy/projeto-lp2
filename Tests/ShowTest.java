import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import principal.item.blurays.Show;

/**
 * Testes para a classe Show.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class ShowTest {

	Show show;

	/**
	 * Instancia um show para ser utilizado no teste.
	 */
	@Before
	public void criaShow() {
		show = new Show("Lana Del Rey planeta Terra", 100, 120, "LIVRE", "Lana Del Rey", 10);
	}

	/**
	 * Testa o toString de Show.
	 */
	@Test
	public void testToString() {
		assertEquals(
				"SHOW: Lana Del Rey planeta Terra, R$ 100.0, Nao emprestado, 120 min, LIVRE, Lana Del Rey, 10 faixas",
				show.toString());
	}

}
