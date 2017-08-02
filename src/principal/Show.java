package principal;

public class Show extends BluRay {
	
	private String artista;
	private int faixas;
	
	public Show(String nome, double valor, int duracao, String classificacao, String artista, int faixas) {
		super(nome, valor, duracao, classificacao);
		this.artista = artista;
		this.faixas = faixas;
	}
	
	public String toString() {
		return this.nome + " Artista: " + this.artista + " - Duração: " + (this.duracao / 60) +  " Classificação: " + this.classificacao;
	}
}
