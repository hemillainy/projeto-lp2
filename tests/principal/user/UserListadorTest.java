package principal.user;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel pelos testes da classe UserListador.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class UserListadorTest {
	
	Usuario user1;
	Usuario user2;
	UserListador ul;
	List<Usuario> usuarios;
	
	@Before
	public void criaUsuarios() {
		user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		user2 = new Usuario("Hemillainy", "567", "hemi.suelen");
		ul = new UserListador();
		usuarios = new ArrayList<>();
		usuarios.add(user1);
		usuarios.add(user2);
	}

	/**
	 * Teste do metodo listarCaloteiros.
	 */
	@Test
	public void testListarCaloteiros() {
		user1.addReputacao(-100, 0.05);
		assertEquals("Lista de usuarios com reputacao negativa: Cássio, cassio.cordeiro, 123|", ul.listarCaloteiros(usuarios));
	}

	/**
	 * Teste do metodo listarTop10MelhoresUsuarios.
	 */
	@Test
	public void testListarTop10MelhoresUsuarios() {
		user1.addReputacao(100, 0.05);
		user1.addReputacao(50, 0.05);
		user2.addReputacao(200, 0.05);
		assertEquals("1: Hemillainy - Reputacao: 10,00|2: Cássio - Reputacao: 7,50|", ul.listarTop10MelhoresUsuarios(usuarios));
	}

	/**
	 * Teste do metodo listarTop10PioresUsuarios.
	 */
	@Test
	public void testListarTop10PioresUsuarios() {
		user1.addReputacao(-100, 0.05);
		user1.addReputacao(50, 0.05);
		user2.addReputacao(-100, 0.02);
		assertEquals("1: Cássio - Reputacao: -2,50|2: Hemillainy - Reputacao: -2,00|", ul.listarTop10PioresUsuarios(usuarios));
	}

}
