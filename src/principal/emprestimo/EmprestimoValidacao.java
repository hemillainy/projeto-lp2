package principal.emprestimo;

import principal.item.Item;

/**
 * Classe responsavel pela verificacao de dados invalidos para emprestimos.
 * Quando for passado um dado invalido sera lancado um IllegalArgumentException.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 */
public class EmprestimoValidacao {

	/**
	 * Verifica nulidade de um item. Se o item for nulo uma excecao e lancada.
	 * 
	 * @param item
	 *            o item a ser verificado.
	 */
	public void validaItemEmprestimo(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item nao encontrado");
		}

	}

	/**
	 * Excecao lancada quando tentarem fazer um emprestimo de um item que ja
	 * esta emprestado.
	 * 
	 * @param itemJaEmprestado identifica se o item ja esta emprestado.
	 *
	 */
	public void ItemJaEmprestado(boolean itemJaEmprestado) {
		if (itemJaEmprestado) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	/**
	 * Verifica se um atributo de pesquisa eh valido.
	 * 
	 * @param atributo
	 *            o atributo a ser verificado.
	 */
	public void atributoInvalido(String atributo) {
		if (atributo == null || atributo.trim().isEmpty()) {
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Excecao lancada quando for solicitado um emprestimo que nao foi
	 * cadastrado.
	 *
	 * @param contemEmprestimo
	 *            identifica se existe ou nao o emprestimo no sistema.
	 */
	public void emprestimoNaoEncontrado(boolean contemEmprestimo) {
		if (!contemEmprestimo) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
	}

	public void itemNaoEncontrado(boolean hasItem) {
		if (!hasItem) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}
}
