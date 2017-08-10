package principal;

import java.util.Comparator;

/**
 * 
 * Classe que implementa o Comparator de Item.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ComparadorValor implements Comparator<Item> {

	/**
	 * Compara os preços de dois itens.
	 */
	@Override
	public int compare(Item o1, Item o2) {
		double result = o1.getPreco() - o2.getPreco();
		if (result < 0) {
			return -1;
		}
		return 1;
	}

}
