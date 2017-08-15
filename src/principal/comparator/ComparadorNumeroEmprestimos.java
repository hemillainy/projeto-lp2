package principal.comparator;

import java.util.Comparator;

import principal.item.Item;

public class ComparadorNumeroEmprestimos implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return item2.getNumEmprestimos() - item1.getNumEmprestimos();
	}

}
