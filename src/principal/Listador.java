package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import principal.comparator.ComparadorNumeroEmprestimos;
import principal.comparator.ComparadorReputacao;
import principal.comparator.ComparadorValor;
import principal.emprestimo.Emprestimo;
import principal.emprestimo.IdEmprestimo;
import principal.item.Item;
import principal.user.Usuario;

public class Listador {
	private ComparadorValor comparadorValor;
	private ComparadorNumeroEmprestimos comparadorNumeroEmprestimos;
	private ComparadorReputacao comparadorReputacao;
	
	public Listador() {
		this.comparadorValor = new ComparadorValor();
		this.comparadorNumeroEmprestimos = new ComparadorNumeroEmprestimos();
		this.comparadorReputacao = new ComparadorReputacao();
	}

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
		for (Item item : inventario) {
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

	/**
	 * Metodo que lista os emprestimos concedidos a um ususario.
	 * 
	 * @param nome
	 *            do ususario.
	 * @param telefone
	 *            do usuario.
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
			return "Nenhum item pego emprestado";
		}
		return retorno;
	}

	/**
	 * Metodo que lista os associados a um item.
	 * 
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
			return "Nenhum emprestimos associados ao item";
		}
		return retorno;
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
	 * Metodo que retorna um atributo de um usuario.
	 * 
	 * @param usuario
	 *            usuario que tera uma info exibida.
	 * @param atributo
	 *            que se deseja.
	 * @return o atributo desejado.
	 */
	public String getInfoUsuario(Usuario usuario, String atributo) {
		String info = "";
		if (atributo.toUpperCase().equals("EMAIL")) {
			info += usuario.getEmail();
		} else if (atributo.toUpperCase().equals("REPUTACAO")) {
			info += usuario.getReputacao();
		} else if (atributo.toUpperCase().equals("CARTAO")) {
			info += usuario.getFidelidade();
		}
		return info;
	}

	/**
	 * Metodo que retorna uma informacao de um item.
	 * 
	 * @param usuario
	 *            o dono do item que tera uma info exibida.
	 * @param nomeItem
	 *            que se deseja pegar a informacao.
	 * @param atributo
	 *            que se deseja visualizar.
	 * @return a informacao correspondente ao atributo desejado.
	 */
	public String getInfoItem(Usuario usuario, String nomeItem, String atributo) {
		String info = "";
		if (atributo.toUpperCase().equals("PRECO")) {
			info = usuario.getPrecoItem(nomeItem);
		} else if (atributo.toUpperCase().equals("NOME")) {
			info = usuario.getNomeItem(nomeItem);
		}
		return info;
	}
	
	public String listarCaloteiros(List<Usuario> collection) {
		String info = "Lista de usuarios com reputacao negativa: ";
		Collections.sort(collection);
		
		for (Usuario usuario : collection) {
			if (usuario.getFidelidade().equals("Caloteiro")) {
				info += usuario + "|";
			}
		}
		return info;
	}

	public String listarTop10MelhoresUsuarios(List<Usuario> users) {
		String info = "";
		Collections.sort(users, comparadorReputacao);
		
		int i = 0;
		while (i < 10 && i <= users.size()) {
			Usuario usuario = users.get(i);
			String reputacao = String.format("%.2f", usuario.getReputacao());
			info += i+1 + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|"; 
			i++;
		}
		return info;
	}

	public String listarTop10PioresUsuarios(List<Usuario> users) {
		String info = "";
		Collections.sort(users, comparadorReputacao);
		int i = users.size() - 1;
		int posicao = 0;
		while (posicao != 10 && posicao < users.size()) {
			Usuario usuario = users.get(i);
			String reputacao = String.format("%.2f", usuario.getReputacao());
			info += posicao + 1 + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|"; 
			i--;
			posicao++;
		}
		return info;
	}
}
