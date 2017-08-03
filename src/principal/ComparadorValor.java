package principal;

import java.util.Comparator;

public class ComparadorValor implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		double result = o1.getPreco() - o2.getPreco();
		if (result < 0) {
			return -1;
		}
		else if (result > 0) {
			return 1;
		}
		return 0;
	}

}
