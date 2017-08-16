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

}
