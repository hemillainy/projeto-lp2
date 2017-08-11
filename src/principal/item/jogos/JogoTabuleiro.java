package principal.item.jogos;

import java.util.ArrayList;
import java.util.List;
import enums.*;
import principal.item.Item;

/**
 * Classe que representa um jogo de tabuleiro.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class JogoTabuleiro extends Item {
	
	private List<String> pecasPerdidas;
	private StatusCompleto statusCompleto;
	
	/**
	 * Construtor de jogo de tabuleiro.
	 * @param nome
	 * @param valor
	 */
	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.pecasPerdidas = new ArrayList<>();
		this.statusCompleto = StatusCompleto.COMPLETO;
	}
	
	/**
	 * Metodo que adiciona uma peca perdida ao jogo de tabuleiro.
	 * @param peca
	 */
	public void adicionaPecaPerdida(String peca) {
		this.pecasPerdidas.add(peca);
		this.statusCompleto = StatusCompleto.INCOMPLETO;
	}
	
	/**
	 * HashCode que se baseia no nome e na quantidade de pecas perdidas do jogo de tabuleiro.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
		return result;
	}
	
	/**
	 * Equals que se baseia no nome e na quantidade de pecas perdidas do jogo de tabuleiro.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JogoTabuleiro other = (JogoTabuleiro) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (pecasPerdidas == null) {
			if (other.pecasPerdidas != null)
				return false;
		} else if (!pecasPerdidas.equals(other.pecasPerdidas))
			return false;
		return true;
	}
	
	/**
	 * Metodo que gera a representacao toString do jogo de tabuleiro.
	 */
	@Override
	public String toString() {
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.preco + ", " + status.getValor() + ", " + statusCompleto.getValor();
	}

}
