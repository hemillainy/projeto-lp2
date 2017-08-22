package principal.item;

import java.util.Collections;
import java.util.List;

import principal.comparator.ComparadorNumeroEmprestimos;
import principal.comparator.ComparadorValor;
import principal.emprestimo.Emprestimo;

public class ItemListador {

	private ComparadorNumeroEmprestimos comparadorNumeroEmprestimos;
	private ComparadorValor comparadorValor;

	public ItemListador() {
		this.comparadorNumeroEmprestimos = new ComparadorNumeroEmprestimos();
		this.comparadorValor = new ComparadorValor();
	}

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @param listItens
	 *            List com todos os itens cadastrados do sistema.
	 * @return a listagem dos itens nao cadastrados.
	 */
	public String listaItensNaoEmprestados(List<Item> listItens) {
		Collections.sort(listItens);

		String saida = "";
		for (Item item : listItens) {
			if (item.getStatus().equals("Nao emprestado")) {
				saida += item.toString() + "|";
			}
		}
		return saida;
	}

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @param emp
	 *            List com todos os emprestimos cadastrados no sistema.
	 * @return a listagem com os itens emprestados.
	 */
	public String listaItensEmprestados(List<Emprestimo> emp) {
		Collections.reverse(emp);
		removeRepetidos(emp);
		String saida = "";
		for (Emprestimo emprestimo : emp) {
			saida += "Dono do item: " + emprestimo.getNomeDono() + ", Nome do item emprestado: "
					+ emprestimo.getNomeItem() + "|";
		}
		return saida;
	}

	/**
	 * Metodo que lista os 10 itens mais emprestados.
	 * 
	 * @return a listagem dos 10 itens mais emprestados.
	 */
	public String listaTopDez(List<Item> inventario) {
		Collections.sort(inventario, comparadorNumeroEmprestimos);
		String itens = "";

		int i = 0;
		while (i <= 10 && i <= inventario.size() && inventario.get(i).getNumEmprestimos() != 0) {

			Item item = inventario.get(i);
			itens += (i + 1) + ") " + item.getNumEmprestimos() + " emprestimos - " + item.toString() + "|";
			i++;
		}
		return itens;
	}

	/**
	 * Metodo que lista todos os itens em ordem crescente de valor.
	 * 
	 * @return a listagem de todos os itens em ordem crecente de valor.
	 */
	public String listaItensOrdenadosPorValor(List<Item> itens) {
		Collections.sort(itens, comparadorValor);
		String saida = "";
		for (Item item : itens) {
			saida += item.toString() + "|";
		}
		return saida;
	}

	/**
	 * Metodo que lista todos os itens em ordem lexicografica.
	 * 
	 * @return a listagem de todos os itens em ordem lexicografica.
	 */
	public String listaItensOrdenadosPorNome(List<Item> inventario) {
		Collections.sort(inventario);
		String itens = "";
		for (Item item : inventario) {
			itens += item.toString() + "|";
		}
		return itens;
	}

	/**
	 * Remove os intens repetidos do List de emprestimos.
	 * 
	 * @param emp
	 *            List de emprestimos.
	 */
	private void removeRepetidos(List<Emprestimo> emp) {
		for (int i = 0; i < emp.size(); i++) {
			Emprestimo emp1 = emp.get(i);
			for (int j = i + 1; j < emp.size(); j++) {
				Emprestimo emp2 = emp.get(j);
				if (emp1.getItem().equals(emp2.getItem())) {
					emp.remove(i);
				}
			}
		}
	}
}
