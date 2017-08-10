package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import itens.blurays.*;
import principal.Item;
import itens.jogos.*;

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
public class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private Validacao validacao;
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
		this.itens = new HashMap<>();
		this.emprestimos = new HashSet<>();
		this.validacao = new Validacao();
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
	 * Cadastra um jogo eletronico.
	 * 
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do jogo eletronico.
	 * @param plataforma
	 *            do jogo eletronico.
	 */
	public void cadastraItem(String nomeItem, double preco, String plataforma) {
		itens.put(nomeItem, new JogoEletronico(nomeItem, preco, plataforma));
	}

	/**
	 * Metodo que cadastra um jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 */
	public void cadastraItem(String nomeItem, double preco) {
		itens.put(nomeItem, new JogoTabuleiro(nomeItem, preco));
	}

	/**
	 * Metodo que cadastra um filme.
	 * 
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 * @param duracao
	 *            do filme.
	 * @param genero
	 *            do filme.
	 * @param classificacao
	 *            indicativa do filme.
	 * @param lancamento
	 *            do filme.
	 */
	public void cadastraItem(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int lancamento) {
		itens.put(nomeItem, new Filme(nomeItem, preco, duracao, classificacao, genero, lancamento));
	}

	/**
	 * Metodo que cadastra um show.
	 * 
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 * @param duracao
	 *            do show.
	 * @param faixas
	 *            do show.
	 * @param artista
	 *            que realizou o show.
	 * @param classificacao
	 *            indicativa do show.
	 */
	public void cadastraBluRayShow(String nomeItem, double preco, int duracao, String classificacao, String artista,
			int faixas) {
		itens.put(nomeItem, new Show(nomeItem, preco, duracao, classificacao, artista, faixas));
	}

	/**
	 * Metodo que cadastra uma serie. * @param nomeItem a ser cadastrado.
	 * 
	 * @param preco
	 *            do item.
	 * @param descricao
	 *            da serie.
	 * @param duracao
	 *            da serie.
	 * @param classificacao
	 *            indicativa da serie.
	 * @param genero
	 *            da serie.
	 * @param temporada
	 *            da serie.
	 */
	public void cadastraItem(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		itens.put(nomeItem, new Serie(nomeItem, preco, duracao, classificacao, genero, temporada));
	}

	/**
	 * Metodo que adiciona um BluRay a uma serie.
	 * 
	 * @param nomeBluRayTemporada
	 *            a ser cadastrado o BluRay.
	 * @param duracao
	 *            do episodio.
	 */
	public void adicionaBluRay(String nomeBluRayTemporada, int duracao) {
		Serie serie = (Serie) (itens.get(nomeBluRayTemporada));
		serie.adicionarBluRay(duracao);
	}

	/**
	 * Metodo que retorna a representacao de um item.
	 * 
	 * @param nomeItem
	 *            a ser pesquisado.
	 * @return a representacao do item.
	 */
	public String exibeDetalhesItem(String nomeItem) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		return itens.get(nomeItem).toString();
	}

	/**
	 * Retorna o valor de um item em String.
	 * 
	 * @param nomeItem
	 *            item o qual sera exibido seu valor.
	 * @return valor do item.
	 */
	public String getPrecoItem(String nomeItem) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		Item item = itens.get(nomeItem);
		return String.valueOf(item.getPreco());
	}

	/**
	 * Retorna o nome de um item.
	 * 
	 * @param nomeItem
	 *            item o qual tera seu nome exi
	 * @return nome do item.
	 */
	public String getNomeItem(String nomeItem) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		return itens.get(nomeItem).getNome();
	}

	/**
	 * Metodo que remove um item.
	 * 
	 * @param nomeItem
	 *            a ser removido.
	 */
	public void removerItem(String nomeItem) {
		if (!itens.containsKey(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		itens.remove(nomeItem);
	}

	/**
	 * Metodo o nome de um item.
	 * 
	 * @param nomeItem
	 *            item que tera seu nome alterado.
	 * @param valor
	 *            novo nome do item.
	 */
	public void atualizaNomeItem(String nomeItem, String valor) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		Item item = itens.get(nomeItem);
		itens.get(nomeItem).setNome(valor);

		setKeyItem(item);
	}

	/**
	 * Atualiza o preço de um item.
	 * 
	 * @param nomeItem
	 *            item que tera seu preco alterado.
	 * @param valor
	 *            novo preco do item.
	 */
	public void atualizaPrecoItem(String nomeItem, String valor) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		itens.get(nomeItem).setPreco(Double.parseDouble(valor));
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
	private boolean hasItem(String nomeItem) {
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
	private void setKeyItem(Item item) {
		itens.remove(item);
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
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
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
}
