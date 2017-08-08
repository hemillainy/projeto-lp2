package itens.blurays;

import principal.Item;

/**
 * Classe base para um BluRay.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public abstract class BluRay extends Item {
	

	protected String classificacao;
	protected int duracao;
	
	/**
	 * Construtor de um BluRay.
	 * @param nome do BluRay.
	 * @param valor de compra do BluRay.
	 * @param duracao do BluRay.
	 * @param classificacao indicada do BluRay.
	 */
	public BluRay(String nome, double valor, int duracao, String classificacao) {
		super(nome, valor);
		this.classificacao = classificacao;
		this.duracao = duracao;
	}
	
	/**
	 * HashCode que se baseia no nome do BluRay.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/**
	 * Equals que se baseia no nome do BluRay.
	 */
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
