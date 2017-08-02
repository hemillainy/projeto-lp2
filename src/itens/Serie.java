package itens;

public class Serie extends BluRay {

	private String genero;
	private int temporada;

	public Serie(String nome, double valor, int duracao, String classificacao, String genero, int temporada) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.temporada = temporada;
	}

	public String toString() {
		return "SERIE: " + this.nome + ", R$ " + this.valor + ", " + status.getValor() + ", " + this.duracao + " min" + ", "
				+ this.classificacao + ", " + this.genero + ", Temporada " + this.temporada;
	}
}
