package principal;

import java.util.*;

import principal.comparator.*;
import principal.emprestimo.*;
import principal.item.Item;
import principal.user.Usuario;

/**
 * Classe que faz as listagens de informacoes solicitadas pelo usuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Listador {
	private ComparadorValor comparadorValor;
	private ComparadorNumeroEmprestimos comparadorNumeroEmprestimos;
	private ComparadorReputacao comparadorReputacao;

	/**
	 * Constroi um Listador. Todos listador possui um comparadorValor, um
	 * comparadorNumeroEmprestimo e um comparadorReputacao; os tres servem para
	 * ordenar as saida da forma desejada.
	 */
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
	 * @param listItens
	 *            List com todos os itens cadastrados do sistema.
	 * @return a listagem dos itens nao cadastrados.
	 */
	public String listaItensNaoEmprestados(List<Item> listItens) {
		Collections.sort(listItens, new ComparadorNomeItem());

		String saida = "";
		for (Item item : listItens) {
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
	 * @param emp
	 *            List com todos os emprestimos cadastrados no sistema.
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
			return "Nenhum item pego emprestado";
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
	public String getInfoItem(Item item, String atributo) {
		String info = "";
		if (atributo.toUpperCase().equals("PRECO")) {
			info = String.valueOf(item.getPreco());
		} else if (atributo.toUpperCase().equals("NOME")) {
			info = item.getNome();
		}
		return info;
	}

	/**
	 * Metodo que lista os usuario com reputacao menor que 0.
	 * 
	 * @param usuarios
	 *            List com todos os usuarios cadastrados no sistema.
	 * @return a listagem com os usuario com reputacao menor que 0.
	 */
	public String listarCaloteiros(List<Usuario> usuarios) {
		String info = "Lista de usuarios com reputacao negativa: ";
		Collections.sort(usuarios);

		for (Usuario usuario : usuarios) {
			if (usuario.getFidelidade().equals("Caloteiro")) {
				info += usuario + "|";
			}
		}
		return info;
	}

	/**
	 * Metodo que lista os 10 usuarios com melhores reputaÃ§oes.
	 * 
	 * @param usuarios
	 *            List com todos os usuarios cadastrados no sistema.
	 * @return a listagem com os 10 usuarios com melhor reputacao.
	 */
	public String listarTop10MelhoresUsuarios(List<Usuario> usuarios) {
		String info = "";
		Collections.sort(usuarios, comparadorReputacao);

		int posicao = 0;
		while (posicao < 10 && posicao < usuarios.size()) {
			Usuario usuario = usuarios.get(posicao);
			String reputacao = String.format("%.2f", usuario.getReputacao());
			info += posicao + 1 + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|";
			posicao++;
		}
		return info;
	}

	/**
	 * Metodo que lista os 10 usuarios com pior reputacao.
	 * 
	 * @param usuarios
	 *            List com todos os usuarios cadastrados no sistema.
	 * @return a listagem com os 10 usuarios com menor reputacao.
	 */
	public String listarTop10PioresUsuarios(List<Usuario> usuarios) {
		String info = "";
		Collections.sort(usuarios, comparadorReputacao);
		Collections.reverse(usuarios);
		int posicao = 0;
		while (posicao < 10 && posicao < usuarios.size()) {
			Usuario usuario = usuarios.get(posicao);
			String reputacao = String.format("%.2f", usuario.getReputacao());
			info += posicao + 1 + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|";
			posicao++;
		}
		return info;
	}
}
