package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import principal.emprestimo.Emprestimo;
import principal.item.Item;
import principal.user.Usuario;

public class Listador {

	/**
	 * Metodo que lista todos os itens que um usuario emprestou.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @return a lista com os emprestimos feitos pelo usuario.
	 */
	public String listaEmprestimosUsuarioEmprestando(Set<Emprestimo> emprestimos, Usuario dono) {
		String retorno = "Emprestimos: ";

		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDono().equals(dono)) {
				retorno += emprestimo.toString() + "|";
			}
		}
		if (retorno.equals("Emprestimos: ")) {
			return "Nenhum item emprestado";
		}
		return retorno;
	}

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @return a listagem dos itens nao cadastrados.
	 */
	public String listaItensNaoEmprestados(List<Usuario> usuarios) {
		Set<Item> itens = new HashSet<>();
		for (Usuario us : usuarios) {
			itens.addAll(us.getItens());
		}
		List<Item> inventario = new ArrayList<>(itens);
		Collections.sort(inventario, new ComparadorNomeItem());

		String saida = "";
		for (Item item : itens) {
			if (item.getStatus().equals("Nao emprestado")) {
				saida += item.toString() + "|";
			}
		}
		return saida;
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

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @return a listagem com os itens emprestados.
	 */
	public String listaItensEmprestados(List<Emprestimo> emp) {
		Collections.reverse(emp);
		removeRepetidos(emp);
		String saida = "";
		for (Emprestimo emprestimo : emp) {
			saida += "Dono do item: " + emprestimo.getNomeDome() + ", Nome do item emprestado: "
					+ emprestimo.getNomeItem() + "|";
		}
		return saida;
	}

}
