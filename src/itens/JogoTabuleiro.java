package itens;

import java.util.ArrayList;
import java.util.List;

public class JogoTabuleiro extends Item {
	List<String> pecasPerdidas;

	public JogoTabuleiro(String nome, double valor) {
		super(nome, valor);
		this.pecasPerdidas = new ArrayList<>();
	}

	public void adicionaPecaPerdida(String peca) {
		this.pecasPerdidas.add(peca);
	}
	
	private boolean isComplete() {
		return this.pecasPerdidas.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((pecasPerdidas == null) ? 0 : pecasPerdidas.hashCode());
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

	@Override
	public String toString() {
		String completo = isComplete() ? "SEM PECAS PERDIDAS" : "COM PECAS PERDIDAS";
		return "JOGO DE TABULEIRO: " + this.nome + ", R$ " + this.valor +
				status.getValor() + completo;
	}

}
