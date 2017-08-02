package principal;

import java.util.Map;
import java.util.HashMap;

public class UserController {
	private IdUsuario id;
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
		id = new IdUsuario(nome, telefone);
		validacao.dadoUsuarioInvalido(nome, telefone, email);
		if (!hasUsuario(id)) {
			Usuario usuario = new Usuario(nome, telefone, email);
			usuarios.put(id, usuario);
		} else {
			validacao.usuarioJaCadastrado();
		}
	}

	public void removeUsuario(String nome, String telefone) {
		id = new IdUsuario(nome, telefone);
		if (hasUsuario(id)) {
			usuarios.remove(id);
		} else {
			validacao.usuarioInvalido();
		}
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		id = new IdUsuario(nome, telefone);
		if (hasUsuario(id)) {
			if (atributo.equals("Email")) {
				return usuarios.get(id).getEmail();
			} else if (atributo.equals("Nome")) {
				return usuarios.get(id).getNome();
			}
		}
		return validacao.usuarioInvalido();
	}

	private void setKey(String nome, String telefone, String valor, Usuario usuario) {
		id = new IdUsuario(nome, telefone);
		usuarios.remove(id);
		IdUsuario novoId = new IdUsuario(nome, valor);
		usuarios.put(novoId, usuario);
	}

	public void atualizaUsuario(String nome, String telefone, String atributo, String valor) {
		id = new IdUsuario(nome, telefone);
		if (hasUsuario(id)) {
			if (atributo.equals("Email")) {
				usuarios.get(id).setEmail(valor);
			} else if (atributo.equals("Telefone")) {
				Usuario usuario = usuarios.get(id);
				usuario.setTelefone(valor);
				setKey(nome, telefone, valor, usuario);
			}
		} else {
			validacao.usuarioInvalido();
		}
	}
	public String pesquisaDetalhesItem(String nome, String telefone, String item){
	}
}