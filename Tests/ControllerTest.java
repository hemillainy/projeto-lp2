import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import principal.*;

public class ControllerTest {
	
	Controller ctrl;

	@Before
	public void criaController (){
		ctrl = new Controller();
		ctrl.cadastraUsuario("Cássio", "123", "cassio.cordeiro");
		ctrl.cadastraUsuario("Geovane", "1234", "geovane.silva");
		ctrl.cadastraUsuario("Hemillainy", "12345", "hemillainy.santos");
		
		ctrl.cadastrarEletronico("Cássio", "123", "Guitar Hero", 99.99, "X-Box");
		ctrl.cadastrarJogoTabuleiro("Hemillainy", "12345", "Xadrez", 89.63);
		ctrl.cadastrarBluRaySerie("Geovane", "1234","Naruto" , 45.00, "Shippuden", 20, "QUATORZE_ANOS", "Anime", 6);
		ctrl.cadastrarBluRayFilme("Geovane", "1234", "Flashpoint", 14.50, 180, "Ação", "LIVRE", 2018);
		ctrl.cadastrarBluRayShow("Cássio", "123", "Galinha pintadinha", 2.99, 90, 20, "Galinha", "LIVRE");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveUsuario() {
		ctrl.removeUsuario("Hemillainy", "12345");
		ctrl.getInfoUsuario("Hemillainy", "12345", "Nome");
		ctrl.removeUsuario("Sasuke", "90");
	}
	@Test
	public void testGetInfoUsuario() {
		assertEquals("Cássio", ctrl.getInfoUsuario("Cássio", "123", "Nome"));
		assertEquals("geovane.silva", ctrl.getInfoUsuario("Geovane", "1234", "Email"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioInvalido() {
		ctrl.getInfoUsuario("Sasuke", "21", "Nome");
		ctrl.getInfoUsuario("Cássio", "99", "Nome");
	}
	@Test
	public void testAtualizaUsuario() {
		ctrl.atualizaUsuario("Hemillainy", "12345", "Email", "hemi.suelen");
		assertEquals("hemi.suelen", ctrl.getInfoUsuario("Hemillainy", "12345", "Email"));
		ctrl.atualizaUsuario("Geovane", "1234", "Telefone", "4321");
		assertEquals("4321", ctrl.getInfoUsuario("Geovane", "4321", "Telefone"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioInvalido() {
		ctrl.atualizaUsuario("Sasuke", "171", "Telefone", "321");
	}
	@Test
	public void testAdicionaPecaPerdida() {
		ctrl.adicionarPecaPerdida("Hemillainy", "12345", "Xadrez", "Torre");
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 89.63, Nao emprestado, COM PECAS PERDIDAS", ctrl.pesquisaDetalhesItem("Hemillainy", "12345", "Xadrez"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testAdicionarPecaPerdidaUsuarioInvalido() {
		ctrl.adicionarPecaPerdida("Hemillainy", "1234", "Xadrez", "Rainha");
		ctrl.adicionarPecaPerdida("Hemillaini", "12345", "Xadrez", "Peão");
	}
	@Test
	public void testCadastrarEletronico() {
		ctrl.cadastrarEletronico("Cássio", "123", "Point blank", 29.90, "X-Box");
		assertEquals("JOGO ELETRONICO: Point blank, R$ 29.9, Nao emprestado, X-Box", ctrl.pesquisaDetalhesItem("Cássio", "123", "Point blank"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalido() {
		ctrl.cadastrarEletronico("Geovane", "1234", null, 23.97, "X-Box");
		ctrl.cadastrarEletronico("Geovane", "1234", "Clash Royale", 0, null);
		ctrl.cadastrarEletronico(null, "1234", "Clash Royale", 0, "Celular");
		ctrl.cadastrarEletronico("Geovane", null, "Clash Royale", 0, "Celular");
		ctrl.cadastrarEletronico("", "1234", "Clash Royale", 23.97, "X-Box");
		ctrl.cadastrarEletronico("Geovane", "", "Clash Royale", 23.97, "X-Box");
		ctrl.cadastrarEletronico("Geovane", "1234", "Clash Royale", 23.97, "");
	}
	@Test
	public void testCadastrarJogoTabuleiro() {
		ctrl.cadastrarJogoTabuleiro("Cássio", "123", "Jogo da vida", 29);
		assertEquals("JOGO DE TABULEIRO: Jogo da vida, R$ 29.0, Nao emprestado, COMPLETO", ctrl.pesquisaDetalhesItem("Cássio", "123", "Jogo da vida"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroInvalido() {
		ctrl.cadastrarJogoTabuleiro("Hemillainy", "12345", "", 23);
		ctrl.cadastrarJogoTabuleiro("Hemillainy", "", "Banco imobiliário", 29);
		ctrl.cadastrarJogoTabuleiro("", "12345", "Banco imobiliário", 29);
		ctrl.cadastrarJogoTabuleiro("   ", "12345", "Banco imobiliário", 29);
		ctrl.cadastrarJogoTabuleiro("Hemillainy", "   ", "Banco imobiliário", 29);
		ctrl.cadastrarJogoTabuleiro("Hemillainy", "12345", "   ", 29);
		ctrl.cadastrarJogoTabuleiro(null, "", "Banco imobiliário", 29);
		ctrl.cadastrarJogoTabuleiro("Hemillainy", null, "Banco imobiliário", 29);
		ctrl.cadastrarJogoTabuleiro("Hemillainy", "12345", null, 29);
	}
	@Test
	public void testCadastrarBluRayFilme() {
		ctrl.cadastrarBluRayFilme("Geovane", "1234", "Cyborg", 20, 180, "Ação", "LIVRE", 2018);
		assertEquals("FILME: Cyborg, R$ 20.0, Nao emprestado, 180 min, LIVRE, Ação, 2018", ctrl.pesquisaDetalhesItem("Geovane", "1234", "Cyborg"));
	}
	@Test(expected = NullPointerException.class)
	public void testCadastrarBluRayFilmeInvalido() {
		ctrl.cadastrarBluRayFilme("Barry", "978", "De volta ao futuro", 999, 100000, "Comédia", "CEM_ANOS", 3027);
	}
	@Test
	public void testCadastrarBluRayShow() {
		ctrl.cadastrarBluRayShow("Hemillainy", "12345", "Carrossel", 0, 60, 5, "Carrossel", "LIVRE");
		assertEquals("SHOW: Carrossel, R$ 0.0, Nao emprestado, 60 min, LIVRE, Carrossel, 5 faixas", ctrl.pesquisaDetalhesItem("Hemillainy", "12345", "Carrossel"));
	}
	@Test(expected = NullPointerException.class)
	public void testCadastrarBluRayShowInvalido() {
		ctrl.cadastrarBluRayShow("Barry", "978", "De volta ao futuro", 999, 100000, 88, "DC", "CEM_ANOS");
	}
	@Test
	public void testCadastrarBluRaySerie() {
		ctrl.cadastrarBluRaySerie("Cássio", "123", "Arrow", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS", "Ação", 1);
		assertEquals("SERIE: Arrow, R$ 19.9, Nao emprestado, 40 min, QUATORZE_ANOS, Ação, Temporada 1", ctrl.pesquisaDetalhesItem("Cássio", "123", "Arrow"));
	}
	@Test(expected = NullPointerException.class)
	public void testCadastrarBluRaySerieInvalido() {
		ctrl.cadastrarBluRaySerie("cassio", "123", "Arrow", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS", "Ação", 1);
	}
	@Test
	public void testPesquisaDetalhesItem() {
		ctrl.cadastrarBluRaySerie("Cássio", "123", "The Flash", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS", "Ação", 1);
		assertEquals("SERIE: The Flash, R$ 19.9, Nao emprestado, 40 min, QUATORZE_ANOS, Ação, Temporada 1", ctrl.pesquisaDetalhesItem("Cássio", "123", "The Flash"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItemInvalido() {
		ctrl.pesquisaDetalhesItem("Cássio", "123", "The Flash");
	}
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItemUsuarioInvalido() {
		ctrl.cadastrarBluRaySerie("Cássio", "123", "The 100", 19.9, "Muita morte", 40, "LIVRE", "Aventura", 5);
		ctrl.pesquisaDetalhesItem("cassio", "123", "The 100");
	}
}
