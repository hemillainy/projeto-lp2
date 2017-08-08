package itens.blurays;

/**
 * Classe que representa um Filme.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class Filme extends BluRay {
	
	private String genero;
	private int lancamento;
	
	/**
	 * Construtor de um filme.
	 * @param nome do filme.
	 * @param valor do filme.
	 * @param duracao do filme.
	 * @param classificacao indicada do filme.
	 * @param genero do filme.
	 * @param lancamento do filme.
	 */
	public Filme (String nome, double valor, int duracao, String classificacao, String genero, int lancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.lancamento = lancamento;
	}
	 /**
	  * Metodo que gera a representacao toString de filme.
	  */
	public String toString() {
		return "FILME: " + this.nome + ", R$ " + this.preco + ", " + status.getValor() + ", " + this.duracao + " min" + ", " + 
				this.classificacao + ", " + this.genero + ", " + this.lancamento;
	}

}