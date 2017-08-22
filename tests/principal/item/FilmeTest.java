package principal.item;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import principal.item.blurays.Filme;

/**
 * 
 * Testes de unidade da classe Filme
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 */
public class FilmeTest {
	
	Filme filme;
	
	/**
	 * Inicializa um filme para os testes. 
	 */
	@Before
	public void criaFilme() {
		filme = new Filme("Guardioes da Galaxia", 12, 120, "DOZE_ANOS", "ACAO", 2017);
	}
	
	/**
	 * Testa se a saida de toString de filme esta conforme o esperado. 
	 */
	@Test
	public void testToString() {
		assertEquals("FILME: Guardioes da Galaxia, R$ 12.0, Nao emprestado, 120 min, DOZE_ANOS, ACAO, 2017", filme.toString());
	}
}
