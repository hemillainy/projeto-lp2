package principal.item.blurays;

import java.util.ArrayList;
import java.util.List;

import enums.Genero;

/**
 * Classe que representa uma serie.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class Serie extends BluRay {

	private Genero genero;
	private int temporada;
	private List<Integer> episodios;

	/**
	 * Construtor de serie.
	 * 
	 * @param nome
	 *            da serie.
	 * @param valor
	 *            da serie.
	 * @param duracao
	 *            da serie.
	 * @param classificacao
	 *            indicativa da serie.
	 * @param genero
	 *            da serie.
	 * @param temporada
	 *            da serie.
	 */
	public Serie(String nome, double valor, int duracao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		this.genero = Genero.valueOf(genero);
		this.temporada = temporada;
		this.episodios = new ArrayList<>();
	}
 
	/**
	 * Metodo que adiciona um episodia a serie.
	 * 
	 * @param duracao
	 *            do episodio.
	 */
	public void adicionarBluRay(int duracao) {
		episodios.add(duracao);
	}

	/**
	 * Metodo que gera a representacao toString de serie.
	 */
	public String toString() {
		return "SERIE: " + this.nome + ", R$ " + this.preco + ", " + status.getValor() + ", " + this.duracao + " min"
				+ ", " + this.classificacao.getValor() + ", " + this.genero.getValor() + ", Temporada "
				+ this.temporada;
	}

	/**
	 * Metodo que pega a duracao de uma serie.
	 * 
	 * @return a duracao da serie.
	 */
	public int getDuracao() {
		return this.duracao;
	}
}