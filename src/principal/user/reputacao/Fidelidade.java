package principal.user.reputacao;

import enums.StatusFidelidade;

/**
 * Classe abstrata que serve de base para os quatro tipos possiveis de fidelidade. 
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public abstract class Fidelidade {
	protected StatusFidelidade statusFidelidade;
	protected double reputacao;
	protected int periodo; 
	protected boolean podePegarEmprestado;
	
	/**
	 * 
	 * @return o valor em String que representa a categoria da fidelidade. 
	 */
	public double getReputacao() {
		return reputacao;
	}
	
	/**
	 * Altera o valor da reputacao do usuario.
	 * 
	 * @param reputacao
	 *            o valor a ser adicionado a reputacao do usuario. O valor pode
	 *            ser positivo ou negativo.
	 */
	public void setReputacao(double reputacao) {
		this.reputacao += reputacao;
	}
	
	/**
	 * 
	 * @return o periodo de que um usuario pode passar com um item emprestado.
	 */
	public int getPeriodo() {
		return periodo;
	}
	
	/**
	 * Altera o periodo que o usuario pode ficar com um item emprestado. 
	 * @param periodo o novo periodo. 
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	/**
	 * 
	 * @return true se a fidelidade do usuario permite que ele possa pegar itens
	 *         emprestados ou false em caso contrario.
	 */
	public boolean podePegarEmprestado() {
		return podePegarEmprestado;
	}
	
	/**
	 * Retorna a string que representa a categoria do cartao fidelidade
	 * 
	 * @return string que representa um cartao fidelidade.
	 */
	public String getStatusFidelidade() {
		return statusFidelidade.getValor();
	}	
}