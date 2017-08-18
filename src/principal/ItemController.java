package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import principal.item.Item;
import principal.item.blurays.Filme;
import principal.item.blurays.Serie;
import principal.item.blurays.Show;
import principal.item.jogos.JogoEletronico;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

/**
 * Classe facade do sistema.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ItemController {

	private Listador listador;
	private Validacao validacao;
	private Map<String, Item> itens;

	/**
	 * Constroi um ItemController. Todos ItemController tem um Map de Item, um
	 * listador e um validador de entradas.
	 */
	public ItemController() {
		this.itens = new HashMap<>();
		this.listador = new Listador();
		this.validacao = new Validacao();
	}

	/**
	 * Metodo que retorna os valores do Map de Item.
	 * 
	 * @return um List com os itens do Map de Item.
	 */
	public List<Item> getItens() {
		return new ArrayList<>(itens.values());
	}

	/**
	 * Metodo que verifica se o item esta cadastrado.
	 * 
	 * @param nomeItem
	 *            nome do item verificado.
	 * @return true caso o item esteja cadastrado ou false caso nao esteja.
	 */
	private boolean hasItem(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que cadastra um jogo eletronico.
	 * 
	 * @param usuario
	 *            usuario dono do jogo que sera cadastrado.
	 * @param preco
	 *            preco do jogo eletronico.
	 * @param plataforma
	 *            do jogo eletronico.
	 */
	public void cadastrarEletronico(Usuario usuario, String nomeItem, double preco, String plataforma) {
		validacao.eletronicoInvalido(nomeItem, preco, plataforma);
		Item item = new JogoEletronico(nomeItem, preco, plataforma);
		itens.put(nomeItem, item);
		usuario.cadastraItem(item);
	}

	/**
	 * Metodo que cadastra um jogo de tabuleiro.
	 * 
	 * @param usuario
	 *            dono do jogo de tabuleiro que sera cadastrado.
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 */
	public void cadastrarJogoTabuleiro(Usuario usuario, String nomeItem, double preco) {
		validacao.itemInvalido(nomeItem, preco);
		Item item = new JogoTabuleiro(nomeItem, preco);
		itens.put(nomeItem, item);
		usuario.cadastraItem(item);
	}

	/**
	 * Metodo que cadastra um filme.
	 * 
	 * @param usuario
	 *            o dono do jogo que sera cadastrado.
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
	public void cadastraBluRayFilme(Usuario usuario, String nomeItem, double preco, int duracao, String genero,
			String classificacao, int lancamento) {
		Item item = new Filme(nomeItem, preco, duracao, classificacao, genero, lancamento);
		itens.put(nomeItem, item);
		usuario.cadastraItem(item);
	}

	/**
	 * Metodo que cadastra um show.
	 * 
	 * @param usuario
	 *            dono do item que sera cadastrado.
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
	public void cadastraBluRayShow(Usuario usuario, String nomeItem, double preco, int duracao, int faixas,
			String artista, String classificacao) {
		Item item = new Show(nomeItem, preco, duracao, classificacao, artista, faixas);
		itens.put(nomeItem, item);
		usuario.cadastraItem(item);
	}

	/**
	 * Metodo que cadastra uma serie.
	 * 
	 * @param usuario
	 *            dono do item que sera cadastrado.
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 * @param descricao
	 *            da serie.
	 * @param duracao
	 *            da serie.
	 * @param classificacao
	 *            indicativa da serie.
	 * @param genero
	 *            da serie. nulo * @param temporada da serie.
	 */
	public void cadastraBluRaySerie(Usuario usuario, String nomeItem, double preco, String descricao, int duracao,
			String classificacao, String genero, int temporada) {
		validacao.serieInvalida();
		Item item = new Serie(nomeItem, preco, duracao, classificacao, genero, temporada);
		itens.put(nomeItem, item);
		usuario.cadastraItem(item);
	}

	/**
	 * Metodo que adiciona um BluRay a uma serie.
	 * 
	 * @param usuario
	 *            dono do item que sera cadastrado.
	 * @param telefone
	 *            do usuario.
	 * @param nomeBluRayTemporada
	 *            a ser cadastrado o BluRay.
	 * @param duracao
	 *            do episodio.
	 */
	public void adicionaBluRay(Usuario usuario, String nomeBluRayTemporada, int duracao) {
		validacao.serieInvalida();
		Serie serie = (Serie) (itens.get(nomeBluRayTemporada));
		serie.adicionarBluRay(duracao);
	}

	/**
	 * Metodo que adiciona uma peca perida a um jogo de tabuleiro.
	 * 
	 * @param usuario
	 *            dono do item que sera cadastrado.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser adicionada a peca.
	 * @param nomePeca
	 *            a ser adicionada como perdida.
	 */
	public void adicionaPecaPerdida(Usuario usuario, String nomeItem, String nomePeca) {
		JogoTabuleiro jogo = (JogoTabuleiro) (itens.get(nomeItem));
		jogo.adicionaPecaPerdida(nomePeca);
		usuario.adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Metodo que retorna uma informacao de um item.
	 * 
	 * @param usuario
	 *            dono do item que tera uma informacao exibida.
	 * @param nomeItem
	 *            que se deseja pegar a informacao.
	 * @param atributo
	 *            que se deseja visualizar.
	 * @return a informacao correspondente ao atributo desejado.
	 */
	public String getInfoItem(Usuario usuario, String nomeItem, String atributo) {
		return listador.getInfoItem(usuario, nomeItem, atributo);
	}

	/**
	 * Metodo que remove um item.
	 * 
	 * @param usuario
	 *            dono do item que sera removido.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser removido.
	 */
	public void removeItem(Usuario usuario, String nomeItem) {
		itens.remove(nomeItem);
		usuario.removerItem(nomeItem);
	}

	/**
	 * Metodo que atualiza uma informacao de um item.
	 * 
	 * @param usuario
	 *            dono do item que tera um atributo atualizado.
	 * @param nomeItem
	 *            a ser alterado.
	 * @param atributo
	 *            que se deseja alterar.
	 * @param valor
	 *            para substituir o valor antigo do atributo.
	 */
	public void atualizaItem(Usuario usuario, String nomeItem, String atributo, String valor) {
		if (atributo.toUpperCase().equals("NOME")) {
			usuario.atualizaNomeItem(nomeItem, valor);
		} else if (atributo.toUpperCase().equals("PRECO")) {
			usuario.atualizaPrecoItem(nomeItem, valor);
		}
	}

	/**
	 * Metodo que retorna um ArrayList de itens.
	 * 
	 * @return um ArrayList de itens.
	 */
	private List<Item> listItens() {
		return new ArrayList<>(itens.values());
	}

	/**
	 * Metodo que lista todos os itens em ordem lexicografica.
	 * 
	 * @return a listagem de todos os itens em ordem lexicografica.
	 */
	public String listarItemOrdenadosPorNome() {
		return listador.listaItensOrdenadosPorNome(listItens());
	}

	public String listarItemOrdenadosPorValor() {
		return listador.listaItensOrdenadosPorValor(listItens());
	}

	public String pesquisaDetalhesItens(Usuario usuario, String nomeItem) {
		validacao.itemNaoEncontrado(hasItem(nomeItem));
		usuario.getItem(nomeItem);
		return itens.get(nomeItem).toString();
	}

	public String listarTop10Itens() {
		List<Item> listItens = new ArrayList<>(itens.values());
		return listador.listaTopDez(listItens);
	}

	public String listarItensNaoEmprestados(List<Item> listItens) {
		return listador.listaItensNaoEmprestados(listItens);
	}
}