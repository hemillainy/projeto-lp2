package principal.item;

import enums.*;

/**
 * Classe que representa um item.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public abstract class Item implements Comparable<Item> {
	protected String nome;
	protected double preco;
	protected StatusEmprestado status;
	
	/**
	 * Construtor de item.
	 * @param nome do item.
	 * @param valor do item.
	 */
	public Item(String nome, double valor) {
		this.nome = nome;
		this.preco = valor;
		this.status = StatusEmprestado.NAO_EMPRESTADO;
	}
	
	/**
	 * Metodo que retorna o status do item.
	 * @return o status do item.
	 */
	public String getStatus() {
		return this.status.getValor();
	}
	
	/**
	 * Metodo que altera o status de um item.
	 */
	public void setStaus() {
		status = verificaEmprestado() ? StatusEmprestado.NAO_EMPRESTADO : StatusEmprestado.EMPRESTADO;
	}
	
	/**
	 * Metodo que retorna o preco de um item.
	 * @return o preco do item.
	 */
	public double getPreco(){
		return preco;
	}
	
	/**
	 * Metodo que verifica se um item esta emprestado.
	 * @return o boolean que representa se o item esta emprestado (true) ou nao(false)
	 */
	public boolean verificaEmprestado() {
		if (status.equals(StatusEmprestado.EMPRESTADO)) {
			return true;
		}
		return false;
	}
	
	/**
	 * CompareTo que se baseia no nome do item.
	 */
	@Override
	public int compareTo(Item item) {
		return this.nome.compareTo(item.nome);
	}
	
	@Override
	public abstract String toString();
	
	/**
	 * Metodo que retorna o nome do item.
	 * @return o nome do item.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que altera o nome de um item.
	 * @param valor novo nome do item.
	 */
	public void setNome(String valor) {
		this.nome = valor;
	}
	
	/**
	 * Metodo que altera o preco de um item.
	 * @param valor novo do preco do item.
	 */
	public void setPreco(double valor) {
		this.preco = valor;
	}

}
