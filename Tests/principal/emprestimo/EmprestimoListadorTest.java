package principal.emprestimo;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import principal.item.Item;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

/**
 * Classe de testes da classe EmprestimoListado.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class EmprestimoListadorTest {
	
	Map<IdEmprestimo, Emprestimo> emprestimos;
	Usuario user1;
	Usuario user2;
	Item i1;
	Item i2;
	Emprestimo emprestimo1;
	Emprestimo emprestimo2;
	IdEmprestimo ide1;
	IdEmprestimo ide2;
	EmprestimoListador el;

	@Before
	public void criaEmprestimos() {
		emprestimos = new HashMap<>();
		user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		user2 = new Usuario("Hemillainy", "321", "hemillainy.santos");
		i1 = new JogoTabuleiro("Xadrez", 99.98);
		i2 = new JogoTabuleiro("Banco imobiliário", 199);
		user2.cadastraItem(i2);
		user1.cadastraItem(i1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("22/08/2017", dtf);
		emprestimo1 = new Emprestimo(user2, user1, i2, data, 5);
		emprestimo2 = new Emprestimo(user1, user2, i1, data, 5);
		ide1 = new IdEmprestimo(user2, user1, i2, data);
		ide2 = new IdEmprestimo(user1, user2, i1, data);
		emprestimos.put(ide1, emprestimo1);
		emprestimos.put(ide2, emprestimo2);
		el = new EmprestimoListador();
		user1.addEmprestimo(emprestimo1);
		user1.addEmprestimo(emprestimo2);
		user2.addEmprestimo(emprestimo1);
		user2.addEmprestimo(emprestimo2);
		i1.setStaus();
		i2.setStaus();
	}
	
	/**
	 * Teste do metodo listarEmprestimosUsuarioEmprestando.
	 */
	@Test
	public void testListaEmprestimosUsuarioEmprestando() {
		assertEquals("Emprestimos: EMPRESTIMO - De: Cássio, Para: Hemillainy, Xadrez, 22/08/2017, 5 dias, ENTREGA: Emprestimo em andamento|", el.listaEmprestimosUsuarioEmprestando(emprestimos, user1));
		assertEquals("Emprestimos: EMPRESTIMO - De: Hemillainy, Para: Cássio, Banco imobiliário, 22/08/2017, 5 dias, ENTREGA: Emprestimo em andamento|", el.listaEmprestimosUsuarioEmprestando(emprestimos, user2));
	}

	/**
	 * Teste do metodo listaEmprestimosUsuarioPegandoEmprestado.
	 */
	@Test
	public void testListaEmprestimosUsuarioPegandoEmprestado() {
		assertEquals("Emprestimos pegos: EMPRESTIMO - De: Cássio, Para: Hemillainy, Xadrez, 22/08/2017, 5 dias, ENTREGA: Emprestimo em andamento|", el.listaEmprestimosUsuarioPegandoEmprestado(user2));;
	}

	/**
	 * Teste do metodo listaEmprestimosItem.
	 */
	@Test
	public void testListaEmprestimosItem() {
		List<Emprestimo> emps = new ArrayList<>(emprestimos.values());
		assertEquals("Emprestimos associados ao item: EMPRESTIMO - De: Cássio, Para: Hemillainy, Xadrez, 22/08/2017, 5 dias, ENTREGA: Emprestimo em andamento|", el.listaEmprestimosItem(emps, "Xadrez"));;
	}

	/**
	 * Teste do metodo listaItensEmprestados.
	 */
	@Test
	public void testListaItensEmprestados() {
		List<Emprestimo> emp = new ArrayList<>(emprestimos.values());
		assertEquals("Dono do item: Hemillainy, Nome do item emprestado: Banco imobiliário|Dono do item: Cássio, Nome do item emprestado: Xadrez|", el.listaItensEmprestados(emp));
	}

}
