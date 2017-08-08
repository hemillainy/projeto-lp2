package enums;

/**
 * Enum responsavel pela integridade das peças de um jogo de tabuleiro.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public enum StatusCompleto {
	COMPLETO("COMPLETO"), INCOMPLETO("COM PECAS PERDIDAS");

	private final String valor;

	/**
	 * Construtor do Enum.
	 * 
	 * @param valor
	 *            que representa o estado das peças do jogo de tabuleiro.
	 */
	StatusCompleto(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que retorna estado das peças de um jogo de tabuleiro.
	 * 
	 * @return A String que representa o estado das peças de um jogo de
	 *         tabuleiro.
	 */
	public String getValor() {
		return this.valor;
	}

}
