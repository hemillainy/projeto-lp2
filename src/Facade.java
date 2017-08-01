import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args){
		args = new String[]{"Facade", "acceptance_test/us1_test.txt"};
		EasyAccept.main(args);
	}
	private UserSystem sistema;

	public void iniciarSistema(){
		sistema = new UserSystem();
	}
	public void cadastrarUsuario(String nome, String celular, String email){
		sistema.cadastraUsuario(nome, celular, email);
	}
	public void removerUsuario(String nome, String celular){
		sistema.removeUsuario(nome, celular);
	}
	public String getInfoUsuario(String nome, String celular, String atributo){
		return sistema.getInfoUsuario(nome, celular, atributo);
	}
	public void atualizarUsuario(String nome, String celular, String atributo, String valor){
		sistema.atualizaUsuario(nome, celular, atributo, valor);
	}
	public void fecharSistema(){
		sistema.fechaSistema();
	}
}
