package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {
	private Validacao validacao;
	private Map<IdUsuario, Usuario> usuarios;
	private ComparadorValor comparadorValor;

	public Controller() {
		this.usuarios = new HashMap<>();
		this.validacao = new Validacao();
		this.comparadorValor = new ComparadorValor();
		
	}

	private boolean hasUsuario(IdUsuario id) {
		if (usuarios.containsKey(id)) {
			return true;
		}
		return false;
	}

	public void cadastraUsuario(String nome, String telefone, String email) {
		validacao.dadoUsuarioInvalido(nome, telefone, email);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (hasUsuario(id)) {
			validacao.usuarioJaCadastrado();
		}
		Usuario usuario = new Usuario(nome, telefone, email);
		usuarios.put(id, usuario);
	}

	public void removeUsuario(String nome, String telefone) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		usuarios.remove(id);
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		String info = "";
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			return validacao.usuarioInvalido();
		}
		if (atributo.equals("Email")) {
			info += usuarios.get(id).getEmail();
		} else if (atributo.equals("Nome")) {
			info = usuarios.get(id).getNome();
		}
		return info;
	}

	private void setKey(String nome, String telefone, String valor, Usuario usuario) {
		IdUsuario id = new IdUsuario(nome, telefone);
		usuarios.remove(id);
		IdUsuario novoId = new IdUsuario(nome, valor);
		usuarios.put(novoId, usuario);
	}

	public void atualizaUsuario(String nome, String telefone, String atributo, String valor) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		if (atributo.equals("Email")) {
			usuarios.get(id).setEmail(valor);
		} else if (atributo.equals("Telefone")) {
			Usuario usuario = usuarios.get(id);
			usuario.setTelefone(valor);
			setKey(nome, telefone, valor, usuario);
		}
	}
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		validacao.itemInvalido(nomeItem, preco, plataforma);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		validacao.itemInvalido(nomeItem, preco);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco);
		inventario.add(us.getItem(nomeItem));
	}

	public String pesquisaDetalhesItem(String nome, String telefone, String item) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		return usuarios.get(id).exibeDetalhesItem(item);
	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		String info = "";
		IdUsuario id = new IdUsuario(nome, telefone);
		if (atributo.equals("Preco")) {
			info = usuarios.get(id).getPrecoItem(nomeItem);
		} else if (atributo.equals("Nome")) {
			info = usuarios.get(id).getNomeItem(nomeItem);
		}
		return info;
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		usuarios.get(id).removerItem(nomeItem);
		
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		if (atributo.equals("Nome")) {
			usuarios.get(id).atualizaNomeItem(nomeItem, valor);
		} else if (atributo.equals("Preco")) {
			usuarios.get(id).atualizaPrecoItem(nomeItem, valor);
		}
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int lancamento) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, duracao, genero, classificacao, lancamento);
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario us = usuarios.get(id);
		us.cadastraBluRayShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {
		IdUsuario id = new IdUsuario(nome, telefone);
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, descricao, duracao, classificacao, genero, temporada);
	}

	public String listarItensOrdenadosPorNome() {
		Set<Item> it = new HashSet<>();
		for (Usuario us : usuarios.values()) {
			it.addAll(us.getItens());
		}
		List<Item> inventario = new ArrayList<>(it);
		
		Collections.sort(inventario);
		String itens = "";
		for (Item item : inventario) {
			itens += item.toString() + "|";
		}
		return itens;
	}

	public String listarItensOrdenadosPorValor() {
		Set<Item> it = new HashSet<>();
		for (Usuario us : usuarios.values()) {
			it.addAll(us.getItens());
		}
		List<Item> inventario = new ArrayList<>(it);
		
		Collections.sort(inventario, comparadorValor);
		String itens = "";
		for (Item item : inventario) {
			itens += item.toString() + "|";
		}
		return itens;
	}

	public void adicionarBluRay(String nome, String telefone, String nomeBluRayTemporada, int duracao) {
		IdUsuario id = new IdUsuario(nome, telefone);
		usuarios.get(id).adicionaBluRay(nomeBluRayTemporada, duracao);
	}

	
}