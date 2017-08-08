import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import itens.blurays.Show;

public class ShowTest {

	Show show;

	@Before
	public void criaShow() {
		show = new Show("Lana Del Rey planeta Terra", 100, 120, "LIVRE", "Lana Del Rey", 10);
	}

	@Test
	public void testToString() {
		assertEquals(
				"SHOW: Lana Del Rey planeta Terra, R$ 100.0, Nao emprestado, 120 min, LIVRE, Lana Del Rey, 10 faixas",
				show.toString());
	}

}
