package principal.user.reputacao;

import enums.StatusFidelidade;

/**
 * Classe filha de fidelidade que representa um Caloteiro. 
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Caloteiro extends Fidelidade {
	
	/**
	 * Contrutor de Caloteiro. 
	 * @param valor o valor atual de reputacao do usuario. 
	 */
	public Caloteiro(double valor) {
		this.statusFidelidade = StatusFidelidade.CALOTEIRO;
		this.podePegarEmprestado = false;
		this.periodo = 0;
		this.reputacao = valor;
	}
}