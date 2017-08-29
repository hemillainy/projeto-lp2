package principal.user.reputacao;

import enums.StatusFidelidade;

/**
 * Classe filha de fidelidade que representa um BomAmigo. 
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class BomAmigo extends Fidelidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contrutor de BomAmigo.
	 * @param valor o valor atual de reputacao do usuario. 
	 */
	public BomAmigo(double valor) {
		this.statusFidelidade = StatusFidelidade.BOM_AMIGO;
		this.podePegarEmprestado = true;
		this.periodo = 14;
		this.reputacao = valor;
	}
}