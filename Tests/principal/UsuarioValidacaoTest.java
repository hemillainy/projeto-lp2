package principal;

import org.junit.Test;

import principal.user.UsuarioValidacao;

/**
 * Testes da Classe UsuarioValidacao.
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class UsuarioValidacaoTest {

	UsuarioValidacao uv = new UsuarioValidacao();

	/**
	 * Esperada a excecao na chamada do metodo pois o usuario nao esta
	 * cadastrado no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioInvalido() {
		uv.usuarioInvalido(false);
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o usuario ja esta cadastrado
	 * no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUsuarioJaCadastrado() {
		uv.usuarioJaCadastrado(true);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de nome nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoNomeNulo() {
		uv.dadoUsuarioInvalido(null, "1234-5678", "geovane@email.com");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoNomeVazio() {
		uv.dadoUsuarioInvalido("", "1234-5678", "geovane@email.com");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro de nome composto
	 * apenas de espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoNomeEspacos() {
		uv.dadoUsuarioInvalido("   ", "1234-5678", "geovane@email.com");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro telefone nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoTelefoneNulo() {
		uv.dadoUsuarioInvalido("Geovane", null, "geovane@email.com");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro telefone vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoTelefoneVazio() {
		uv.dadoUsuarioInvalido("Geovane", "", "geovane@email.com");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro telefone composto
	 * apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoTelefoneEspacos() {
		uv.dadoUsuarioInvalido("Geovane", "   ", "geovane@email.com");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro email nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoEmailNulo() {
		uv.dadoUsuarioInvalido("Geovane", "1234-5678", null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro email vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoEmailVazio() {
		uv.dadoUsuarioInvalido("Geovane", "1234-5678", "");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro email composto
	 * apenas de espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDadoUsuarioInvalidoEmailEspacos() {
		uv.dadoUsuarioInvalido("Geovane", "1234-5678", "   ");
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o usuario que se esta
	 * tentando atualizar dados nao esta cadastrado no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioInvalido() {
		uv.atualizaUsuario(false, "Nome", "Geovane");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro atributo nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioAtributoNulo() {
		uv.atualizaUsuario(true, null, "Geovane");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro atributo vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioAtribuloVazio() {
		uv.atualizaUsuario(true, "", "Geovane");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro atributo composto
	 * apenas de espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioAtributoEspaco() {
		uv.atualizaUsuario(true, "   ", "Geovane");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro novo valor nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioValorNulo() {
		uv.atualizaUsuario(true, "Nome", null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro novo valor vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioValorVazio() {
		uv.atualizaUsuario(true, "Nome", "");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro novo valor composto
	 * apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioValorEspacos() {
		uv.atualizaUsuario(true, "Nome", "   ");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro atributo nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoNulo() {
		uv.atributoInvalido(null);
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro atributo vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoVazio() {
		uv.atributoInvalido("");
	}

	/**
	 * Esperada a excecao na chamada do metodo com parametro atributo composto
	 * apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtributoInvalidoEspacos() {
		uv.atributoInvalido("   ");
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o usuario nao tem permissao
	 * para pegar itens emprestado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNaoPodePegarEmprestado() {
		uv.naoPodePegarEmprestado(false);
	}

	/**
	 * Esperada a excecao na chamada do metodo pois o usuario esta solicitando
	 * um periodo de emprestimo maior que a sua categoria de fidelidade permite.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPeriodoInvalido() {
		uv.periodoInvalido(7, 5);
	}

}
