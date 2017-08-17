package principal;

import principal.user.IdUsuario;
import principal.user.Usuario;

public class ItemController {
	
	private Validacao validacao;
	
	public ItemController() {
		this.validacao = new Validacao();
	}
	/**
	 * Metodo que cadastra um jogo eletronico.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 * @param nomeItem
	 *            a ser cadastrado.
	 * @param do
	 *            jogo eletronico.
	 * @param plataforma
	 *            do jogo eletronico.
	 */
	public void cadastrarEletronico(String nome, String telefone, String nomeItem, double preco, String plataforma) {
		validacao.itemInvalido(nomeItem, preco, plataforma);
		IdUsuario id = new IdUsuario(nome, telefone);
		if (!hasUsuario(id)) {
			validacao.usuarioInvalido();
		}
		Usuario us = usuarios.get(id);
		us.cadastraItem(nomeItem, preco, plataforma);
	}

}
