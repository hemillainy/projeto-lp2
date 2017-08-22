package principal;

import org.junit.Test;

import principal.item.ItemValidacao;

/**
 * Testes da Classe ItemValidacao.
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ItemValidacaoTest {

	ItemValidacao iv = new ItemValidacao();

	/**
	 * Esperada a excecao na chamada do metodo pois o item nao se encontra
	 * cadastrado no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testItemNaoEncontrado() {
		iv.itemNaoEncontrado(false);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testItemInvalidoNomeNulo() {
		iv.itemInvalido(null, 10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome vazio. 
	 */
	public void testItemInvalidoNomeVazio() {
		iv.itemInvalido("", 10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome composto apenas por espacos. 
	 */
	public void testItemInvalidoNomeEpacos() {
		iv.itemInvalido("     ", 10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro preco negativo. 
	 */
	public void testItemInvalidoPrecoInvalido() {
		iv.itemInvalido("War", -2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEletronicoInvalidoNomeNulo() {
		iv.eletronicoInvalido(null, 10, "PC");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEletronicoInvalidoNomeVazio() {
		iv.eletronicoInvalido("", 10, "PC");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEletronicoInvalidoNomeEspacos() {
		iv.eletronicoInvalido("     ", 10, "PC");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro preco negativo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEletronicoInvalidoPrecoInvalido() {
		iv.eletronicoInvalido("WAR", -2, "PC");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de plataforma nao cadastrado no sistem. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEletronicoInvalidoPlataformaInvalida() {
		iv.eletronicoInvalido("Wining Eleven", 10, "PS1");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTabulerioInvalidoNomeNulo() {
		iv.tabulerioInvalido(null, 10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTabulerioInvalidoNomeVazio() {
		iv.tabulerioInvalido("", 10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTabulerioInvalidoNomeEspacos() {
		iv.tabulerioInvalido("     ", 10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro preco negativo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTabulerioInvalidoPrecoInvalido() {
		iv.tabulerioInvalido("WAR", -2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaNomeNulo() {
		iv.serieInvalida(null, 10, 10, "12", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaNomeVazio() {
		iv.serieInvalida("", 10, 10, "12_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaNomeEspacos() {
		iv.serieInvalida(null, 10, 10, "DEZ_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro preco negativo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaNomePrecoInvalido() {
		iv.serieInvalida("WAR", -2, 10, "DEZ_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro duracao negativa. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaDuracaoInvalida() {
		iv.serieInvalida("WAR", 10, -2, "DEZ_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de classificacao nao cadastrada no sistema. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaClassificacaoInvalida() {
		iv.serieInvalida("WAR", 10, 10, "12 anos", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de genero nao cadastrado no sistema. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaGeneroInvalido() {
		iv.serieInvalida("WAR", 10, 10, "DEZ_ANOS", "ANIME", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro temporada igual a 0. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSerieInvalidaTemporadaInvalida() {
		iv.serieInvalida("WAR", 10, 10, "DEZ_ANOS", "ROMANCE", 0);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoNomeNulo() {
		iv.filmeInvalido(null, 10, 10, "12", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoNomeVazio() {
		iv.filmeInvalido("", 10, 10, "12_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoNomeEspacos() {
		iv.filmeInvalido("   ", 10, 10, "DEZ_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro preco negativo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoNomePrecoInvalido() {
		iv.filmeInvalido("SpiderMan", -2, 10, "DEZ_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro duracao negativa. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoDuracaoInvalida() {
		iv.filmeInvalido("SpiderMan", 10, -2, "DEZ_ANOS", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de classificacao nao cadastrada no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoClassificacaoInvalida() {
		iv.filmeInvalido("SpiderMan", 10, 10, "12 anos", "ACAO", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de genero nao cadastrado no sistema. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoGeneroInvalido() {
		iv.filmeInvalido("SpiderMan", 10, 10, "DEZ_ANOS", "ANIME", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de ano de lancamento igual a 0. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFilmeInvalidoAnoLancamentoInvalida() {
		iv.filmeInvalido("SpiderMan", 10, 10, "DEZ_ANOS", "ROMANCE", 0);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoNomeNulo() {
		iv.showInvalido(null, 10, 10, "12", "JOELMA", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoNomeVazio() {
		iv.showInvalido("", 10, 10, "12_ANOS", "JOELMA", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome composto apenas de espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoNomeEspacos() {
		iv.showInvalido("   ", 10, 10, "DEZ_ANOS", "JOELMA", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro preco negativo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoNomePrecoInvalido() {
		iv.showInvalido("Calypso", -2, 10, "DEZ_ANOS", "JOELMA", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro duracao negativa. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoDuracaoInvalida() {
		iv.showInvalido("Calypso", 10, -2, "DEZ_ANOS", "JOELMA", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de classificacao nao cadatrada no sistema. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoClassificacaoInvalida() {
		iv.showInvalido("Calypso", 10, 10, "12 anos", "JOELMA", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome do artista nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoArtistaNulo() {
		iv.showInvalido("Calypso", 10, 10, "DEZ_ANOS", null, 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome do artista vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoArtistaVazio() {
		iv.showInvalido("Calypso", 10, 10, "DEZ_ANOS", "", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome do artista composto apenas de espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoArtistaEspacos() {
		iv.showInvalido("Calypso", 10, 10, "DEZ_ANOS", "   ", 2);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de faixas igual a 0. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testShowInvalidoFaixasInvalida() {
		iv.showInvalido("Calypso", 10, 10, "DEZ_ANOS", "JOELMA", 0);
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o jogo nao esta cadastrado no sistema. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPecaInvalidaNaoTemJogo() {
		iv.pecaInvalida(false, "");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome da peca nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPecaInvalidaNula() {
		iv.pecaInvalida(true, null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome da peca vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPecaInvalidaVazia() {
		iv.pecaInvalida(true, "");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nome da ppeca composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPecaInvalidaEspacos() {
		iv.pecaInvalida(true, "    ");
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o item ja se encontra emprestado. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testItemJaEmprestado() {
		iv.ItemJaEmprestado(true);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro item nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaItemEmprestimo() {
		iv.validaItemEmprestimo(null);
	}

	/**
	 * Esperada a excecao na chamada do metodo pois a serie nao esta cadastrada no sistema. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddTemporadaInvalidaNaoContem() {
		iv.addTemporadaInvalida(false, 100);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de duracao negativa ao tentar adicionar uma temporada a uma serie. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddTemporadaInvalidaDuracaoInvalida() {
		iv.addTemporadaInvalida(true, -10);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de valor nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorInvalidoNulo() {
		iv.valorInvalido(null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de valor vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorVazio() {
		iv.valorInvalido("");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de valor composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValorEspacos() {
		iv.valorInvalido("   ");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de atributo nulo. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoNulo() {
		iv.atributoInvalido(null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de atributo vazio. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoVazio() {
		iv.atributoInvalido("");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de atributo composto apenas por espacos. 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoEspacos() {
		iv.atributoInvalido("     ");
	}

}
