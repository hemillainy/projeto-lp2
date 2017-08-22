package principal.emprestimo;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import principal.user.Usuario;

/**
 * 
 * Classe que faz as listagens de informacoes de emprestimos solicitadas pelo usuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 */
public class EmprestimoListador {
	
	/**
	 * Metodo que lista todos os itens que um usuario emprestou.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @return a lista com os emprestimos feitos pelo usuario.
	 */
	public String listaEmprestimosUsuarioEmprestando(Map<IdEmprestimo, Emprestimo> emprestimos, Usuario dono) {
		Set<Emprestimo> empres = new HashSet<>(emprestimos.values());

		String retorno = "Emprestimos: ";

		for (Emprestimo emprestimo : empres) {
			if (emprestimo.getDono().equals(dono)) {
				retorno += emprestimo.toString() + "|";
			}
		}
		if (retorno.equals("Emprestimos: ")) {
			retorno = "Nenhum item emprestado";
		}
		return retorno;
	}
	
	/**
	 * Metodo que lista os emprestimos concedidos a um ususario.
	 * 
	 * @param requerente
	 *            usuario que tera o que ele pegou emprestado listado.
	 * @return a listagem do emprestimos concedidos a um usuario.
	 */
	public String listaEmprestimosUsuarioPegandoEmprestado(Usuario requerente) {
		String retorno = "Emprestimos pegos: ";
		for (Emprestimo emprestimo : requerente.getEmprestimos()) {
			if (emprestimo.getRequerente().equals(requerente)) {
				retorno += emprestimo.toString() + "|";
			}
		}
		if (retorno.equals("Emprestimos pegos: ")) {
			retorno = "Nenhum item pego emprestado";
		}
		return retorno;
	}
	
	/**
	 * Metodo que lista os associados a um item.
	 * 
	 * @param emprestimos
	 *            List com todos os emprestimos cadastrados no sistema.
	 * @param nome
	 *            do item.
	 * @return a lista com todos os emprestimos relacionados a um item.
	 */
	public String listaEmprestimosItem(List<Emprestimo> emprestimos, String nome) {
		String retorno = "Emprestimos associados ao item: ";
		Collections.reverse(emprestimos);
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getItem().getNome().equals(nome)) {
				retorno += emprestimo.toString() + "|";
			}
		}
		if (retorno.equals("Emprestimos associados ao item: ")) {
			retorno = "Nenhum emprestimos associados ao item";
		}
		return retorno;
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

}
