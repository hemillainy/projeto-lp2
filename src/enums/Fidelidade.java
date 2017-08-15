package enums;

/**
 * Enum responsavel pelo Status de fidelidade de um usuario. 
 *
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public enum Fidelidade {
	NOOB("Noob"), CALOTEIRO("Caloteiro"), BOM_AMIGO("BomAmigo"), FREE_RYDER("FreeRyder");

	private String valor;
	
	/**
	 * Construtor do Enum.
	 * 
	 * @param valor
	 *            que representa o status de fidelidade de um usuario.
	 */
	private Fidelidade(String valor) {
		this.valor = valor;
	}
	
	/**
	 * Metodo que retorna o valor do enum. 
	 * 
	 * @return A String que representa o status de fidelidade de um usuario.
	 */
	public String getValor() {
		return valor;
	}

}
