
public class Validacao {
	public String usuarioInvalido() {
		throw new IllegalArgumentException("Usuario invalido");
	}

	public void usuarioJaCadastrado() {
		throw new IllegalArgumentException("Usuario ja cadastrado");
	}

	public void dadoUsuarioInvalido(String nome, String celular, String email){
		if (nome == null || celular == null || email == null || nome.trim().isEmpty() || celular.trim().isEmpty() || email.trim().isEmpty()){
			throw new IllegalArgumentException("Não foi possivel realizar o cadastro: nome, celular ou email inválido!");
		}
	}

}
