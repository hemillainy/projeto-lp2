package principal;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class UserController {
	private Listador listador;
	private Validacao validacao;
	private EmprestimoController emprestimoController;
	private Map<IdUsuario, Usuario> usuarios;

	public UserController() {
		this.listador = new Listador();
		this.usuarios = new HashMap<>();
		this.validacao = new Validacao();
		this.emprestimoController = new EmprestimoController();
	}

	public EmprestimoController getEmprestimoController() {
		return this.emprestimoController;
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
		validacao.usuarioJaCadastrado(hasUsuario(id));

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
		validacao.usuarioInvalido(hasUsuario(id));
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
		validacao.usuarioInvalido(hasUsuario(id));
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
		validacao.usuarioInvalido(hasUsuario(id));
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
		validacao.usuarioInvalido(hasUsuario(id));
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
		validacao.usuarioInvalido(hasUsuario(id));
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, plataforma);
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
		validacao.usuarioInvalido(hasUsuario(id));
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco);
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
		validacao.usuarioInvalido(hasUsuario(id));
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
		validacao.usuarioInvalido(hasUsuario(id));
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
		validacao.usuarioInvalido(hasUsuario(id));
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
	private List<Item> getItens() {
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
		List<Item> inventario = getItens();
		return listador.listaItensOrdenadosPorNome(inventario);
	}

	/**
	 * Metodo que lista todos os itens em ordem crescente de valor.
	 * 
	 * @return a listagem de todos os itens em ordem crecente de valor.
	 */
	public String listarItensOrdenadosPorValor() {
		List<Item> itens = getItens();
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
	 * @return true caso o usuario ja esteja cadastrado ou false caso nao
	 *         esteja.
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
		validacao.naoPodePegarEmprestado(requerente.podePegarEmprestado());
		validacao.periodoInvalido(periodo, requerente.getPeriodo());
		
		emprestimoController.registraEmprestimo(dono, requerente, nomeItem, dataEmprestimo, periodo);
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
		IdUsuario id = new IdUsuario(nomeUsuario, telefoneUsuario);
		validacao.usuarioInvalido(hasUsuario(id));
		Usuario user = usuarios.get(id);
		return user;
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
		emprestimoController.devolveItem(dono, requerente, nomeItem, dataEmprestimo, dataDevolucao);
	}
	// ################################### US5
	// ###################################

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
		return emprestimoController.listaItensEmprestados();
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
	 * Metodo que lista os 10 itens mais emprestados.
	 * 
	 * @return a listagem dos 10 itens mais emprestados.
	 */
	public String listarTop10() {
		List<Item> inventario = getItens();
		return listador.listaTopDez(inventario);
	}
	
	/**
	 * Metodo que lista os usuarios com reputacao menor 0.
	 * @return a listagem com os usuarios com reputacao menor  que 0.
	 */
	public String listarCaloteiros() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listarCaloteiros(users);
	}
	
	public String listarTop10MelhoresUsuario() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listarTop10MelhoresUsuarios(users);
	}
	
	public String listarTop10PioresUsuario() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listarTop10PioresUsuarios(users);
	}
}