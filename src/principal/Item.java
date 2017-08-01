package principal;

public abstract class Item {
	String nome;
	double valor;
	boolean emprestado;

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
	
	public abstract boolean equals();
	
	public abstract String toString();

}
