package principal;


public class Emprestimo {
	private Usuario dono;
	private Usuario requerente;
	private Item emprestado;
	private int periodo;
	private java.util.Date dataEmprestimo;
	private java.util.Date dataDevolucao;
	
	
	public Emprestimo(Usuario dono, Usuario requerente, Item emprestado, java.util.Date dataEmprestimo, int periodo) {
		this.dono = dono;
		this.requerente = requerente;
		this.emprestado = emprestado;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = null;
		this.periodo = periodo;
	}
	
	public void devolverItem(java.util.Date  dataDevolucao) {
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
	
	public String toString() {
		return this.dono.getNome() + " - " + this.requerente.getNome() + " - " + this.emprestado.getNome() + " - " + this.periodo + " - " +
				this.dataEmprestimo + " - " + this.dataDevolucao;
	}


}