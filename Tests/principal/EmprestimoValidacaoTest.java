package principal;

import org.junit.Test;

import principal.emprestimo.EmprestimoValidacao;

/**
 * Testes da Classe EmprestimoValidacao.
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class EmprestimoValidacaoTest {

	EmprestimoValidacao ev = new EmprestimoValidacao();

	/**
	 * Esperada a excecao na chamada do metodo com parametro nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaItemEmprestimo() {
		ev.validaItemEmprestimo(null);
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o item ja esta emprestado no momento.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testItemJaEmprestado() {
		ev.ItemJaEmprestado(true);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoNulo() {
		ev.atributoInvalido(null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoVazio() {
		ev.atributoInvalido("");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro composto apenas de
	 * espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoEspacos() {
		ev.atributoInvalido("      ");
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o emprestimo nao esta
	 * cadastrado no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testEmprestimoNaoEncontrado() {
		ev.emprestimoNaoEncontrado(false);
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o item a ser emprestado nao
	 * se encontra no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testItemNaoEncontrado() {
		ev.itemNaoEncontrado(false);
	}

}
