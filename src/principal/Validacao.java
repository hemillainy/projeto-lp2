package principal;

import principal.item.Item;

/**
 * Classe responsavel pela verificacao de dados invalidos. Quando for passado um
 * dado invalido sera lancado um IllegalArgumentException.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Validacao {
	
	/**
	 * Excecao lancada quando for passado um usuario que nao esta cadastrado no
	 * sistema.
	 */
	public void usuarioInvalido(boolean hasUsuario) {
		if (!hasUsuario) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/**
	 * Excecao lancada quando tentar cadastrar um usuario que ja esta cadastrado.
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
	 * Excecao lancada quando for solicitado algo sobre um item que nao foi
	 * cadastrado.
	 */
	public void itemNaoEncontrado(boolean hasItem) {
		if (!hasItem) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
	}

	/**
	 * Verifica os paramentros passados para o cadastro de um item.
	 * 
	 * @param nomeItem
	 *            nome do item.
	 * @param preco
	 *            preco do item.
	 * @param plataforma
	 *            plataforma do item.
	 */
	public void itemInvalido(String nomeItem, double preco, String plataforma) {
		if (nomeItem == null || nomeItem.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome invalido");
		}
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		if (plataforma == null || plataforma.trim().isEmpty()) {
			throw new IllegalArgumentException("Plataforma invalida");
		}
	}

	public void itemInvalido(String nomeItem, double preco) {
		if (nomeItem == null || nomeItem.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome invalido");
		}
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	/**
	 * Excecao lancada quando tentarem fazer um emprestimo de um item que ja esta
	 * emprestado.
	 */
	public void ItemJaEmprestado(boolean itemJaEmprestado) {
		if (itemJaEmprestado) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	/**
	 * Excecao lancada quando for solicitado um emprestimo que nao foi cadastrado.
	 */
	public void emprestimoNaoEncontrado(boolean contemEmprestimo) {
		if (!contemEmprestimo) {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}
	}

	public void validaUsuariosEmprestimo(boolean containsKey, boolean containsKey2) {
		if (!containsKey || !containsKey2) {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

	/**
	 * Verifica nulidade de um item. Se o item for nulo uma excecao e lancada.
	 * 
	 * @param item
	 *            o item a ser verificado.
	 */
	public void validaItemEmprestimo(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item nao encontrado");
		}

	}

	/**
	 * Lanca excecao se o usuario nao pode pegar um item emprestado .
	 */
	public void naoPodePegarEmprestado(boolean podePegarEmprestado) {
		if (!podePegarEmprestado) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}
	}

	/**
	 * Excecao lancada quando um emprestimos com periodo alem do permitido para o
	 * requerente eh solicitado.
	 */
	public void periodoInvalido(int periodo, int periodoUser) {
		if (periodo > periodoUser) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
	}

}
