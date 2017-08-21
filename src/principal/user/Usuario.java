package principal.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import principal.emprestimo.Emprestimo;
import principal.item.Item;
import principal.item.blurays.Serie;
import principal.item.jogos.JogoTabuleiro;
import principal.user.reputacao.CartaoFidelidade;

/**
 *
 * Representacao de um Usuario. Todo usuario possui um nome, um telefone e um
 * email.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Usuario implements Comparable<Usuario> {
	private String nome;
	private String email;
	private String telefone;
	private CartaoFidelidade cartaoFidelidade;
	private Map<String, Item> itens;
	private Set<Emprestimo> emprestimos;

	/**
	 * Controi um Usuario a partir de um nome, telefone e email.
	 * 
	 * @param nome
	 *            nome do usuario.
	 * @param telefone
	 *            telefone do usuario.
	 * @param email
	 *            email do usuario.
	 */
	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cartaoFidelidade = new CartaoFidelidade();
		this.itens = new HashMap<>();
		this.emprestimos = new HashSet<>();
	}

	/**
	 * Retorna o email do usuario.
	 * 
	 * @return email do usuario.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Retorna o nome do usuario.
	 * 
	 * @return nome do usuario.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Metodo que retorna a reputacao do usuario.
	 * 
	 * @return a reputacao do usuario.
	 */
	public double getReputacao() {
		return this.cartaoFidelidade.getReputacao();
	}

	/**
	 * Retorna o telefone do usuario.
	 * 
	 * @return telefone do usuario.
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Altera o email do usuario.
	 * 
	 * @param email
	 *            novo email do usuario.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Altera o telefone do usuario.
	 * 
	 * @param telefone
	 *            novo telefone do usuario.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Representacao em String de um Usuario. A representacao segue o formato:
	 * NOME, EMAIL, TELEFONE
	 */
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}

	/**
	 * Aloca os itens em um ArrayList de itens.
	 * 
	 * @return ArrayList com os itens.
	 */
	public List<Item> getItens() {
		List<Item> listItens = new ArrayList<Item>(itens.values());
		return listItens;
	}

	/**
	 * Metodo que cadastra um jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 */
	public void cadastraItem(Item item) {
		itens.put(item.getNome(), item);
		cartaoFidelidade.addItem();
		addReputacao(item.getPreco(), 0.05);
	}

	/**
	 * Metodo que adiciona um BluRay a uma serie.
	 * 
	 * @param nomeBluRayTemporada
	 *            a ser cadastrado o BluRay.
	 * @param duracao
	 *            do episodio.
	 */
	public void adicionaBluRay(Serie serie) {
		serie.adicionarBluRay(serie.getDuracao());
	}

	/**
	 * Metodo que remove um item.
	 * 
	 * @param nomeItem
	 *            a ser removido.
	 */
	public void removerItem(String nomeItem) {
		cartaoFidelidade.tiraItem();
		itens.remove(nomeItem);
	}

	/**
	 * Metodo que adiciona uma peca perida a um jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            item que tera uma peca perdida adicionada.
	 * @param nomePeca
	 *            peca que sera adicionada como perdida.
	 */
	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		JogoTabuleiro jogo = (JogoTabuleiro) (itens.get(nomeItem));
		jogo.adicionaPecaPerdida(nomePeca);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Verifica se dois usuarios sao iguais. Dois usuarios sao iguais se
	 * possuirem o mesmo nome e telefone.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	/**
	 * Verifica se o item ja esta cadastrado.
	 * 
	 * @param nomeItem
	 *            item que sera verificado.
	 * @return true caso esteja cadastrado ou false caso nao esteja.
	 */
	public boolean hasItem(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			return true;
		}
		return false;
	}

	/**
	 * Remove um item do map de itens e adiciona-o com sua nova key.
	 * 
	 * @param item
	 *            item que sera removido e adicionado.
	 */
	public void setKeyItem(Item item) {
		itens.remove(item.getNome());
		itens.put(item.getNome(), item);
	}

	/**
	 * Pega o item no map de Itens.
	 * 
	 * @param nomeItem
	 *            item que sera pego.
	 * @return o item pego.
	 */
	public Item getItem(String nomeItem) {
		return itens.get(nomeItem);
	}

	/**
	 * Adiciona um emprestimo.
	 * 
	 * @param e
	 *            emprestimo que sera adicionado.
	 */
	public void addEmprestimo(Emprestimo e) {
		emprestimos.add(e);
	}

	/**
	 * Retorna os emprestimos de um usuario.
	 * 
	 * @return o conjunto de emprestimos do usuario.
	 */
	public Set<Emprestimo> getEmprestimos() {
		return this.emprestimos;
	}

	/**
	 * Adiciona valor a reputacao do usuario.
	 * 
	 * @param valor
	 *            o valor do item.
	 * @param taxa
	 *            a taxa que sera tirada do valor do item.
	 */
	public void addReputacao(double valor, double taxa) {
		this.cartaoFidelidade.setReputacao(valor * taxa);
	}

	/**
	 * @return o status da fidelidade do usuario.
	 */
	public String getFidelidade() {
		return cartaoFidelidade.getFidelidade();
	}

	/**
	 * Diz se um usuario pode ou nao pegar itens emprestados.
	 * 
	 * @return true se o usuario pode pegar itens emprestados ou false em caso
	 *         contrario.
	 */
	public boolean podePegarEmprestado() {
		return cartaoFidelidade.podePegarEmprestado();
	}

	/**
	 * @return o periodo que o usuario pode pegar itens emprestados.
	 */
	public int getPeriodo() {
		return cartaoFidelidade.getPeriodo();
	}

	/**
	 * Compara os nomes de dois usuarios.
	 */
	@Override
	public int compareTo(Usuario o) {
		return this.getNome().compareTo(o.getNome());
	}
}