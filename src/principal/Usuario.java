package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import itens.blurays.*;
import principal.Item;
import itens.jogos.*;

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

	public List<Item> getItens() {
		List<Item> listItens = new ArrayList(itens.values());
		return listItens;
	}

	public void cadastraItem(String nomeItem, double preco, String plataforma) {
		itens.put(nomeItem, new JogoEletronico(nomeItem, preco, plataforma));
	}

	public void cadastraItem(String nomeItem, double preco) {
		itens.put(nomeItem, new JogoTabuleiro(nomeItem, preco));
	}

	public void cadastraItem(String nomeItem, double preco, int duracao, String genero, String classificacao,
			int lancamento) {
		itens.put(nomeItem, new Filme(nomeItem, preco, duracao, classificacao, genero, lancamento));
	}

	public void cadastraBluRayShow(String nomeItem, double preco, int duracao, String classificacao, String artista,
			int faixas) {
		itens.put(nomeItem, new Show(nomeItem, preco, duracao, classificacao, artista, faixas));
	}

	public void cadastraItem(String nomeItem, double preco, String descricao, int duracao, String classificacao,
			String genero, int temporada) {
		itens.put(nomeItem, new Serie(nomeItem, preco, duracao, classificacao, genero, temporada));
	}

	public void adicionaBluRay(String nomeBluRayTemporada, int duracao) {
		Serie serie = (Serie) (itens.get(nomeBluRayTemporada));
		serie.adicionarBluRay(duracao);
	}

	public String exibeDetalhesItem(String nomeItem) {
		if(!hasItem(nomeItem)){
			validacao.itemNaoEncontrado();
		}
		return itens.get(nomeItem).toString();
	}

	public String getPrecoItem(String nomeItem) {
		if (!hasItem(nomeItem)) {
			validacao.itemNaoEncontrado();
		}
		Item item = itens.get(nomeItem);
		String valor = String.valueOf(item.getPreco());
		return valor;
	}

	public String getNomeItem(String nomeItem) {
		if (!hasItem(nomeItem)) {
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
		itens.get(nomeItem).setPreco(Double.parseDouble(valor));
	}

	public void adicionarPecaPerdida(String nomeItem, String nomePeca) {
		JogoTabuleiro jogo = (JogoTabuleiro) (itens.get(nomeItem));
		jogo.adicionaPecaPerdida(nomePeca);
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

	private boolean hasItem(String nomeItem) {
		if (itens.containsKey(nomeItem)) {
			return true;
		}
		return false;
	}

	private void setKeyItem(Item item) {
		itens.remove(item);
		itens.put(item.getNome(), item);
	}
}
