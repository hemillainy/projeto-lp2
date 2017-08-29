package principal.user.reputacao;

import enums.StatusFidelidade;

/**
 * Classe filha de fidelidade que representa um Noob.. 
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Noob extends Fidelidade {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contrutor de Noob. 
	 * @param valor o valor atual de reputacao do usuario. 
	 */
	public Noob(double valor) {
		this.statusFidelidade = StatusFidelidade.NOOB;
		this.podePegarEmprestado = true;
		this.periodo = 7;
		this.reputacao = valor;
	}
}