import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import principal.item.ItemController;
import principal.user.Usuario;

public class ItemControllerTest {
	
	ItemController ic;
	Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	
	@Before
	public void cria() {
		ic = new ItemController();
		usuario1 = new Usuario("Cássio", "123456", "cassio.cordeiro");
		usuario2 = new Usuario("Geovane", "1234567", "geovane.silva");
		usuario3 = new Usuario("Hemillainy", "12345678", "hemillainy.santos");
		ic.cadastrarEletronico(usuario1, "Guitar Hero", 99.99, "XBOX_ONE");
		ic.cadastrarJogoTabuleiro(usuario3, "Xadrez", 89.63);
		ic.cadastraBluRaySerie(usuario2, "Naruto", 45.00, "Shippuden", 20, "QUATORZE_ANOS", "OUTRO", 6);
		ic.cadastraBluRayFilme(usuario2, "Flashpoint", 14.50, 180, "ACAO", "LIVRE", 2018);
		ic.cadastraBluRayShow(usuario1, "Galinha pintadinha", 2.99, 90, 20, "Galinha", "LIVRE");
		ic.cadastrarEletronico(usuario3, "Tetris", 10.00, "OUTRO");
		ic.cadastraBluRaySerie(usuario3, "The 100", 59.99, "Octavia Linda", 43, "DEZESSEIS_ANOS","DRAMA", 1);
		ic.cadastraBluRayFilme(usuario1, "Liga da Justiça", 14.00, 180, "ACAO", "DEZESSEIS_ANOS", 2017);
	}
	
	
	/**
	 * Apos adicionar uma peca perdida verifica-se se o estado do enum que
	 * representa um jogo completo foi alterado.
	 */
	@Test
	public void testAdicionaPecaPerdida() {
		ic.adicionaPecaPerdida(usuario3, "Xadrez", "Torre");
		assertEquals("JOGO DE TABULEIRO: Xadrez, R$ 89.63, Nao emprestado, COM PECAS PERDIDAS", ic.pesquisaDetalhesItens(usuario3, "Xadrez"));
	}

	/**
	 * Teste de metodo cadastrarEletronico
	 */
	@Test
	public void testCadastrarEletronico() {
		ic.cadastrarEletronico(usuario1, "Point blank", 29.90, "XBOX_ONE");
		assertEquals("JOGO ELETRONICO: Point blank, R$ 29.9, Nao emprestado, XBOX_ONE",
				ic.pesquisaDetalhesItens(usuario1, "Point blank"));
	}

	/**
	 * Teste com excecao do metodo cadastrarEletronico com nome do item null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoNomeItemInvalido() {
		ic.cadastrarEletronico(usuario2, null, 23.97, "XBOX360");
	}

	/**
	 * Teste com excecao do metodo cadastrarEletronico com plataforma null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoPlataformaInvalida() {
		ic.cadastrarEletronico(usuario2, "Clash Royale", 0, null);
	}

	/**
	 * Teste com excecao do metodo cadastrarEletronico com plataforma vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarEletronicoInvalidoPlataformaVazia() {
		ic.cadastrarEletronico(usuario2, "Clash Royale", 23.97, "");
	}

	/**
	 * Teste do metodo cadastrarJogoTabuleiro
	 */
	@Test
	public void testCadastrarJogoTabuleiro() {
		ic.cadastrarJogoTabuleiro(usuario1, "Jogo da vida", 29);
		assertEquals("JOGO DE TABULEIRO: Jogo da vida, R$ 29.0, Nao emprestado, COMPLETO",
				ic.pesquisaDetalhesItens(usuario1, "Jogo da vida"));
	}

	/**
	 * Teste com excecao do metodo cadastrarJogoTabuleiro com plataforma vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroInvalidoNomeItemVazio() {
		ic.cadastrarJogoTabuleiro(usuario2, "", 23);
	}

	/**
	 * Teste com excecao do metodo cadastrarJogoTabuleiro com plataforma
	 * composta por espacos
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroInvalidoNomeItemEspacos() {
		ic.cadastrarJogoTabuleiro(usuario3, "   ", 29);
	}

	/**
	 * Teste com excecao do metodo cadastrarJogoTabuleiro com plataforma null
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarJogoTabuleiroInvalido() {
		ic.cadastrarJogoTabuleiro(usuario3, null, 29);
	}

	/**
	 * Teste do metodo cadastrarBluRayFilme
	 */
	@Test
	public void testCadastrarBluRayFilme() {
		ic.cadastraBluRayFilme(usuario2, "Cyborg", 20, 180, "ACAO", "LIVRE", 2018);
		assertEquals("FILME: Cyborg, R$ 20.0, Nao emprestado, 180 min, LIVRE, ACAO, 2018",
				ic.pesquisaDetalhesItens(usuario2, "Cyborg"));
	}

	/**
	 * Teste do metodo cadastrarBlurayShow
	 */
	@Test
	public void testCadastrarBluRayShow() {
		ic.cadastraBluRayShow(usuario3, "Carrossel", 0.0, 60, 5, "Carrossel", "LIVRE");
		assertEquals("SHOW: Carrossel, R$ 0.0, Nao emprestado, 60 min, LIVRE, Carrossel, 5 faixas",
				ic.pesquisaDetalhesItens(usuario3, "Carrossel"));
	}

	/**
	 * Teste do metodo cadastrarBluRaySerie
	 */
	@Test
	public void testCadastrarBluRaySerie() {
		ic.cadastraBluRaySerie(usuario1, "Arrow", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS", "ACAO",
				1);
		assertEquals("SERIE: Arrow, R$ 19.9, Nao emprestado, 40 min, QUATORZE_ANOS, ACAO, Temporada 1",
				ic.pesquisaDetalhesItens(usuario1, "Arrow"));
	}

	/**
	 * Teste do metodo pesquisaDetalhesItem
	 */
	@Test
	public void testPesquisaDetalhesItem() {
		ic.cadastraBluRaySerie(usuario1, "The Flash", 19.90, "Nasce a lenda", 40, "QUATORZE_ANOS",
				"ACAO", 1);
		assertEquals("SERIE: The Flash, R$ 19.9, Nao emprestado, 40 min, QUATORZE_ANOS, ACAO, Temporada 1",
				ic.pesquisaDetalhesItens(usuario1, "The Flash"));
	}

	/**
	 * Teste do metodo pesquisaDetalhesItem com excecao, item nao cadastrado
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPesquisaDetalhesItemInvalido() {
		ic.pesquisaDetalhesItens(usuario1, "The Flash");
	}


	/**
	 * Testa o metodo getPrecoItem em um item cadastrado no usuario3.
	 */
	@Test
	public void testGetPrecoItem() {
		assertEquals("10.0", ic.getInfoItem(usuario3, "Tetris", "Preco"));
	}

	/**
	 * Testa o metodo getNomeItem em um item cadastrado no usuario1.
	 */
	@Test
	public void testGetNomeItem() {
		assertEquals("The 100", ic.getInfoItem(usuario3,"The 100", "Nome"));
	}

	/**
	 * Testa o metodo getPrecoItem para um item nao cadastrado. Uma excecao eh
	 * esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetPrecoItemInvalido() {
		ic.getInfoItem(usuario1, "Naruto", "Nome");
	}

	/**
	 * Testa o metodo getNomeItem para um item nao cadastrado. Uma excecao eh
	 * esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetNomeItemInvalido() {
		ic.getInfoItem(usuario3, "Box GOT", "Nome");
	}

	/**
	 * Testa o metodo que remove o item de um usuario. Primeiro o item eh
	 * removido do usuario1 e depois tenta-se pegar o nome do item removido. Uma
	 * excecao eh esperada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoverItem() {
		ic.removeItem(usuario1, "Damas");
		ic.getInfoItem(usuario1, "Damas", "Nome");
	}

	/**
	 * Testa o metodo de alterar o nome de um item. Primeiro eh alterado o nome
	 * do item e depois eh verificado com o auxilio do metodo getNomeItem
	 */
	@Test
	public void testAlteraNomeItem() {
		ic.atualizaItem(usuario1, "Liga da Justiça", "Nome", "Flashpoint");
		assertEquals("Flashpoint", ic.getInfoItem(usuario1, "Flashpoint", "Nome"));
	}

	/**
	 * Testa o metodo de alterar nome de um item. Eh esperada uma excecao pois o
	 * item que tenta atualizar nao existe.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraNomeItemInvalido() {
		ic.atualizaItem(usuario1, "Jogos Vorazes","Nome", "X-men");
		ic.getInfoItem(usuario1, "X-men", "Nome");
	}

	/**
	 * Testa o metodo de atualizar que atualiza o preco de um item. Primeiro eh
	 * feita a atualizacao, depois a verificacao com auxilio do getPrecoItem.
	 */
	@Test
	public void testAtualizaPrecoItem() {
		ic.atualizaItem(usuario3, "Tetris", "Preco", "50.00");
		assertEquals("50.0", ic.getInfoItem(usuario3, "Tetris", "Preco"));
	}

}
