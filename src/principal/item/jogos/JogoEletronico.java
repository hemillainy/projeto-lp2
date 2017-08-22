package principal.item.jogos;

import enums.Plataforma;
import principal.item.Item;

/**
 * Classe que representa um jogo eletronico.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class JogoEletronico extends Item {

	private Plataforma plataforma;
	
	/**
	 * Construtor de jogo eletronico.
	 * @param nome o nome do jogo 
	 * @param valor o valor do jogo
	 * @param plataforma a plataforma do jogo
	 */
	public JogoEletronico(String nome, double valor, String plataforma) {
		super(nome, valor);
		this.plataforma = Plataforma.valueOf(plataforma);
	}
	
	/**
	 * HashCode que se baseia no nome e na plataforma do jogo eletronico.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((plataforma == null) ? 0 : plataforma.hashCode());
		return result;
	}
	
	/**
	 * Equals que se baseia no nome e na plataforma do jogo eletronico.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoEletronico other = (JogoEletronico) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (plataforma == null) {
			if (other.plataforma != null)
				return false;
		} else if (!plataforma.equals(other.plataforma))
			return false;
		return true;
	}
	
	/**
	 * Metodo que gera a representacao toString de jogo eletronico.
	 */
	@Override
	public String toString() {
		return "JOGO ELETRONICO: " + this.nome + ", R$ " + this.preco + ", " + status.getValor() + ", " + this.plataforma;
	}
}
