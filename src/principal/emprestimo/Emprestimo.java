package principal.emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import principal.item.Item;
import principal.user.Usuario;

/**
 * 
 * Representação de um emprestimo.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Emprestimo {
	private Usuario dono;
	private Usuario requerente;
	private Item emprestado;
	private int periodo;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	/**
	 * Constroi um emprestimo a partir de um dono, um requerente, um item, uma
	 * data e um periodo.
	 * 
	 * @param dono
	 *            dono do item que sera emprestado.
	 * @param requerente
	 *            pessoa que esta pegando o item emprestado.
	 * @param emprestado
	 *            item emprestado.
	 * @param dataEmprestimo
	 *            data em que o emprestimo foi feito.
	 * @param periodo
	 *            periodo no qual o requerente deve ficar com o item emprestado.
	 */
	public Emprestimo(Usuario dono, Usuario requerente, Item emprestado, LocalDate dataEmprestimo, int periodo) {
		this.dono = dono;
		this.requerente = requerente;
		this.emprestado = emprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = null;
		this.periodo = periodo;
	}

	/**
	 * Devolve um item.
	 * 
	 * @param dataDevolucao
	 *            data em que o item foi devolvido.
	 */
	public void devolverItem(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		return result;
	}

	/**
	 * Verifica se dois emprestimos sao iguais. Dois emprestimos sao iguais se
	 * possuirem o mesmo dono, requerente e data de emprestimo.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (dataEmprestimo == null) {
			if (other.dataEmprestimo != null)
				return false;
		} else if (!dataEmprestimo.equals(other.dataEmprestimo))
			return false;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		return true;
	}

	private String dataString(LocalDate date) {
		if (date == null) {
			return "Emprestimo em andamento";
		}
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(dtf);
	}

	/**
	 * Gera a representacao em String de um emprestimo. A representacao segue o
	 * formato: DONO DO ITEM - REQUERENTE - ITEM EMPRESTADO - DATA DO EMPRESTIMO
	 * - DATA DA DEVOLUCAO.
	 * 
	 * @return a representacao em String de um emprestimo.
	 */
	public String toString() {
		return "EMPRESTIMO - De: " + this.dono.getNome() + ", Para: " + this.requerente.getNome() + ", "
				+ this.emprestado.getNome() + ", " + dataString(dataEmprestimo) + ", " + this.periodo
				+ " dias, ENTREGA: " + dataString(this.dataDevolucao);
	}

	/**
	 * Metodo que retorna o dono do item emprestado.
	 * 
	 * @return o usuario dono do item emprestado.
	 */
	public Usuario getDono() {
		return this.dono;
	}

	/**
	 * Retorna o nome do dono do item emprestado.
	 * 
	 * @return nome do dono item emprestado.
	 */
	public String getNomeDome() {
		return this.dono.getNome();
	}

	/**
	 * Metodo que retorna o requerente do item emprestado.
	 * 
	 * @return o usuario dono do item emprestado.
	 */
	public Usuario getRequerente() {
		return this.requerente;
	}

	/**
	 * Metodo que retorna o item emprestado.
	 * 
	 * @return o item do emprestimo.
	 */
	public Item getItem() {
		return this.emprestado;
	}

	/**
	 * Retorna o nome do item emprestado.
	 * 
	 * @return o nome do item emprestado.
	 */
	public String getNomeItem() {
		return this.emprestado.getNome();
	}
}