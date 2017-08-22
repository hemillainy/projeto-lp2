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

	@Before
	public void inicializa() {
		uc.cadastraUsuario("Geovane", "1234-5678", "geovane@email.com");
		uc.cadastraUsuario("Cassio", "4321-5678", "cassio@email.com");
		uc.cadastraUsuario("Hemillainy", "5678-5678", "hemillainy@email.com");
	}

	@Test
	public void testGetUsuario() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geovane@email.com");
		assertEquals(us, uc.getUsuario("Geovane", "1234-5678"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNaoCadastrado() {
		uc.getUsuario("Geo", "1234-5678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNomeNulo() {
		uc.getUsuario(null, "1234-5678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNomeVazio() {
		uc.getUsuario("", "1234-5678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioNomeEspacos() {
		uc.getUsuario("   ", "1234-5678");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioTelefoneNulo() {
		uc.getUsuario("Geovane", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioTelefoneVazio() {
		uc.getUsuario("Geovane", "");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetUsuarioTelefoneEspacos() {
		uc.getUsuario("Geovane", "   ");
	}

	@Test
	public void testPegarEmprestado() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geovane@email.com");
		assertEquals(us, uc.pegarEmprestado("Geovane", "1234-5678", 5));
	}

	@Test
	public void testPegarEmprestadoUsuarioinexistente() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geovane@email.com");
		assertEquals(us, uc.pegarEmprestado("Geovane", "1234-5678", 5));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNaoPodePegarEmprestado() {
		uc.getUsuario("Geovane", "1234-5678").addReputacao(-200, 0.01);
		uc.pegarEmprestado("Geovane", "1234-5678", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNomeNulo() {
		uc.pegarEmprestado(null, "1234-5678", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNomeVazio() {
		uc.pegarEmprestado("", "1234-5678", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoNomeEspacos() {
		uc.pegarEmprestado("   ", "1234-5678", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoTelefoneNulo() {
		uc.pegarEmprestado("Geovane", null, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoTelefoneVazio() {
		uc.pegarEmprestado("Geovane", "", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPegarEmprestadoTelefoneEspacos() {
		uc.pegarEmprestado("Geovane", "   ", 5);
	}

	@Test
	public void testGetUsuarios() {
		assertEquals(3, uc.getUsuarios().size());
	}

	@Test
	public void testCadastraUsuario() {
		uc.cadastraUsuario("GEEEO", "123", "123@email.com");
		assertEquals(new Usuario("GEEEO", "123", "123@email.com"), uc.getUsuario("GEEEO", "123"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRemoveUsuario() {
		uc.removeUsuario("Geovane", "1234-5678");
		uc.getUsuario("Geovane", "1234-5678");
	}

	@Test
	public void testGetInfoUsuario() {
		assertEquals("geovane@email.com", uc.getInfoUsuario("Geovane", "1234-5678", "email"));
	}

	@Test
	public void testAtualizaUsuarioEmail() {
		Usuario us = new Usuario("Geovane", "1234-5678", "geo@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "email", "geo@email.com");
		assertEquals(us, uc.getUsuario("Geovane", "1234-5678"));
	}

	@Test
	public void testAtualizaUsuarioTelfone() {
		Usuario us = new Usuario("Geovane", "2468-13579", "geovane@email.com");
		uc.atualizaUsuario("Geovane", "1234-5678", "Telefone", "2468-13579");
		assertEquals(us, uc.getUsuario("Geovane", "2468-13579"));
	}

	@Test
	public void testListarCaloteirosComCaloteiro() {
		uc.getUsuario("Hemillainy", "5678-5678").addReputacao(-1000, 0.01);
		assertEquals("Lista de usuarios com reputacao negativa: Hemillainy, hemillainy@email.com, 5678-5678|",
				uc.listarCaloteiros());
	}

	@Test
	public void testListarCaloteirosSemCaloteiro() {
		assertEquals("Lista de usuarios com reputacao negativa: ", uc.listarCaloteiros());
	}

	@Test
	public void testListarTop10MelhoresUsuario() {
		uc.getUsuario("Geovane", "1234-5678").cadastraItem(new JogoEletronico("Naruto", 200, "PC"));
		uc.getUsuario("Cassio", "4321-5678").cadastraItem(new JogoTabuleiro("Chess", 10000));
		uc.getUsuario("Hemillainy", "5678-5678").cadastraItem(new Serie("GOT", 180, 220, "DEZOITO_ANOS", "DRAMA", 1));
		assertEquals("1: Cassio - Reputacao: 500,00|2: Geovane - Reputacao: 10,00|3: Hemillainy - Reputacao: 9,00|",
				uc.listarTop10MelhoresUsuario());
	}

	@Test
	public void testListarTop10PioresUsuario() {
		uc.getUsuario("Geovane", "1234-5678").cadastraItem(new JogoEletronico("Naruto", 200, "PC"));
		uc.getUsuario("Cassio", "4321-5678").cadastraItem(new JogoTabuleiro("Chess", 10000));
		uc.getUsuario("Hemillainy", "5678-5678").cadastraItem(new Serie("GOT", 180, 220, "DEZOITO_ANOS", "DRAMA", 1));
		assertEquals("1: Hemillainy - Reputacao: 9,00|2: Geovane - Reputacao: 10,00|3: Cassio - Reputacao: 500,00|",
				uc.listarTop10PioresUsuario());
	}

}
