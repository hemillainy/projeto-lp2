package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import principal.user.reputacao.CartaoFidelidade;

/**
 * Testes da classe CartaoFidelidade.
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class CartaoFidelidadeTest {

	CartaoFidelidade cf;

	/**
	 * Inicializa um cartaoFidelidade.
	 */
	@Before
	public void inicializa() {
		cf = new CartaoFidelidade();
	}

	/**
	 * Testa o getFidelidade a medida que a fidelidade vai sendo alterada.
	 */
	@Test
	public void testGetFidelidade() {
		assertEquals("FreeRyder", cf.getFidelidade());
		cf.setReputacao(-2);
		assertEquals("Caloteiro", cf.getFidelidade());
		cf.addItem();
		cf.setReputacao(10);
		assertEquals("Noob", cf.getFidelidade());
		cf.setReputacao(100);
		assertEquals("BomAmigo", cf.getFidelidade());
	}

	/**
	 * Testa o set reputacao e depois faz-se a verificacao da reputavao com o
	 * auxilio do getReputacao.
	 */
	@Test
	public void testSetReputacao() {
		cf.setReputacao(100);
		assertEquals(100, cf.getReputacao(), 0.01);
		cf.setReputacao(-102);
		assertEquals(-2, cf.getReputacao(), 0.01);
	}

	/**
	 * Testa o metodo de getReputacao. Inicialmente por nao haver nenhuma
	 * reputacao esse valor sera zero no cartao fidelidade.
	 */
	@Test
	public void testGetReputacao() {
		assertEquals(0, cf.getReputacao(), 0.01);
	}

	/**
	 * Testa o metodo podePegarEmprestado para uma fidelidade de tipo FreeRyder.
	 */
	@Test
	public void testPodePegarEmprestadoFreeRyder() {
		assertTrue(cf.podePegarEmprestado());
	}

	/**
	 * Testa o metodo podePegarEmprestado para uma fidelidade de tipo Noob.
	 */
	@Test
	public void testPodePegarEmprestadoNoob() {
		cf.addItem();
		cf.setReputacao(10);
		assertTrue(cf.podePegarEmprestado());
	}

	/**
	 * Testa o metodo podePegarEmprestado para uma fidelidade de tipo Caloteiro.
	 */
	@Test
	public void testPodePegarEmprestadoCaloteiro() {
		cf.setReputacao(-2);
		assertFalse(cf.podePegarEmprestado());
	}

	/**
	 * Testa o metodo podePegarEmprestado para uma fidelidade de tipo BomAmigo.
	 */
	@Test
	public void testPodePegarEmprestadoBomAmigo() {
		cf.setReputacao(100);
		assertTrue(cf.podePegarEmprestado());
	}

	/**
	 * Testa o metodo getPeriodo para uma fidelidade de tipo FreeRyder.
	 */
	@Test
	public void testGetPeriodoFreeRyder() {
		assertEquals(5, cf.getPeriodo());
	}

	/**
	 * Testa o metodo getPeriodo para uma fidelidade de tipo Noob.
	 */
	@Test
	public void testGetPeriodoNoob() {
		cf.addItem();
		cf.setReputacao(10);
		assertTrue(cf.podePegarEmprestado());
		assertEquals(7, cf.getPeriodo());
	}

	/**
	 * Testa o metodo getPeriodo para uma fidelidade de tipo Caloteiro.
	 */
	@Test
	public void testGetPeriodoCaloteiro() {
		cf.setReputacao(-2);
		assertEquals(0, cf.getPeriodo());
	}

	/**
	 * Testa o metodo getPeriodo para uma fidelidade de tipo BomAmigo.
	 */
	@Test
	public void testGetPeriodoBomAmigo() {
		cf.setReputacao(110);
		assertEquals(14, cf.getPeriodo());
	}

}
