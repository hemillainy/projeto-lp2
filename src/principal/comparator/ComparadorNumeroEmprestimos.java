package principal.comparator;

import java.util.Comparator;

import principal.item.Item;

/**
 * Classe de comparacao de um item pelo numero de emprestimoss.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ComparadorNumeroEmprestimos implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		if (item2.getNumEmprestimos() - item1.getNumEmprestimos() > 0) {
			return 1;
		}
		else if (item2.getNumEmprestimos() - item1.getNumEmprestimos() < 0) {
			return -1;
		}
		return 0;
	}

}
