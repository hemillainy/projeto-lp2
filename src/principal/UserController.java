package principal;

import java.util.Map;
import java.util.HashMap;

public class UserController {
	private boolean aberto;
	private Validacao validacao;
	private Map<IdUsuario, Usuario> usuarios;

	public UserController() {
		aberto = true;
		usuarios = new HashMap<>();
		validacao = new Validacao();
	}

	public void fechaSistema() {
		this.aberto = false;
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
			info = usuarios.get(id).getEmail();
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

	public String pesquisaDetalhesItem(String nome, String telefone, String item) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if(!hasUsuario(id)){
			validacao.usuarioInvalido();
		}
		return usuarios.get(id).exibeDetalhesItem(item);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if(!hasUsuario(id)){
			validacao.usuarioInvalido();
		}
		usuarios.get(id).cadastraEletronico(nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		IdUsuario id = new IdUsuario(nome, telefone);
		if(!hasUsuario(id)){
			validacao.usuarioInvalido();
		}
		usuarios.get(id).cadastraJogoTabuleiro(nomeItem, preco);
	}
}