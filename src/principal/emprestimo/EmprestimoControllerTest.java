package principal.emprestimo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;


/**
 * Classe de testes da classe EmprestimoController.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class EmprestimoControllerTest {
	
	Usuario user1;
	Usuario user2;
	Item item;
	
	EmprestimoController ec;
	
	@Before
	public void criaEmprestimoController() {
		user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		user2 = new Usuario("Geovane", "234", "geovane.nascimento");
		item = new JogoTabuleiro("Damas", 34.56);
		user1.cadastraItem(item);
		ec = new EmprestimoController();
		ec.registraEmprestimo(user1, user2, "Damas", "31/10/1517", 4);
	}
	
	/**
	 * Teste do metodo registraEmprestimo.
	 * Uma excecao eh esperado pois o usuario nao possui o item.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRegistraEmprestimoDonoSemItem() {
		ec.registraEmprestimo(user2, user1, "Damas", "31/10/1517", 5);
	}
	
	/**
	 * Teste do metodo registraEmprestimo.
	 * Uma excecao eh esperado pois o item ja esta emprestado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testRegistraEmprestimoItemJaEmprestado() {
		ec.registraEmprestimo(user1, user2, "Damas", "07/09/1517", 5);
	}

	/**
	 * Teste do metodo devolveItem.
	 */
	@Test
	public void testDevolveItem() {
		ec.devolveItem(user1, user2, "Damas", "31/10/1517", "01/11/1517");
		assertEquals("", ec.listaItensEmprestados());
	}

	/**
	 * Teste do metodo devolveItem.
	 * Uma excecao eh esperada pois o item nao foi emprestado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testDevolveItemItemNaoEmprestado() {
		ec.devolveItem(user1, user2, "Damas", "01/01/2001", "02/01/2001");
	}
	
	/**
	 * Teste do metodo devolveItem.
	 * Uma excecao eh esperada pois o dono nao possui o item.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testDevolveItemDonoSemItem() {
		ec.devolveItem(user1, user2, "Xadrez", "01/01/2001", "02/01/2001");
	}
	
	/**
	 * Teste do metodo listarEmprestimosItem.
	 */
	@Test
	public void testListarEmprestimosItem() {
		assertEquals("Emprestimos associados ao item: EMPRESTIMO - De: Cássio, Para: Geovane, Damas, 31/10/1517, 4 dias, ENTREGA: Emprestimo em andamento|", ec.listarEmprestimosItem("Damas"));
	}

	/**
	 * Teste do metodo listaItensEmprestados.
	 */
	@Test
	public void testListaItensEmprestados() {
		assertEquals("Dono do item: Cássio, Nome do item emprestado: Damas|", ec.listaItensEmprestados());
	}

	/**
	 * Teste do metodo listaEmprestimosUsuarioEmprestando.
	 */
	@Test
	public void testListarEmprestimosUsuarioEmprestando() {
		assertEquals("Emprestimos: EMPRESTIMO - De: Cássio, Para: Geovane, Damas, 31/10/1517, 4 dias, ENTREGA: Emprestimo em andamento|", ec.listarEmprestimosUsuarioEmprestando(user1));
		assertEquals("Nenhum item emprestado", ec.listarEmprestimosUsuarioEmprestando(user2));
	}

	@Test
	public void testListarEmprestimosUsuarioPegandoEmprestado() {
		assertEquals("Emprestimos pegos: EMPRESTIMO - De: Cássio, Para: Geovane, Damas, 31/10/1517, 4 dias, ENTREGA: Emprestimo em andamento|", ec.listarEmprestimosUsuarioPegandoEmprestado(user2));
		assertEquals("Nenhum item pego emprestado", ec.listarEmprestimosUsuarioPegandoEmprestado(user1));
	}

}
