package enums;

/**
 * Enum responsavel pela classificacao de um bluray.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public enum Classificacao {
	LIVRE("LIVRE"), DEZ_ANOS("DEZ_ANOS"),DOZE_ANOS("DOZE_ANOS"),
	QUATORZE_ANOS("QUATORZE_ANOS"), DEZESSEIS_ANOS("DEZESSEIS_ANOS"), DEZOITO_ANOS("DEZOITO_ANOS");
	
	private String valor;
	
	/**
	 * Construtor do Enum.
	 * 
	 * @param valor
	 *            que representa a classificacao indicativa de um bluray.
	 */
	Classificacao(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que retorna o valor do do enum. 
	 * 
	 * @return A String que representa a classificacao de um bluray.
	 */
	public String getValor() {
		return this.valor;
	}
}
