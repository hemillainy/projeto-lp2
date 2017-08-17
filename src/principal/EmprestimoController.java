package principal;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import principal.emprestimo.Emprestimo;
import principal.emprestimo.IdEmprestimo;
import principal.item.Item;
import principal.user.Usuario;

public class EmprestimoController {
	private Listador listador;
	private Validacao validacao;
	private Map<IdEmprestimo, Emprestimo> emprestimos;

	public EmprestimoController() {
		this.listador = new Listador();
		this.validacao = new Validacao();
		this.emprestimos = new HashMap<>();
	}

	/**
	 * Cria um emprestimo e um idEmprestimo. Adiciona o emprestimo no map de
	 * emprestimos e passa-o para o dono e o requerente.
	 * 
	 * @param dono
	 *            dono do item emprestado.
	 * @param requerente
	 *            usuario que ira pegar o item emprestado.
	 * @param itemEmprestar
	 *            item que sera emprestado.
	 * @param data
	 *            data em que foi realizado o emprestimo.
	 * @param periodo
	 *            periodo em que o requerente deve ficar com o item.
	 */
	private void alocarEmprestimos(Usuario dono, Usuario requerente, Item itemEmprestar, LocalDate data, int periodo) {
		Emprestimo e = new Emprestimo(dono, requerente, itemEmprestar, data, periodo);
		IdEmprestimo ie = new IdEmprestimo(dono, requerente, itemEmprestar, data);
		emprestimos.put(ie, e);
		dono.addEmprestimo(e);
		requerente.addEmprestimo(e);
		itemEmprestar.setStaus();
	}

	/**
	 * Metodo que realiza um emprestimo.
	 * 
	 * @param dono
	 *            usuario dono do item.
	 * @param requerente
	 *            usuario que est� pegando o item emprestado.
	 * @param nomeItem
	 *            a ser emprestado.
	 * @param dataEmprestimo
	 *            que houve o emprestimo.
	 * @param periodo
	 *            de emprestimo.
	 * @throws ParseException
	 */
	public void registraEmprestimo(Usuario dono, Usuario requerente, String nomeItem, String dataEmprestimo,
			int periodo) {
		validacao.validaItemEmprestimo(dono.getItem(nomeItem));
		Item itemEmprestar = dono.getItem(nomeItem);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataEmprestimo, dtf);

		if (itemEmprestar.verificaEmprestado()) {
			validacao.ItemJaEmprestado();
		}

		alocarEmprestimos(dono, requerente, itemEmprestar, data, periodo);
		dono.addReputacao(itemEmprestar.getPreco(), 0.1);
		itemEmprestar.addNumeroEmprestimo();

	}

	/**
	 * Verifica se um emprestimo esta atrasado.
	 * 
	 * @param dataEmprestimo
	 *            em que foi emprestado o item.
	 * @param dataDevolucao
	 *            que foi devolvido o item.
	 * @return o periodo que o requerente ficou com o item.
	 */
	private long emprestimoAtrasado(LocalDate dataEmprestimo, LocalDate dataDevolucao) {
		long periodo = dataEmprestimo.until(dataDevolucao, ChronoUnit.DAYS);
		return periodo;
	}

	/**
	 * Metodo que devolve um item.
	 * 
	 * @param dono
	 *            dono do item.
	 * @param requerente
	 *            usuario que est� pegando o item emprestado.
	 * @param nomeItem
	 *            a ser devolvido.
	 * @param dataEmprestimo
	 *            que aconteceu o emprestimo.
	 * @param dataDevolucao
	 *            do item.
	 * @throws ParseException
	 */
	public void devolveItem(Usuario dono, Usuario requerente, String nomeItem, String dataEmprestimo,
			String dataDevolucao) {
		validacao.validaItemEmprestimo(dono.getItem(nomeItem));
		Item itemDevolver = dono.getItem(nomeItem);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataE = LocalDate.parse(dataEmprestimo, dtf);
		LocalDate dataD = LocalDate.parse(dataDevolucao, dtf);
		IdEmprestimo ie = new IdEmprestimo(dono, requerente, itemDevolver, dataE);
		if (!emprestimos.containsKey(ie)) {
			validacao.emprestimoNaoEncontrado();
		}
		emprestimos.get(ie).devolverItem(dataD);
		itemDevolver.setStaus();
		if (emprestimoAtrasado(dataE, dataD) <= requerente.getPeriodo()) {
			requerente.addReputacao(itemDevolver.getPreco(), 0.05);
		} else {
			double taxa = (emprestimoAtrasado(dataE, dataD) - requerente.getPeriodo()) / 100.00;
			requerente.addReputacao(-itemDevolver.getPreco(), taxa);
		}
	}

	/**
	 * Metodo que lista os associados a um item.
	 * 
	 * @param nome
	 *            do item.
	 * @return a lista com todos os emprestimos relacionados a um item.
	 */
	public String listarEmprestimosItem(String nome) {
		return listador.listaEmprestimosItem(emprestimos.values(), nome);
	}

	/**
	 * Metodo que lista os itens cadastrados nao emprestados.
	 * 
	 * @return a listagem com os itens emprestados.
	 */
	public String listaItensEmprestados() {
		List<Emprestimo> emp = new ArrayList<>(emprestimos.values()); // stub
		return listador.listaItensEmprestados(emp);
	}
}
