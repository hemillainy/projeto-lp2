package principal;

public class Filme extends BluRay {
	
	private String genero;
	private int lancamento;
	
	public Filme (String nome, double valor, int duracao, String classificacao, String genero, int lancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.lancamento = lancamento;
	}

}
