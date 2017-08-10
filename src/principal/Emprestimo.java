package principal;

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
	private java.util.Date dataEmprestimo;
	private java.util.Date dataDevolucao;

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
	public Emprestimo(Usuario dono, Usuario requerente, Item emprestado, java.util.Date dataEmprestimo, int periodo) {
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
	public void devolverItem(java.util.Date dataDevolucao) {
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

	/**
	 * Gera a representacao em String de um emprestimo. A representacao segue o
	 * formato: DONO DO ITEM - REQUERENTE - ITEM EMPRESTADO - DATA DO EMPRESTIMO
	 * - DATA DA DEVOLUCAO.
	 * 
	 * @return a representacao em String de um emprestimo.
	 */
	public String toString() {
		return this.dono.getNome() + " - " + this.requerente.getNome() + " - " + this.emprestado.getNome() + " - "
				+ this.periodo + " - " + this.dataEmprestimo + " - " + this.dataDevolucao;
	}

}