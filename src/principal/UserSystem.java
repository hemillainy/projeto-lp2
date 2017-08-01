package principal;

import java.util.Map;
import java.util.HashMap;

public class UserSystem {
	private boolean aberto;
	private Validacao validacao;
	private Map<String, Usuario> usuarios;

	public UserSystem() {
		aberto = true;
		usuarios = new HashMap<>();
		validacao = new Validacao();
	}

	public void fechaSistema() {
		this.aberto = false;
	}

	private boolean hasUsuario(String nome, String telefone) {
		if (usuarios.containsKey(nome + telefone)) {
			return true;
		}
		return false;
	}

	public void cadastraUsuario(String nome, String telefone, String email) {
		validacao.dadoUsuarioInvalido(nome, telefone, email);
		if (!hasUsuario(nome, telefone)) {
			Usuario usuario = new Usuario(nome, telefone, email);
			usuarios.put(nome + telefone, usuario);
		} else {
			validacao.usuarioJaCadastrado();
		}
	}

	public void removeUsuario(String nome, String telefone) {
		if (hasUsuario(nome, telefone)) {
			usuarios.remove(nome + telefone);
		} else {
			validacao.usuarioInvalido();
		}
	}

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		if (usuarios.containsKey(nome + telefone)) {
			if (atributo.equals("Email")) {
				System.out.println("email");
				return usuarios.get(nome + telefone).getEmail();
			} else if (atributo.equals("Nome")) {
				return usuarios.get(nome + telefone).getNome();
			}
		}
		return validacao.usuarioInvalido();
	}

	private void setKeyUsuario(Usuario usuario) {
		usuarios.remove(usuario);
		String id = usuario.getNome() + usuario.getTelefone();
		usuarios.put(id, usuario);
	}

	public void atualizaUsuario(String nome, String telefone, String atributo, String valor) {
		if (usuarios.containsKey(nome + telefone)) {
			if (atributo.equals("Email")) {
				usuarios.get(nome + telefone).setEmail(valor);
			} else if (atributo.equals("Telefone")) {
				Usuario usuario = usuarios.get(nome + telefone);
				usuario.setTelefone(telefone);
				setKeyUsuario(usuario);
			}
		} else {
			validacao.usuarioInvalido();
		}
	}
}