package principal;

import java.util.Set;

import principal.emprestimo.Emprestimo;
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

}
