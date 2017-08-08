package enums;

/**
 * Enum responsável pelo estado de empréstimo de um item.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public enum StatusEmprestado {
	EMPRESTADO("Emprestado"), 
	NAO_EMPRESTADO("Nao emprestado");
	
	private final String valor;
	
	/**
	 * Construtor do Enum.
	 * 
	 * @param valor
	 *            que representa o estado de emprestimo de um item.
	 */
	StatusEmprestado(String valor) {
		this.valor = valor;
	}
	
	/**
	 * Metodo que retorna estado das peças de um jogo de tabuleiro.
	 * 
	 * @return A String que representa o estado de emprestimo de um item.
	 */
	public String getValor() {
		return this.valor;
	}

}
