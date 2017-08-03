package principal;

import easyaccept.EasyAccept;

public class Facade {
	public static void main(String[] args) {
		args = new String[] { "principal.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt" };
		EasyAccept.main(args);
	}

	private UserController sistema;

	public Facade() {
		sistema = new UserController();
	}

	public void iniciarSistema() {
	}

	public void fecharSistema() {
	}

	public void cadastrarUsuario(String nome, String celular, String email) {
		sistema.cadastraUsuario(nome, celular, email);
	}

	public void removerUsuario(String nome, String celular) {
		sistema.removeUsuario(nome, celular);
	}

	public String getInfoUsuario(String nome, String celular, String atributo) {
		return sistema.getInfoUsuario(nome, celular, atributo);
	}

	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		sistema.atualizaUsuario(nome, telefone, atributo, valor);
	}

	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		sistema.cadastrarEletronico(nome, telefone, nomeItem, preco, plataforma);
	}

	public void cadastrarJogoTabuleiro(String nome, String telefone, String nomeItem, double preco) {
		sistema.cadastrarJogoTabuleiro(nome, telefone, nomeItem, preco);
	}

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) {
	}

	public void cadastrarBluRayFilme(String nome, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int lancamento) {
	}

	public void cadastrarBluRayShow(String nome, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {

	}

	public void cadastrarBluRaySerie(String nome, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String classificacao, String genero, int temporada) {

	}

	public void adicionarBluRay(String nome, String telefone, String nomeBluRayTemporada, int duracao) {

	}

	public String getInfoItem(String nome, String telefone, String nomeItem, String atributo) {
		return sistema.getInfoItem(nome, telefone, nomeItem, atributo);
	}

	public void removerItem(String nome, String telefone, String nomeItem) {
		sistema.removerItem(nome, telefone, nomeItem);
	}

	public void atualizarItem(String nome, String telefone, String nomeItem, String atributo, String valor) {
		sistema.atualizarItem(nome, telefone, nomeItem, atributo, valor);
	}

	public void listarItensOrdenadosPorNome() {

	}

	public void listarItensOrdenadosPorValor() {

	}

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeRequerente,
			String telefoneRequerente, String nomeItem, String dataEmprestimo, int periodo) {

	}

	public void devolverItem(String nomeDono, String telefoneDono, String nomeRequerente, String telefoneRequerente,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {

	}
}
