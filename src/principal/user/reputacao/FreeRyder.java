package principal.user.reputacao;

import enums.StatusFidelidade;

/**
 * Classe filha de fidelidade que representa um FreeRyder. . 
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class FreeRyder extends Fidelidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contrutor de FreeRyder. 
	 * @param valor o valor atual de reputacao do usuario. 
	 */
	public FreeRyder(double valor) {
		this.statusFidelidade = StatusFidelidade.FREE_RYDER;
		this.podePegarEmprestado = true;
		this.periodo = 5;
		this.reputacao = valor;
	}
}