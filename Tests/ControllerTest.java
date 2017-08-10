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

	Controller controller;

	/**
	 * Inicailiza controller e faz cadastros basicos para uso nos testes.
	 */
	@Before
	public void criaController() {
		controller = new Controller();
		controller.cadastraUsuario("Cássio", "123", "cassio.cordeiro");
		controller.cadastraUsuario("Geovane", "1234", "geovane.silva");
		controller.cadastraUsuario("Hemillainy", "12345", "hemillainy.santos");

		controller.cadastrarEletronico("Cássio", "123", "Guitar Hero", 99.99, "X-Box");
		controller.cadastrarJogoTabuleiro("Hemillainy", "12345", "Xadrez", 89.63);
		controller.cadastrarBluRaySerie("Geovane", "1234", "Naruto", 45.00, "Shippuden", 20, "QUATORZE_ANOS", "Anime",
				6);
		controller.cadastrarBluRayFilme("Geovane", "1234", "Flashpoint", 14.50, 180, "Ação", "LIVRE", 2018);
		controller.cadastrarBluRayShow("Cássio", "123", "Galinha pintadinha", 2.99, 90, 20, "Galinha", "LIVRE");
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
	 * Tetsa se a saida do metodo getInfoUsuario esta retornando o email
	 * correto.
	 */
	@Test
	public void testGetInfoUsuario() {
		assertEquals("geovane.silva", controller.getInfoUsuario("Geovane", "1234", "Email"));
	}

	/**
	 * Teste com excecao do metodo getInfoUsuario. Espera-se uma excecao ao
	 * tentar pegar informacao de um usuario nao cadastrado.
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
	 * Teste com excecao do metodo alteraUsuario. Espera-se uma excecao ao
	 * tentar alterar um usuario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioInvalido() {
		controller.atualizaUsuario("Sasuke", "171", "Telefone", "321");
	}

	/**
	 * Apos adicionar uma peca perdida verifica-se se o estado do enum que
	 * representa um jogo completo foi alterado.
	 */
	@Test
	public void testAdicionaPecaPerdida() {
		controller.adicionarPecaPerdida("Hemillainy", "12345", "Xadrez", "Torre");
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 89.63, Nao emprestado, COM PECAS PERDIDAS",
				controller.pesquisaDetalhesItem("Hemillainy", "12345", "Xadrez"));
	}

	/**
	 * Teste com excecao do metodo adicionaPecaPerdida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionarPecaPerdidaUsuarioInvalido() {
		controller.adicionarPecaPerdida("Hemillainy", "1234", "Xadrez", "Rainha");
		controller.adicionarPecaPerdida("Hemillaini", "12345", "Xadrez", "Peão");
	}

	@Test
	public void testCadastrarEletronico() {
		controller.cadastrarEletronico("Cássio", "123", "Point blank", 29.90, "X-Box");
		assertEquals("JOGO ELETRONICO: Point blank, R$ 29.9, Nao emprestado, X-Box",
				controller.pesquisaDetalhesItem("Cássio", "123", "Point blank"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoNomeItemInvalido() {
		controller.cadastrarEletronico("Geovane", "1234", null, 23.97, "X-Box");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoPlataformaInvalida() {
		controller.cadastrarEletronico("Geovane", "1234", "Clash Royale", 0, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoNomeUsuarioInvalido() {
		controller.cadastrarEletronico(null, "1234", "Clash Royale", 0, "Celular");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoTelefoneUsuarioInvalido() {
		controller.cadastrarEletronico("Geovane", null, "Clash Royale", 0, "Celular");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoNomeUsuarioVazio() {
		controller.cadastrarEletronico("", "1234", "Clash Royale", 23.97, "X-Box");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoTelefoneVazio() {
		controller.cadastrarEletronico("Geovane", "", "Clash Royale", 23.97, "X-Box");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoPlataformaVazia() {
		controller.cadastrarEletronico("Geovane", "1234", "Clash Royale", 23.97, "");
	}

	@Test
	public void testCadastrarJogoTabuleiro() {
		controller.cadastrarJogoTabuleiro("Cássio", "123", "Jogo da vida", 29);
		assertEquals("JOGO DE TABULEIRO: Jogo da vida, R$ 29.0, Nao emprestado, COMPLETO",
				controller.pesquisaDetalhesItem("Cássio", "123", "Jogo da vida"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroInvalido() {
		controller.cadastrarJogoTabuleiro("Hemillainy", "12345", "", 23);
		controller.cadastrarJogoTabuleiro("Hemillainy", "", "Banco imobiliário", 29);
		controller.cadastrarJogoTabuleiro("", "12345", "Banco imobiliário", 29);
		controller.cadastrarJogoTabuleiro("   ", "12345", "Banco imobiliário", 29);
		controller.cadastrarJogoTabuleiro("Hemillainy", "   ", "Banco imobiliário", 29);
		controller.cadastrarJogoTabuleiro("Hemillainy", "12345", "   ", 29);
		controller.cadastrarJogoTabuleiro(null, "", "Banco imobiliário", 29);
		controller.cadastrarJogoTabuleiro("Hemillainy", null, "Banco imobiliário", 29);
		controller.cadastrarJogoTabuleiro("Hemillainy", "12345", null, 29);
	}

	@Test
	public void testCadastrarBluRayFilme() {
		controller.cadastrarBluRayFilme("Geovane", "1234", "Cyborg", 20, 180, "Ação", "LIVRE", 2018);
		assertEquals("FILME: Cyborg, R$ 20.0, Nao emprestado, 180 min, LIVRE, Ação, 2018",
				controller.pesquisaDetalhesItem("Geovane", "1234", "Cyborg"));
	}

	@Test(expected = NullPointerException.class)
	public void testCadastrarBluRayFilmeInvalido() {
		controller.cadastrarBluRayFilme("Barry", "978", "De volta ao futuro", 999, 100000, "Comédia", "CEM_ANOS", 3027);
	}

	@Test
	public void testCadastrarBluRayShow() {
		controller.cadastrarBluRayShow("Hemillainy", "12345", "Carrossel", 0, 60, 5, "Carrossel", "LIVRE");
		assertEquals("SHOW: Carrossel, R$ 0.0, Nao emprestado, 60 min, LIVRE, Carrossel, 5 faixas",
				controller.pesquisaDetalhesItem("Hemillainy", "12345", "Carrossel"));
	}

	@Test(expected = NullPointerException.class)
	public void testCadastrarBluRayShowInvalido() {
		controller.cadastrarBluRayShow("Barry", "978", "De volta ao futuro", 999, 100000, 88, "DC", "CEM_ANOS");
	}

	@Test
	public void testCadastrarBluRaySerie() {
		controller.cadastrarBluRaySerie("Cássio", "123", "Arrow", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS", "Ação",
				1);
		assertEquals("SERIE: Arrow, R$ 19.9, Nao emprestado, 40 min, QUATORZE_ANOS, Ação, Temporada 1",
				controller.pesquisaDetalhesItem("Cássio", "123", "Arrow"));
	}

	@Test(expected = NullPointerException.class)
	public void testCadastrarBluRaySerieInvalido() {
		controller.cadastrarBluRaySerie("cassio", "123", "Arrow", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS", "Ação",
				1);
	}

	@Test
	public void testPesquisaDetalhesItem() {
		controller.cadastrarBluRaySerie("Cássio", "123", "The Flash", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS",
				"Ação", 1);
		assertEquals("SERIE: The Flash, R$ 19.9, Nao emprestado, 40 min, QUATORZE_ANOS, Ação, Temporada 1",
				controller.pesquisaDetalhesItem("Cássio", "123", "The Flash"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItemInvalido() {
		controller.pesquisaDetalhesItem("Cássio", "123", "The Flash");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItemUsuarioInvalido() {
		controller.cadastrarBluRaySerie("Cássio", "123", "The 100", 19.9, "Muita morte", 40, "LIVRE", "Aventura", 5);
		controller.pesquisaDetalhesItem("cassio", "123", "The 100");
	}

	@Test
	public void testGetInfoItem() {
		controller.cadastrarBluRaySerie("Cássio", "123", "The 100", 19.9, "Muita morte", 40, "LIVRE", "Aventura", 5);
		assertEquals("The 100", controller.getInfoItem("Cássio", "123", "The 100", "Nome"));
		assertEquals("19.9", controller.getInfoItem("Cássio", "123", "The 100", "Preco"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoItemInvalido() {
		controller.getInfoItem("Cássio", "123", "Lanterna verde", "Nome");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveItem() {
		controller.cadastrarBluRayFilme("Geovane", "1234", "Mulher Maravilha", 19.0, 130, "Ação", "LIVRE", 2017);
		controller.removerItem("Geovane", "1234", "Mulher Maravilha");
		controller.pesquisaDetalhesItem("Geovane", "1234", "Mulher Maravilha");
		controller.removerItem("Diana", "7", "Laço");
	}

	@Test
	public void testAtualizaItem() {
		controller.cadastrarBluRayFilme("Geovane", "1234", "Mulher Maravilha", 19.0, 130, "Ação", "LIVRE", 2017);
		controller.atualizarItem("Geovane", "1234", "Mulher Maravilha", "Nome", "Super Mulher Maravilha");
		assertEquals("Super Mulher Maravilha",
				controller.getInfoItem("Geovane", "1234", "Super Mulher Maravilha", "Nome"));
		controller.cadastrarBluRaySerie("Cássio", "123", "The 100", 19.9, "Muita morte", 40, "LIVRE", "Aventura", 5);
		controller.atualizarItem("Cássio", "123", "The 100", "Preco", "29.9");
		assertEquals("29.9", controller.getInfoItem("Cássio", "123", "The 100", "Preco"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaItemInvalido() {
		controller.atualizarItem("Felicity", "90", "Black Mirror", "Nome", "Blacklist");
	}

	@Test
	public void testListarItensOrdenadosPorNome() {
		assertEquals(
				"FILME: Flashpoint, R$ 14.5, Nao emprestado, 180 min, LIVRE, Ação, 2018|SHOW: Galinha pintadinha, R$ 2.99, Nao emprestado, 90 min, LIVRE, Galinha, 20 faixas|JOGO ELETRONICO: Guitar Hero, R$ 99.99, Nao emprestado, X-Box|SERIE: Naruto, R$ 45.0, Nao emprestado, 20 min, QUATORZE_ANOS, Anime, Temporada 6|JOGO DE TABULEIRO: Xadrez, R$ 89.63, Nao emprestado, COMPLETO|",
				controller.listarItensOrdenadosPorNome());
	}

	@Test
	public void testListarItensOrdenadosPorValor() {
		assertEquals(
				"SHOW: Galinha pintadinha, R$ 2.99, Nao emprestado, 90 min, LIVRE, Galinha, 20 faixas|FILME: Flashpoint, R$ 14.5, Nao emprestado, 180 min, LIVRE, Ação, 2018|SERIE: Naruto, R$ 45.0, Nao emprestado, 20 min, QUATORZE_ANOS, Anime, Temporada 6|JOGO DE TABULEIRO: Xadrez, R$ 89.63, Nao emprestado, COMPLETO|JOGO ELETRONICO: Guitar Hero, R$ 99.99, Nao emprestado, X-Box|",
				controller.listarItensOrdenadosPorValor());
	}
}
