package itens.blurays;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma serie.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class Serie extends BluRay {

	private String genero;
	private int temporada;
	private List<Integer> episodios;
	
	public Serie(String nome, double valor, int duracao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.temporada = temporada;
		this.episodios = new ArrayList<>();
	}
	
	public void adicionarBluRay(int duracao) {
		episodios.add(duracao);
	}

	public String toString() {
		return "SERIE: " + this.nome + ", R$ " + this.preco + ", " + status.getValor() + ", " + this.duracao + " min" + ", "
				+ this.classificacao + ", " + this.genero + ", Temporada " + this.temporada;
	}
}
