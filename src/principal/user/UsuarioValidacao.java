package principal.user;

public class UsuarioValidacao {

	/**
	 * Excecao lancada quando for passado um usuario que nao esta cadastrado no
	 * sistema.
	 * 
	 * @param hasUsuario
	 *            identifica se o usuario existe no sistema.
	 */
	public void usuarioInvalido(boolean hasUsuario) {
		if (!hasUsuario) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/**
	 * Excecao lancada quando tentar cadastrar um usuario que ja esta
	 * cadastrado.
	 * 
	 * @param hasUsuario
	 *            identifica se o usuario ja esta cadastrado no sistema.
	 */
	public void usuarioJaCadastrado(boolean hasUsuario) {
		if (hasUsuario) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}
	}

	/**
	 * Verifica os parametros passados para o cadastro de um usuario.
	 * 
	 * @param nome
	 *            nome do usuario.
	 * @param telefone
	 *            telefone do usuario.
	 * @param email
	 *            email do usuario.
	 */
	public void dadoUsuarioInvalido(String nome, String telefone, String email) {
		if (nome == null || telefone == null || email == null || nome.trim().isEmpty() || telefone.trim().isEmpty()
				|| email.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Não foi possivel realizar o cadastro: nome, celular ou email inválido!");
		}
	}

	/**
	 * Veifica os parametros passados para a atualizacao de um usuario.
	 * 
	 * @param hasUsuario
	 *            identifica se o usuario existe no sistema.
	 * @param atributo
	 *            o atributo a ser verificado.
	 * @param valor
	 *            o novo valor do atributo.
	 */
	public void atualizaUsuario(boolean hasUsuario, String atributo, String valor) {
		usuarioInvalido(hasUsuario);
		atributoInvalido(atributo);
		atributoInvalido(valor);
	}

	/**
	 * Verifica se um atributo de pesquisa eh valido.
	 * 
	 * @param atributo
	 *            o atributo a ser verificado.
	 */
	public void atributoInvalido(String atributo) {
		if (atributo == null || atributo.trim().isEmpty()) {
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Lanca excecao se o usuario nao pode pegar um item emprestado.
	 * 
	 * @param podePegarEmprestado
	 *            identifica se o usuario pode ou nao pegar itens emprestado.
	 */
	public void naoPodePegarEmprestado(boolean podePegarEmprestado) {
		if (!podePegarEmprestado) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}
	}

	/**
	 * Excecao lancada quando um emprestimos com periodo alem do permitido para
	 * o requerente eh solicitado.
	 * 
	 * @param periodo
	 *            o periodo solicitado.
	 * @param periodoUser
	 *            o periodo que o usuario pode pegar emprestado.
	 */
	public void periodoInvalido(int periodo, int periodoUser) {
		if (periodo > periodoUser) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
	}
}
