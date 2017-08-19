package principal.comparator;

import java.util.Comparator;
import principal.item.Item;;

public class ComparadorNomeItem implements Comparator<Item> {

	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}
}
