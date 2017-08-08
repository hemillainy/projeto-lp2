package principal;

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

	public void itemNaoEncontrado() {
		throw new IllegalArgumentException("Item nao encontrado");
	}

	public void itemInvalido(String nomeItem, double preco, String plataforma) {
		if(nomeItem == null || nomeItem.trim().isEmpty()){
			throw new IllegalArgumentException("Nome invalido");
		}
		if(preco <=0 ){
			throw new IllegalArgumentException("Preco invalido");
		}
		if (plataforma == null || plataforma.trim().isEmpty()){
			throw new IllegalArgumentException("Plataforma invalida");
		}
	}

	public void itemInvalido(String nomeItem, double preco) {
		if(nomeItem == null || nomeItem.trim().isEmpty()){
			throw new IllegalArgumentException("Nome invalido");
		}
		if(preco <=0 ){
			throw new IllegalArgumentException("Preco invalido");
		}
	}
	
	public void ItemJaEmprestado() {
		throw new IllegalArgumentException("Item emprestado no momento");
		
	}

	public void emprestimoNaoEncontrado() {
		throw new IllegalArgumentException("Emprestimo nao encontrado");
	}

	public void validaUsuariosEmprestimo(boolean containsKey, boolean containsKey2) {
		if (!containsKey || !containsKey2) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		
	}

	public void validaItemEmprestimo(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item nao encontrado");
		}
		
}

}
