package enums;

/**
 * Enum responsavel pelo genero de um filme.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public enum Genero {
	ACAO("ACAO"), ANIMACAO("ANIMACAO"), AVENTURA("AVENTURA"), COMEDIA("COMEDIA"),
	DOCUMENTARIO("DOCUMENTARIO"), DRAMA("DRAMA"), EROTICO("EROTICO"), FAROESTE("FAROESTE"),
	FICCAO("FICCAO"), MUSICAL("MUSICAL"), POLICIAL("POLICIAL"), ROMANCE("ROMANCE"),
	SUSPENSE("SUSPENSE"), TERROR("TERROR"), OUTRO("OUTRO");
	
	private String valor;
	
	/**
	 * Construtor do Enum.
	 * 
	 * @param valor
	 *            que representa o genero de um filme.
	 */
	Genero(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que retorna o valor do enum. 
	 * 
	 * @return A String que representa o genero de um filme.
	 */
	public String getValor() {
		return this.valor;
	}

}
