package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<IdUsuario, Usuario> usuarios;

	public UserController() {
		this.listador = new Listador();
		this.usuarios = new HashMap<>();
		this.validacao = new Validacao();
	}
	
	public Usuario getUsuario(String nome, String telefone){
		IdUsuario id = new IdUsuario(nome, telefone);
		validacao.usuarioInvalido(hasUsuario(id));
		return usuarios.get(id);
	}
	public Usuario pegarEmprestado(String nome, String telefone, int periodo){
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario usuario = usuarios.get(id);
		validacao.usuarioInvalido(hasUsuario(id));
		validacao.naoPodePegarEmprestado(usuario.podePegarEmprestado());
		validacao.periodoInvalido(periodo, usuario.getPeriodo());
		return usuario;
	}
	public List<Usuario> getUsuarios(){
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return users;
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
		if (atributo.toUpperCase().equals("EMAIL")) {
			usuarios.get(id).setEmail(valor);
		} else if (atributo.toUpperCase().equals("TELEFONE")) {
			Usuario usuario = usuarios.get(id);
			usuario.setTelefone(valor);
			setKey(nome, telefone, valor, usuario);
		}
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
	 * Metodo que lista os usuarios com reputacao menor 0.
	 * @return a listagem com os usuarios com reputacao menor  que 0.
	 */
	public String listarCaloteiros() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listarCaloteiros(users);
	}
	
	/**
	 * Metodo que lista os 10 usuarios com melhor reputacao.
	 * @return a lista com os 10 usuarios com melhor reputacao.
	 */
	public String listarTop10MelhoresUsuario() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listarTop10MelhoresUsuarios(users);
	}
	
	/**
	 * Metodo que lista os 10 usuarios com mmenor reputacao.
	 * @return a lista com os 10 usuarios com menor reputacao.
	 */
	public String listarTop10PioresUsuario() {
		List<Usuario> users = new ArrayList<>(usuarios.values());
		return listador.listarTop10PioresUsuarios(users);
	}
}