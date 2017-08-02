package itens;

import java.util.Comparator;

public class ComparadorValor implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return (int) (o1.getValor() - o2.getValor());
	}

}
