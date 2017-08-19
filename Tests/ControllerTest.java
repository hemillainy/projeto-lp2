import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import principal.*;

/**
 * Testes de unidade da classe Controller
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ControllerTest {

	UserController controller;

	/**
	 * Inicailiza controller e faz cadastros basicos para uso nos testes.
	 */
	@Before
	public void criaController() {
		controller = new UserController();
		controller.cadastraUsuario("Cássio", "123", "cassio.cordeiro");
		controller.cadastraUsuario("Geovane", "1234", "geovane.silva");
		controller.cadastraUsuario("Hemillainy", "12345", "hemillainy.santos");

		// controller.cadastrarEletronico("Cássio", "123", "Guitar Hero", 99.99,
		// "XBOX360");
		// controller.cadastrarJogoTabuleiro("Hemillainy", "12345", "Xadrez", 89.63);
		// controller.cadastrarBluRaySerie("Geovane", "1234", "Naruto", 45.00,
		// "Shippuden", 20, "QUATORZE_ANOS", "OUTRO",
		// 6);
		// controller.cadastrarBluRayFilme("Geovane", "1234", "Flashpoint", 14.50, 180,
		// "ACAO", "LIVRE", 2018);
		// controller.cadastrarBluRayShow("Cássio", "123", "Galinha pintadinha", 2.99,
		// 90, 20, "Galinha", "LIVRE");
	}

	/**
	 * Teste com excecao do metodo removeUsuario. Apos a remocao de um usuario
	 * cadastrado e esperado uma excecao ao se tentar verificar dados do mesmo
	 * usuario.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveUsuario() {
		controller.removeUsuario("Hemillainy", "12345");
		controller.getInfoUsuario("Hemillainy", "12345", "Nome");
	}

	/**
	 * Tetsa se a saida do metodo getInfoUsuario esta retornando o email correto.
	 */
	@Test
	public void testGetInfoUsuario() {
		assertEquals("geovane.silva", controller.getInfoUsuario("Geovane", "1234", "Email"));
	}

	/**
	 * Teste com excecao do metodo getInfoUsuario. Espera-se uma excecao ao tentar
	 * pegar informacao de um usuario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioInvalido() {
		controller.getInfoUsuario("Sasuke", "21", "Nome");
	}

	/**
	 * Atualiza o email de um usuario e depois verifica se o email realmente foi
	 * alterado.
	 */
	@Test
	public void testAtualizaUsuario() {
		controller.atualizaUsuario("Hemillainy", "12345", "Email", "hemi.suelen");
		assertEquals("hemi.suelen", controller.getInfoUsuario("Hemillainy", "12345", "Email"));
	}

	/**
	 * Teste com excecao do metodo alteraUsuario. Espera-se uma excecao ao tentar
	 * alterar um usuario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioInvalido() {
		controller.atualizaUsuario("Sasuke", "171", "Telefone", "321");
	}
}
