package principal;

import itens.jogos.Status;

public abstract class Item implements Comparable<Item> {
	protected String nome;
	protected double preco;
	protected Status status;

	public Item(String nome, double valor) {
		this.nome = nome;
		this.preco = valor;
		this.status = Status.NAO_EMPRESTADO;
	}

	public void setStaus() {
		status = verificaEmprestado() ? Status.NAO_EMPRESTADO : Status.EMPRESTADO;
	}
	public double getPreco(){
		return preco;
	}

	private boolean verificaEmprestado() {
		if (status.equals(Status.EMPRESTADO)) {
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.nome);
	}

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

	public String getNome() {
		return this.nome;
	}

	public void setNome(String valor) {
		this.nome = valor;
	}

	public void setPreco(double valor) {
		this.preco = valor;
	}

}
