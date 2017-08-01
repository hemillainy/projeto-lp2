package principal;

public abstract class Item {
	protected String nome;
	protected double valor;
	protected boolean emprestado;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.emprestado = false;
	}
	
	public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado() {
		this.emprestado = true ? !isEmprestado() : false;
	}
	
	public abstract int hashCode();
	
	public abstract boolean equals(Object obj);
	
	
	
	public abstract String toString();
}
