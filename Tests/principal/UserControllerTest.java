package principal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import principal.item.blurays.Serie;
import principal.item.jogos.JogoEletronico;
import principal.item.jogos.JogoTabuleiro;
import principal.user.UserController;
import principal.user.Usuario;

/**
 * Testes da Classe UserController
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class UserControllerTest {

	UserController uc = new UserController();

	/**
	 * Inicializa o cadastro de usuarios para uso de testes.
	 */
	@Before
	public void inicializa() {
		uc.cadastraUsuario("Geovane", "1234-5678", "geovane@email.com");
		uc.cadastraUsuario("Cassio", "4321-5678", "cassio@email.com");
		uc.cadastraUsuario("Hemillainy", "5678-5678", "hemillainy@email.com");
	}

	/**
	 * Testa getUsuario para um usuario valido.
	 */
	@Test
	public void testGetUsuario() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geovane@email.com");
		assertEquals(us, uc.getUsuario("Geovane", "1234-5678"));
	}

	/**
	 * Testa getUsuario para um usuario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNaoCadastrado() {
		uc.getUsuario("Geo", "1234-5678");
	}

	/**
	 * Testa getUsuario para um usuario com nome nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNomeNulo() {
		uc.getUsuario(null, "1234-5678");
	}

	/**
	 * Testa getUsuario para um usuario como nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNomeVazio() {
		uc.getUsuario("", "1234-5678");
	}

	/**
	 * Testa getUsuario para um usuario com nome composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNomeEspacos() {
		uc.getUsuario("   ", "1234-5678");
	}

	/**
	 * Testa getUsuario para um usuario com telefone nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioTelefoneNulo() {
		uc.getUsuario("Geovane", null);
	}

	/**
	 * Testa getUsuario para um usuario com telefone vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioTelefoneVazio() {
		uc.getUsuario("Geovane", "");
	}

	/**
	 * Testa getUsuario para um usuario com telefone composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioTelefoneEspacos() {
		uc.getUsuario("Geovane", "   ");
	}

	/**
	 * Testa o pegarEmprestado para um usuario cadastrado.
	 */
	@Test
	public void testPegarEmprestado() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geovane@email.com");
		assertEquals(us, uc.pegarEmprestado("Geovane", "1234-5678", 5));
	}

	/**
	 * Testa o pegarEmprestado para um usuario nao cadastrado.
	 */
	@Test
	public void testPegarEmprestadoUsuarioinexistente() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geovane@email.com");
		assertEquals(us, uc.pegarEmprestado("Geovane", "1234-5678", 5));
	}

	/**
	 * Testa o pegarEmprestado para um usuario que nao tem permissao para pegar
	 * emprestimos de um item.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNaoPodePegarEmprestado() {
		uc.getUsuario("Geovane", "1234-5678").addReputacao(-200, 0.01);
		uc.pegarEmprestado("Geovane", "1234-5678", 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario com nome nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNomeNulo() {
		uc.pegarEmprestado(null, "1234-5678", 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNomeVazio() {
		uc.pegarEmprestado("", "1234-5678", 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario com nome composto apenas de espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNomeEspacos() {
		uc.pegarEmprestado("   ", "1234-5678", 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario com telefone nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoTelefoneNulo() {
		uc.pegarEmprestado("Geovane", null, 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario com telefone vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoTelefoneVazio() {
		uc.pegarEmprestado("Geovane", "", 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario com telefone composto apenas de
	 * espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoTelefoneEspacos() {
		uc.pegarEmprestado("Geovane", "   ", 5);
	}

	/**
	 * Testa o pegarEmprestado para um usuario noob que tenta pegar mais que o
	 * periodo permitido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNoobForaDePeriodo() {
		uc.getUsuario("Geovane", "1234-5678").cadastraItem(new JogoTabuleiro("Chess", 100));
		;
		uc.pegarEmprestado("Geovane", "1234-5678", 8);
	}

	/**
	 * Testa o pegarEmprestado para um usuario bomAmigo que tenta pegar mais que o
	 * periodo permitido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoBomAmigoForaDePeriodo() {
		uc.getUsuario("Geovane", "1234-5678").cadastraItem(new JogoTabuleiro("Chess", 100000));
		uc.pegarEmprestado("Geovane", "1234-5678", 15);
	}

	/**
	 * Testa o metodo getUsuarios pelo tamanho do array dos usuarios cadastrados.
	 */
	@Test
	public void testGetUsuarios() {
		assertEquals(3, uc.getUsuarios().size());
		uc.cadastraUsuario("Fulannin", "000", "naotem");
		assertEquals(4, uc.getUsuarios().size());
	}

	/**
	 * Testa o metodo de casdastra usuario verificando pelo metodo getUsuario e pelo
	 * tamnaho do array de usuarios que é alterado apos o cadastro.
	 */
	@Test
	public void testCadastraUsuario() {
		uc.cadastraUsuario("GEEEO", "123", "123@email.com");
		assertEquals(new Usuario("GEEEO", "123", "123@email.com"), uc.getUsuario("GEEEO", "123"));
		assertEquals(4, uc.getUsuarios().size());
	}

	/**
	 * Testa o metodo removeUsuario. Apos a remocao tenta pegar o usuario que nao
	 * existe mais no sistem, logo uma excecao eh lancada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveUsuario() {
		uc.removeUsuario("Geovane", "1234-5678");
		uc.getUsuario("Geovane", "1234-5678");
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario valido.
	 */
	@Test
	public void testGetInfoUsuario() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "1234-5678", "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario com nome nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioNomeNulo() {
		assertEquals("geovane@email.com", uc.getInfoUsuario(null, "1234-5678", "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioNomeVazio() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("", "1234-5678", "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario com nome composto apenas por
	 * espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioNomeEspacos() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("   ", "1234-5678", "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario com telefone nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioTelefoneNulo() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", null, "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario com telefone vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioTelefoneVazio() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "", "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario para um usuario com telefone composto apenas
	 * por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioTelefoneEspaco() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "    ", "email"));
	}

	/**
	 * Testa o metodo GetInfo usuario com atributo nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioAtributoNulo() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "1234-5678", null));
	}

	/**
	 * Testa o metodo GetInfo usuario com atributo vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioAtributoVazio() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "1234-5678", ""));
	}

	/**
	 * Testa o metodo GetInfo usuario com atributo composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoUsuarioAtributoEspcaos() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "1234-5678", "   "));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar email.
	 */
	@Test
	public void testAtualizaUsuarioEmail() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geo@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "email", "geo@email.com");
		assertEquals(us, uc.getUsuario("Geovane", "1234-5678"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar telefone.
	 */
	@Test
	public void testAtualizaUsuarioTelfone() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com nome nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioNomeNulo() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario(null, "1234-5678", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioNomeVazio() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("", "1234-5678", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com nome composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioNomeEspacos() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("   ", "1234-5678", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com telefone nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioTelfoneNulo() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", null, "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com telefone vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioTelfoneVazio() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario como telefone composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioTelfoneEspacos() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "   ", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com atributo nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioAtributoNulo() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", null, "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com atributo vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioAtributoVazio() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario com atributo composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioAtributoEspacos() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "   ", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar email com nvo email nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioEmailNulo() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Email", null);
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar email com novo email vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioEmailVazio() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Email", "");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar telefone com valor de novo
	 * email composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioEmailEspacos() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Email", "   ");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar telefone com valor de novo
	 * telefone nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioNovoTelefoneNulo() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Telefone", null);
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar telefone com valor de novo
	 * telefone vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioNovoTelefoneVazio() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Telefone", "");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de atualizaUsuario para atualizar telefone com valor de novo
	 * telefone composto apenas por espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaUsuarioNovoTelefoneEspacos() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Telefone", "   ");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	/**
	 * Testa o metodo de listar os caloteiros.
	 */
	@Test
	public void testListarCaloteirosComCaloteiro() {
		uc.getUsuario("Hemillainy", "5678-5678").addReputacao(-1000, 0.01);
		assertEquals("Lista de usuarios com reputacao negativa: Hemillainy, hemillainy@email.com, 5678-5678|",
				uc.listarCaloteiros());
	}

	/**
	 * Testa o metodo de listar os caloteiros quando nao tem caloteiros no sistema.
	 */
	@Test
	public void testListarCaloteirosSemCaloteiro() {
		assertEquals("Lista de usuarios com reputacao negativa: ", uc.listarCaloteiros());
	}

	/**
	 * Testa o metodo que lista os top 10 melhores usuarios.
	 */
	@Test
	public void testListarTop10MelhoresUsuario() {
		uc.getUsuario("Geovane", "1234-5678").cadastraItem(new JogoEletronico("Naruto", 200, "PC"));
		uc.getUsuario("Cassio", "4321-5678").cadastraItem(new JogoTabuleiro("Chess", 10000));
		uc.getUsuario("Hemillainy", "5678-5678").cadastraItem(new Serie("GOT", 180, 220, "DEZOITO_ANOS", "DRAMA", 1));
		assertEquals("1: Cassio - Reputacao: 500,00|2: Geovane - Reputacao: 10,00|3: Hemillainy - Reputacao: 9,00|",
				uc.listarTop10MelhoresUsuario());
	}

	/**
	 * Testa o metodo que lista os top 10 piores usuarios.
	 */
	@Test
	public void testListarTop10PioresUsuario() {
		uc.getUsuario("Geovane", "1234-5678").cadastraItem(new JogoEletronico("Naruto", 200, "PC"));
		uc.getUsuario("Cassio", "4321-5678").cadastraItem(new JogoTabuleiro("Chess", 10000));
		uc.getUsuario("Hemillainy", "5678-5678").cadastraItem(new Serie("GOT", 180, 220, "DEZOITO_ANOS", "DRAMA", 1));
		assertEquals("1: Hemillainy - Reputacao: 9,00|2: Geovane - Reputacao: 10,00|3: Cassio - Reputacao: 500,00|",
				uc.listarTop10PioresUsuario());
	}

}
