package principal;

import java.util.Arrays;
import java.util.List;

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
	 * Excecao lancada quando tentar cadastrar um usuario que ja esta
	 * cadastrado.
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
	 * Verifica se um atributo de pesquisa eh valido.
	 * @param atributo o atributo a ser verificado. 
	 */
	public void atributoInvalido(String atributo) {
		if (atributo == null || atributo.trim().isEmpty()) {
			throw new IllegalArgumentException("Atributo invalido");
		}
	}

	/**
	 * Verifica os paramentros passados para o cadastro de um item.
	 * 
	 * @param nomeItem
	 *            nome do item.
	 * @param preco
	 *            preco do item.
	 * @param enumerate
	 *            plataforma do item.
	 */
	public void itemInvalido(String nomeItem, double preco) {
		if (nomeItem == null || nomeItem.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome invalido");
		}
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
	}

	public void eletronicoInvalido(String nome, double preco, String plataforma) {
		itemInvalido(nome, preco);
		plataformaInvalida(plataforma);
	}
	
	/**
	 * Verifica os paramentros passados para o cadastro de um jogo de tabulerio.
	 * 
	 * @param nome
	 *            nome do jogo.
	 * @param preco
	 *            preco do jogo.
	 */
	public void tabulerioInvalido(String nome, double preco) {
		itemInvalido(nome, preco);
	}
	
	/**
	 * Verifica os paramentros passados para o cadastro de um bluray de serie.
	 * 
	 * @param nome
	 *            nome da serie.
	 * @param preco
	 *            preco do bluray.
	 * 
	 * @param classificacao
	 *            a classificacao da serie.
	 * 
	 * @param genero
	 *            o genero da serie.
	 * @param temporada
	 *            o numero da temporada da serie.
	 */
	public void serieInvalida(String nome, double valor, int duracao, String classificacao, String genero,
			int temporada) {
		bluRayInvalido(nome, valor, duracao, classificacao);
		generoInvalido(genero);
		dadoInvalido("Temporada", temporada);
	}
	
	/**
	 * Verifica os paramentros passados para o cadastro de um bluray de filme.
	 * 
	 * @param nome
	 *            nome do filme.
	 * @param preco
	 *            preco do bluray.
	 * 
	 * @param classificacao
	 *            a classificacao do filme.
	 * 
	 * @param genero
	 *            o genero do filme.
	 * @param lancamento
	 *            o ano de lancamento do filme.
	 * 
	 */
	public void filmeInvalido(String nome, double valor, int duracao, String classificacao, String genero,
			int lancamento) {
		bluRayInvalido(nome, valor, duracao, classificacao);
		generoInvalido(genero);
		dadoInvalido("Lancamento", lancamento);
	}

	/**
	 * Verifica os paramentros passados para o cadastro de um bluray de show.
	 * 
	 * @param nome
	 *            nome do show.
	 * @param preco
	 *            preco do bluray.
	 * 
	 * @param classificacao
	 *            a classificacao do show.
	 * 
	 * @param artista
	 *            o nome do artista.
	 * 
	 * @param faixas
	 *            o numero de faixas do show.
	 */
	public void showInvalido(String nome, double valor, int duracao, String classificacao, String artista, int faixas) {
		bluRayInvalido(nome, valor, duracao, classificacao);

		if (artista == null || artista.trim().isEmpty()) {
			throw new IllegalArgumentException("Artista invalido");
		}
		dadoInvalido("Faixas", faixas);
	}

	/**
	 * Verifica se a plataforma de um jogo eletronico eh valida.
	 * 
	 * @param plataforma
	 *            a plataforma do jogo eletronico.
	 */
	private void plataformaInvalida(String plataforma) {
		List<String> plataformas = Arrays.asList("PC", "MAC", "PS3", "PS4", "XBOX360", "XBOX_ONE", "NINTENDO_3DS", "OUTRO");
		
		if (plataforma == null || plataforma.trim().isEmpty()) {
			throw new IllegalArgumentException("Plataforma invalida");
		}
		if (!plataformas.contains(plataforma)) {
			throw new IllegalArgumentException("Plataforma inexistente");
		}
	}

	
	/**
	 * Verifica se a classificacao de um bluray eh valida.
	 * 
	 * @param classificacao
	 *            a classificacao do bluray.
	 */
	private void classificacaoInvalida(String classificacao) {
		List<String> classificacoes = Arrays.asList("LIVRE", "DEZ_ANOS", "DOZE_ANOS", "QUATORZE_ANOS", "DEZESSEIS_ANOS",
				"DEZOITO_ANOS");

		if (classificacao == null || classificacao.trim().isEmpty()) {
			throw new IllegalArgumentException("Classificacao invalida");
		}
		if (!classificacoes.contains(classificacao)) {
			throw new IllegalArgumentException("Classificacao inexistente");
		}
	}
	
	/**
	 * Verifica se o genero de um filme ou serie eh valido.
	 * 
	 * @param genero
	 *            o genero do filme ou serio.
	 */
	private void generoInvalido(String genero) {
		List<String> generos = Arrays.asList("ACAO", "ANIMACAO", "AVENTURA", "COMEDIA", "DOCUMENTARIO", "DRAMA",
				"EROTICO", "FAROESTE", "FICCAO", "MUSICAL", "POLICIAL", "ROMANCE", "SUSPENSE", "TERROR",
				"OUTRO");

		if (genero == null || genero.trim().isEmpty()) {
			throw new IllegalArgumentException("Genero invalido");
		}
		if (!generos.contains(genero)) {
			throw new IllegalArgumentException("Genero inexistente");
		}
	}

	/**
	 * Auxiliar na verificao do dados de um bluray.
	 * 
	 * @param nome
	 *            nome do bluray.
	 * @param valor
	 *            valor do bluray.
	 * 
	 * @param classificacao
	 *            a classificacao do bluray.
	 */
	private void bluRayInvalido(String nome, double valor, int duracao, String classificacao) {
		itemInvalido(nome, valor);
		classificacaoInvalida(classificacao);
	}
	
	/**
	 * Auxiliar na verificao de dado do cadastro de itens. o dado pode ser a
	 * quantidade de faixas, a temporada ou o ano de lancamento.
	 * 
	 * @param msg
	 *            identifica o tipo do dado.
	 * 
	 * @param dado
	 *            o dado a ser verificado.
	 */
	private void dadoInvalido(String msg, int dado) {
		if (dado <= 0) {
			throw new IllegalArgumentException(msg + " invalido");
		}
	}

	/**
	 * Verifica se uma peca perdida eh valida.
	 * 
	 * @param peca
	 *            a peca a ser verificada.
	 */
	public void pecaInvalida(boolean hasItem, String peca) {
		if (!hasItem) {
			throw new IllegalArgumentException("Jogo nao Cadastrado");
		}
		if (peca == null || peca.trim().isEmpty()) {
			throw new IllegalArgumentException("Peca invalida");
		}
	}

	/**
	 * Excecao lancada quando tentarem fazer um emprestimo de um item que ja
	 * esta emprestado.
	 */
	public void ItemJaEmprestado(boolean itemJaEmprestado) {
		if (itemJaEmprestado) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}
	}

	/**
	 * Excecao lancada quando for solicitado um emprestimo que nao foi
	 * cadastrado.
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
	 * Excecao lancada quando um emprestimos com periodo alem do permitido para
	 * o requerente eh solicitado.
	 */
	public void periodoInvalido(int periodo, int periodoUser) {
		if (periodo > periodoUser) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}
	}

	public void addTemporadaInvalida(boolean containsKey, int duracao) {
		if (!containsKey) {
			throw new IllegalArgumentException("BluRay nao cadastrado");
		}
		
		if (duracao <= 0) {
			throw new IllegalArgumentException("Duracao invalida");
		}
		
	}

	public void valorInvalido(String valor) {
		Double v = Double.parseDouble(valor);
		if (valor == null || valor.trim().isEmpty() || v < 0) {
			throw new IllegalArgumentException("Valor invalido");
		}		
	}

}
