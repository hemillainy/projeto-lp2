package principal;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import principal.comparator.ComparadorNumeroEmprestimos;
import principal.comparator.ComparadorValor;
import principal.emprestimo.Emprestimo;
import principal.emprestimo.IdEmprestimo;
import principal.item.Item;
import principal.user.IdUsuario;
import principal.user.Usuario;

/**
 * Representação de um Controller.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Controller {
	private Listador listador;
	private Validacao validacao;
	private ComparadorValor comparadorValor;
	private Map<IdUsuario, Usuario> usuarios;
	private Map<IdEmprestimo, Emprestimo> emprestimos;
	private ComparadorNumeroEmprestimos comparadorNumeroEmprestimos;

	public Controller() {
		this.listador = new Listador();
		this.usuarios = new HashMap<>();
		this.validacao = new Validacao();
		this.emprestimos = new HashMap<>();
		this.comparadorValor = new ComparadorValor();
		this.comparadorNumeroEmprestimos = new ComparadorNumeroEmprestimos();
	}

	/**
	 * Metodo que cadastra um usuario no sistema.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param email
	 *            do usuario.
	 */
	public void cadastraUsuario(String nome, String telefone, String email) {
		validacao.dadoUsuarioInvalido(nome, telefone, email);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (hasUsuario(id)) {
			validacao.usuarioJaCadastrado();
		}
		Usuario usuario = new Usuario(nome, telefone, email);
		usuarios.put(id, usuario);
	}

	/**
	 * Metodo que remove um usuario do sistema.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 */
	public void removeUsuario(String nome, String telefone) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		usuarios.remove(id);
	}

	/**
	 * Metodo que retorna um atributo de um usuario.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param atributo
	 *            que se deseja.
	 * @return o atributo desejado.
	 */
	public String getInfoUsuario(String nome, String telefone, String atributo) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		Usuario usuario = usuarios.get(id);
		return listador.getInfoUsuario(usuario, atributo);
	}

	/**
	 * Metodo que atualiza um atributo de um usuario.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param atributo
	 *            a ser alterado.
	 * @param valor
	 *            para substituir o valor antigo do atributo.
	 */
	public void atualizaUsuario(String nome, String telefone, String atributo, String valor) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		if (atributo.equals("Email")) {
			usuarios.get(id).setEmail(valor);
		} else if (atributo.equals("Telefone")) {
			Usuario usuario = usuarios.get(id);
			usuario.setTelefone(valor);
			setKey(nome, telefone, valor, usuario);
		}
	}

	/**
	 * Metodo que adiciona um BluRay a uma serie.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeBluRayTemporada
	 *            a ser cadastrado o BluRay.
	 * @param duracao
	 *            do episodio.
	 */
	public void adicionarBluRay(String nome, String telefone, String nomeBluRayTemporada, int duracao) {
		IdUsuario id = new IdUsuario(nome, telefone);
		usuarios.get(id).adicionaBluRay(nomeBluRayTemporada, duracao);
	}

	/**
	 * Metodo que adiciona uma peca perida a um jogo de tabuleiro.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser adicionada a peca.
	 * @param nomePeca
	 *            a ser adicionada como perdida.
	 */
	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		usuarios.get(id).adicionarPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Metodo que cadastra um jogo eletronico.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param do
	 *            jogo eletronico.
	 * @param plataforma
	 *            do jogo eletronico.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		validacao.itemInvalido(nomeItem, preco, plataforma);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, plataforma);
		us.addReputacao(preco, 0.05);
	}

	/**
	 * Metodo que cadastra um jogo de tabuleiro.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param preco
	 *            do item.
	 */
	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		validacao.itemInvalido(nomeItem, preco);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco);
		us.addReputacao(preco, 0.05);
	}

	/**
	 * Metodo que cadastra um filme.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
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
	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int lancamento) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, duracao, genero, classificacao, lancamento);
		us.addReputacao(preco, 0.05);
	}

	/**
	 * Metodo que cadastra um show.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
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
	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario us = usuarios.get(id);
		us.cadastraBluRayShow(nomeItem, preco, duracao, classificacao, artista, faixas);
		us.addReputacao(preco, 0.05);
	}

	/**
	 * Metodo que cadastra uma serie.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
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
	 *            da serie.
	 * @param temporada
	 *            da serie.
	 */
	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
		us.addReputacao(preco, 0.05);
	}

	/**
	 * Metodo que retorna a representacao de um item.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser pesquisado.
	 * @return a representacao do item.
	 */
	public String pesquisaDetalhesItem(String nome, String telefone, String item) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		return usuarios.get(id).exibeDetalhesItem(item);
	}

	/**
	 * Metodo que retorna uma informacao de um item.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            que se deseja pegar a informacao.
	 * @param atributo
	 *            que se deseja visualizar.
	 * @return a informacao correspondente ao atributo desejado.
	 */
	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario usuario = usuarios.get(id);
		return listador.getInfoItem(usuario, nomeItem, atributo);
	}

	/**
	 * Metodo que remove um item.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser removido.
	 */
	public void removerItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		usuarios.get(id).removerItem(nomeItem);

	}

	/**
	 * Metodo que atualiza uma informacao de um item.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser alterado.
	 * @param atributo
	 *            que se deseja alterar.
	 * @param valor
	 *            para substituir o valor antigo do atributo.
	 */
	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		if (atributo.equals("Nome")) {
			usuarios.get(id).atualizaNomeItem(nomeItem, valor);
		} else if (atributo.equals("Preco")) {
			usuarios.get(id).atualizaPrecoItem(nomeItem, valor);
		}
	}

	/**
	 * Pega todos os itens de todos os usuarios.
	 * 
	 * @return set com todos os itens.
	 */
	private List<Item> pegaTodosOsItens() {
		Set<Item> it = new HashSet<>();
		for (Usuario us : usuarios.values()) {
			it.addAll(us.getItens());
		}
		return new ArrayList<>(it);
	}

	/**
	 * Metodo que lista todos os itens em ordem lexicografica.
	 * 
	 * @return a listagem de todos os itens em ordem lexicografica.
	 */
	public String listarItensOrdenadosPorNome() {
		List<Item> inventario = pegaTodosOsItens();
		Collections.sort(inventario);
		return listador.listaItensOrdenadosPorNome(inventario);
	}

	/**
	 * Metodo que lista todos os itens em ordem crescente de valor.
	 * 
	 * @return a listagem de todos os itens em ordem crecente de valor.
	 */
	public String listarItensOrdenadosPorValor() {
		List<Item> itens = pegaTodosOsItens();
		Collections.sort(itens, comparadorValor);
		return listador.listaItensOrdenadosPorValor(itens);
	}

	/**
	 * Remove um usuario do mapa para adicioná-lo novamento com uma nova key.
	 * 
	 * @param nome
	 *            nome do usuario.
	 * @param telefone
	 *            telefone do usuario.
	 * @param valor
	 *            novo telefone do ususario.
	 * @param usuario
	 *            usuario.
	 */
	private void setKey(String nome, String telefone, String valor, Usuario usuario) {
		IdUsuario id = new IdUsuario(nome, telefone);
		usuarios.remove(id);
		IdUsuario novoId = new IdUsuario(nome, valor);
		usuarios.put(novoId, usuario);
	}

	/**
	 * Verifica se o usuario ja esta cadastrado.
	 * 
	 * @param id
	 *            id do usuario no mapa de usuarios.
	 * @return true caso o usuario ja esteja cadastrado ou false caso nao esteja.
	 */
	private boolean hasUsuario(IdUsuario id) {
		if (usuarios.containsKey(id)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que realiza um emprestimo.
	 * 
	 * @param nomeDono
	 *            do item.
	 * @param telefoneDono
	 *            do item.
	 * @param nomeRequerente
	 *            do emprestimo.
	 * @param telefoneRequerente
	 *            do emprestimo.
	 * @param nomeItem
	 *            a ser emprestado.
	 * @param dataEmprestimo
	 *            que houve o emprestimo.
	 * @param periodo
	 *            de emprestimo.
	 * @throws ParseException
	 */
	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

		Usuario dono = criaUsuario(nomeDono, telefoneDono);
		Usuario requerente = criaUsuario(nomeRequerente, telefoneRequerente);

		validacao.validaItemEmprestimo(dono.getItem(nomeItem));
		Item itemEmprestar = dono.getItem(nomeItem);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataEmprestimo, dtf);

		if (itemEmprestar.verificaEmprestado()) {
			validacao.ItemJaEmprestado();
		}

		alocarEmprestimos(dono, requerente, itemEmprestar, data, periodo);
		dono.addReputacao(itemEmprestar.getPreco(), 0.1);
		itemEmprestar.addNumeroEmprestimo();

	}

	/**
	 * Pega um usuario do mapa a partir do nome e telefone.
	 * 
	 * @param nomeUsuario
	 *            o nome do usuario.
	 * @param telefoneUsuario
	 *            o telefone do usuario.
	 * @return o Usuario.
	 */
	private Usuario criaUsuario(String nomeUsuario, String telefoneUsuario) {
		IdUsuario idUser = new IdUsuario(nomeUsuario, telefoneUsuario);
		if (!hasUsuario(idUser)) {
			validacao.usuarioInvalido();
		}
		Usuario user = usuarios.get(idUser);
		return user;
	}

	/**
	 * Cria um emprestimo e um idEmprestimo. Adiciona o emprestimo no map de
	 * emprestimos e passa-o para o dono e o requerente.
	 * 
	 * @param dono
	 *            dono do item emprestado.
	 * @param requerente
	 *            usuario que ira pegar o item emprestado.
	 * @param itemEmprestar
	 *            item que sera emprestado.
	 * @param data
	 *            data em que foi realizado o emprestimo.
	 * @param periodo
	 *            periodo em que o requerente deve ficar com o item.
	 */
	private void alocarEmprestimos(Usuario dono, Usuario requerente, Item itemEmprestar, LocalDate data, int periodo) {
		Emprestimo e = new Emprestimo(dono, requerente, itemEmprestar, data, periodo);
		IdEmprestimo ie = new IdEmprestimo(dono, requerente, itemEmprestar, data);
		emprestimos.put(ie, e);
		dono.addEmprestimo(e);
		requerente.addEmprestimo(e);
		itemEmprestar.setStaus();
	}

	/**
	 * Metodo que devolve um item.
	 * 
	 * @param nomeDono
	 *            do item.
	 * @param telefoneDono
	 *            do item.
	 * @param nomeRequerente
	 *            do emprestimo.
	 * @param telefoneRequerente
	 *            do emprestimo.
	 * @param nomeItem
	 *            a ser devolvido.
	 * @param dataEmprestimo
	 *            que aconteceu o emprestimo.
	 * @param dataDevolucao
	 *            do item.
	 * @throws ParseException
	 */
	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
		String nomeItem, String dataEmprestimo, String dataDevolucao) {

		Usuario dono = criaUsuario(nomeDono, telefoneDono);
		Usuario requerente = criaUsuario(nomeRequerente, telefoneRequerente);
		validacao.validaItemEmprestimo(dono.getItem(nomeItem));
		Item itemDevolver = dono.getItem(nomeItem);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataE = LocalDate.parse(dataEmprestimo, dtf);
		LocalDate dataD = LocalDate.parse(dataDevolucao, dtf);

		IdEmprestimo ie = new IdEmprestimo(dono, requerente, itemDevolver, dataE);
		if (!emprestimos.containsKey(ie)) {
			validacao.emprestimoNaoEncontrado();
		}
		emprestimos.get(ie).devolverItem(dataD);
		itemDevolver.setStaus();
		if (emprestimoAtrasado(dataE, dataD) <= 7) {
			requerente.addReputacao(itemDevolver.getPreco(), 0.05);
		}
		else {
			double taxa = (emprestimoAtrasado(dataE, dataD) - 7) / 100.00;
			requerente.addReputacao(-itemDevolver.getPreco(), taxa);
		}
		
	}
	
	/**
	 * Verifica se um emprestimo esta atrasado.
	 * @param dataEmprestimo em que foi emprestado o item.
	 * @param dataDevolucao que foi devolvido o item.
	 * @return o periodo que o requerente ficou com o item.
	 */
	private long emprestimoAtrasado(LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		long periodo = dataEmprestimo.until(dataDevolucao, ChronoUnit.DAYS);
		return periodo;
	}
	// ################################### US5 ###################################

	/**
	 * Metodo que lista todos os itens que um usuario emprestou.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @return a lista com os emprestimos feitos pelo usuario.
	 */
	public String listarEmprestimosUsuarioEmprestando(String nome, String telefone) {
		Usuario dono = criaUsuario(nome, telefone);
		return dono.listarEmprestimosUsuarioEmprestando(dono);
	}

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @return a listagem dos itens nao cadastrados.
	 */
	public String listarItensNaoEmprestados() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listaItensNaoEmprestados(users);
	}

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @return a listagem com os itens emprestados.
	 */
	public String listarItensEmprestados() {
		List<Emprestimo> emp = new ArrayList<>(emprestimos.values());
		return listador.listaItensEmprestados(emp);
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
	public String listarEmprestimosUsuarioPegandoEmprestado(String nome, String telefone) {
		Usuario requerente = criaUsuario(nome, telefone);
		return listador.listaEmprestimosUsuarioPegandoEmprestado(requerente);
	}

	/**
	 * Metodo que lista os associados a um item.
	 * 
	 * @param nome
	 *            do item.
	 * @return a lista com todos os emprestimos relacionados a um item.
	 */
	public String listarEmprestimosItem(String nome) {
		return listador.listaEmprestimosItem(emprestimos.values(), nome);
	}

	/**
	 * Metodo que lista os 10 itens mais emprestados.
	 * 
	 * @return a listagem dos 10 itens mais emprestados.
	 */
	public String listarTop10() {
		List<Item> inventario = pegaTodosOsItens();
		Collections.sort(inventario, comparadorNumeroEmprestimos);
		return listador.listaTopDez(inventario);
	}
}
