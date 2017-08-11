package enums;

/**
 * Enum responsavel pela plataforma de um jogo eletronico.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public enum Plataforma {
	PC("PC"), MAC("MAC"), PS3("PS3"), PS4("PS$"), XBOX360("XBOX360"),
	XBOX_ONE("XBOX_ONE"), NINTENDO_3DS("NINTENDO_3DS"), OUTRO("OUTRO");
	
	private String valor;
	
	/**
	 * Construtor do Enum.
	 * 
	 * @param valor
	 *            que representa a plataforma de um jogo eletronico.
	 */
	Plataforma(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que retorna o valor do enum. 
	 * 
	 * @return a String que representa a plataforma do jogo eletronico. 
	 */
	public String getValor() {
		return this.valor;
	}
}
