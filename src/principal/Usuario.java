package principal;

import java.util.HashMap;
import java.util.Map;

import itens.jogos.JogoEletronico;
import itens.jogos.JogoTabuleiro;

public class Usuario {
	private String nome;
	private String email;
	private String telefone;
	private Validacao validacao;
	private Map<String, Item> itens;

	public Usuario(String nome, String celular, String email) {
		this.nome = nome;
		this.telefone = celular;
		this.email = email;
		itens = new HashMap<>();
		validacao = new Validacao();
	}

	public String getEmail() {
		return this.email;
	}

	public String getNome() {
		return this.nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public void cadastraEletronico(String nomeItem, double preco, String plataforma) {
		itens.put(nomeItem, new JogoEletronico(nomeItem, preco, plataforma));
	}

	public void cadastraJogoTabuleiro(String nomeItem, double preco) {
		itens.put(nomeItem, new JogoTabuleiro(nomeItem, preco));
	}

	public String exibeDetalhesItem(String item) {
		return itens.get(item).toString();
	}

	public String getPrecoItem(String nomeItem) {
		if(!hasItem(nomeItem)){
			validacao.itemNaoEncontrado();
		}
		return itens.get(nomeItem).getPreco();
	}

	public String getNomeItem(String nomeItem) {
		if(!hasItem(nomeItem)){
			validacao.itemNaoEncontrado();
		}
		return itens.get(nomeItem).getNome();
	}

	public void removerItem(String nomeItem) {
		if (!itens.containsKey(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		itens.remove(nomeItem);
	}

	private boolean hasItem(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			return true;
		}
		return false;
	}
	private void setKeyItem(Item item){
		itens.remove(item);
		itens.put(item.getNome(), item);
	}
	public void atualizaNomeItem(String nomeItem, String valor) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		Item item = itens.get(nomeItem);
		itens.get(nomeItem).setNome(valor);
		setKeyItem(item);
	}

	public void atualizaPrecoItem(String nomeItem, String valor) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		itens.get(nomeItem).setPreco(valor);
	}
}
