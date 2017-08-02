package principal;

public class Filme extends BluRay {
	
	private String genero;
	private int lancamento;
	
	public Filme (String nome, double valor, int duracao, String classificacao, String genero, int lancamento) {
		super(nome, valor, duracao, classificacao);
		this.genero = genero;
		this.lancamento = lancamento;
	}
	
	public String toString() {
		return "FILME: " + this.nome + ", R$ " + this.valor + ", " + this.emprestado + ", " + this.duracao + " min" + ", " + 
				this.classificacao + ", " + this.genero + ", " + this.lancamento;
	}

}
