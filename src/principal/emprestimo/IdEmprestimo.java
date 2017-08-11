package principal.emprestimo;


import java.time.LocalDate;

import principal.item.Item;
import principal.user.Usuario;

/**
 * 
 * Representacao de um id de um emprestimo.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class IdEmprestimo {
	Usuario dono;
	Usuario requerente;
	Item itemEmprestado;
	LocalDate dataEmprestimo;

	/**
	 * Constroi um idEmprestimo a partir de um dono, de um requerente, de um
	 * item e de uma data de emprestimo.
	 * 
	 * @param dono
	 *            dono do item emprestado.
	 * @param requerente
	 *            usuario que esta pegando o item emprestado.
	 * @param itemEmprestado
	 *            item emprestado.
	 * @param dataEmprestimo
	 *            data em que foi feito o emprestimo.
	 */
	public IdEmprestimo(Usuario dono, Usuario requerente, Item itemEmprestado, LocalDate dataEmprestimo) {
		this.dono = dono;
		this.requerente = requerente;
		this.itemEmprestado = itemEmprestado;
		this.dataEmprestimo = dataEmprestimo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEmprestimo == null) ? 0 : dataEmprestimo.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		result = prime * result + ((requerente == null) ? 0 : requerente.hashCode());
		return result;
	}

	/**
	 * Compara dois id's. Dois id's sao iguais quando possuem os mesmos donos,
	 * iten emprestado, data de emprestimo e requerente.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdEmprestimo other = (IdEmprestimo) obj;
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
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!itemEmprestado.equals(other.itemEmprestado))
			return false;
		if (requerente == null) {
			if (other.requerente != null)
				return false;
		} else if (!requerente.equals(other.requerente))
			return false;
		return true;
	}

}