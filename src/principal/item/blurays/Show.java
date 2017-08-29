package principal.item.blurays;

/**
 * Classe que representa um show..
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class Show extends BluRay {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String artista;
	private int faixas;
	
	/**
	 * Construtor de show.
	 * @param nome do show.
	 * @param valor do show.
	 * @param duracao do show.
	 * @param classificacao indicativa do show.
	 * @param artista que realizou o show.
	 * @param faixas do show.
	 */
	public Show(String nome, double valor, int duracao, String classificacao, String artista, int faixas) {
		super(nome, valor, duracao, classificacao);
		this.artista = artista;
		this.faixas = faixas;
	}
	
	/**
	 * Metodo que gera a representacao toString de show.
	 */
	public String toString() {
		return "SHOW: " + this.nome + ", R$ " + this.preco + ", " + status.getValor() + ", " + this.duracao + " min" + ", " + 
				this.classificacao.getValor() + ", " + this.artista + ", " + this.faixas + " faixas";
	}
}
