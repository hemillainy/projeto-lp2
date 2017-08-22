

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import principal.comparator.ComparadorNumeroEmprestimos;
import principal.emprestimo.EmprestimoController;
import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

/**
 * 
 * Classe de testes da classe ComparadorNumeroEmprestimos.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class ComparadorNumeroEmprestimosTest {

	/**
	 * Teste do metodo compare. 
	 */
	@Test
	public void testCompare() {
		Item i1 = new JogoTabuleiro("Damas", 12.54);
		Item i2 = new JogoTabuleiro("Banco Imobiliário", 45.76);
		Usuario user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		Usuario user2 = new Usuario("Hemillainy", "321", "hemillainy.santos");
		user1.cadastraItem(i1);
		EmprestimoController ec = new EmprestimoController();
		ec.registraEmprestimo(user1, user2, "Damas", "30/09/2017", 5);
		ComparadorNumeroEmprestimos cne = new ComparadorNumeroEmprestimos();
		assertTrue(cne.compare(i1, i2) < 0);
	}

}
