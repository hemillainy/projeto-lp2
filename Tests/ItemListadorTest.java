

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import principal.emprestimo.Emprestimo;
import principal.item.Item;
import principal.item.ItemListador;
import principal.item.jogos.JogoTabuleiro;
import principal.user.Usuario;

/**
 * Classe de testes da classe ItemListador.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class ItemListadorTest {
	
	Item i1;
	Item i2;
	Item i3;
	ItemListador il;
	List<Item> itens;
	
	@Before
	public void criaItens() {
		i1 = new JogoTabuleiro("Damas", 20.00);
		i2 = new JogoTabuleiro("Xadrez", 59.76);
		i3 = new JogoTabuleiro("Banco imobiliário", 99);
		il = new ItemListador();
		itens = new ArrayList<>();
		itens.add(i1);
		itens.add(i2);
		itens.add(i3);
	}

	/**
	 * Teste do metodo listaItensNaoEmprestados.
	 */
	@Test
	public void testListaItensNaoEmprestados() {
		i1.setStaus();
		assertEquals("JOGO DE TABULEIRO: Banco imobiliário, R$ 99.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: Xadrez, R$ 59.76, Nao emprestado, COMPLETO|", il.listaItensNaoEmprestados(itens));
	}

	/**
	 * Teste do metodo listaItensEmprestados.
	 */
	@Test
	public void testListaItensEmprestados() {
		i2.setStaus();
		i3.setStaus();
		List<Emprestimo> emprestimos = new ArrayList<>();
		Usuario user1 = new Usuario("Cássio", "123", "cassio.cordeiro");
		Usuario user2 = new Usuario("Hemillainy", "23", "hemmi.suelen");
		user1.cadastraItem(i1);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse("31/10/1517", dtf);
		Emprestimo emp = new Emprestimo(user1, user2, i1, data, 5);
		emprestimos.add(emp);
		assertEquals("Dono do item: Cássio, Nome do item emprestado: Damas|", il.listaItensEmprestados(emprestimos));
	}

	/**
	 * Teste do metodo listaTop1Dez.
	 */
	@Test
	public void testListaTopDez() {
		i1.addNumeroEmprestimo();
		i1.addNumeroEmprestimo();
		i2.addNumeroEmprestimo();
		assertEquals("1) 2 emprestimos - JOGO DE TABULEIRO: Damas, R$ 20.0, Nao emprestado, COMPLETO|2) 1 emprestimos - JOGO DE TABULEIRO: Xadrez, R$ 59.76, Nao emprestado, COMPLETO|", il.listaTopDez(itens));
	}

	/**
	 * Teste do metodo listaItensOrdenadosPorValor.
	 */
	@Test
	public void testListaItensOrdenadosPorValor() {
		assertEquals("JOGO DE TABULEIRO: Damas, R$ 20.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: Xadrez, R$ 59.76, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: Banco imobiliário, R$ 99.0, Nao emprestado, COMPLETO|", il.listaItensOrdenadosPorValor(itens));;
	}

	/**
	 * Teste do metodo listaItensOrdenadosPorNome.
	 */
	@Test
	public void testListaItensOrdenadosPorNome() {
		assertEquals("JOGO DE TABULEIRO: Banco imobiliário, R$ 99.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: Damas, R$ 20.0, Nao emprestado, COMPLETO|JOGO DE TABULEIRO: Xadrez, R$ 59.76, Nao emprestado, COMPLETO|", il.listaItensOrdenadosPorNome(itens));;
	}

}
