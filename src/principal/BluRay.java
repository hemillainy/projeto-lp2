package principal;

public abstract class BluRay extends Item {
	

	protected String classificacao;
	protected int duracao;
	
	
	public BluRay(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		this.classificacao = classificacao;
		this.duracao = duracao;
	}
	
	public String toString() {
		return this.nome + " - Duração: " + (this.duracao / 60) +  " Classificação: " + this.classificacao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluRay other = (BluRay) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
