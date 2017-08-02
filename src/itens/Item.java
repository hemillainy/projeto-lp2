package itens;

public abstract class Item {
	protected String nome;
	protected double valor;
	protected Status status;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.status = Status.NAO_EMPRESTADO;
	}

	public void setStaus() {
		status = verificaEmprestado() ? Status.NAO_EMPRESTADO : Status.EMPRESTADO;
	}
	
	private boolean verificaEmprestado() {
		if (status.equals(Status.EMPRESTADO)) {
			return true;
		}
		return false;
	}
	
	public abstract int hashCode();
	
	public abstract boolean equals(Object obj);
	
	public abstract String toString();
	
}
