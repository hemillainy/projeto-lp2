package principal.user;

import java.util.Collections;
import java.util.List;

import principal.comparator.ComparadorReputacao;

/**
 * Classe responsavel pelas listagens concernentes a usuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038
 * 		   Geovane Silva - 116211149
 * 		   Hemillainy Santos - 116210802
 *
 */
public class UserListador {
	
	private ComparadorReputacao comparadorReputacao;
	
	/**
	 * Constroi um UserListador.
	 */
	public UserListador() {
		this.comparadorReputacao = new ComparadorReputacao();
	}

	/**
	 * Metodo que lista os usuario com reputacao menor que 0.
	 * 
	 * @param usuarios
	 *            List com todos os usuarios cadastrados no sistema.
	 * @return a listagem com os usuario com reputacao menor que 0.
	 */
	public String listarCaloteiros(List<Usuario> usuarios) {
		String info = "Lista de usuarios com reputacao negativa: ";
		Collections.sort(usuarios);

		for (Usuario usuario : usuarios) {
			if (usuario.getFidelidade().equals("Caloteiro")) {
				info += usuario + "|";
			}
		}
		return info;
	}

	/**
	 * Metodo que lista os 10 usuarios com melhores reputaÃ§oes.
	 * 
	 * @param usuarios
	 *            List com todos os usuarios cadastrados no sistema.
	 * @return a listagem com os 10 usuarios com melhor reputacao.
	 */
	public String listarTop10MelhoresUsuarios(List<Usuario> usuarios) {
		String info = "";
		Collections.sort(usuarios, comparadorReputacao);

		int posicao = 0;
		while (posicao < 10 && posicao < usuarios.size()) {
			Usuario usuario = usuarios.get(posicao);
			String reputacao = String.format("%.2f", usuario.getReputacao());
			info += posicao + 1 + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|";
			posicao++;
		}
		return info;
	}

	/**
	 * Metodo que lista os 10 usuarios com pior reputacao.
	 * 
	 * @param usuarios
	 *            List com todos os usuarios cadastrados no sistema.
	 * @return a listagem com os 10 usuarios com menor reputacao.
	 */
	public String listarTop10PioresUsuarios(List<Usuario> usuarios) {
		String info = "";
		Collections.sort(usuarios, comparadorReputacao);
		Collections.reverse(usuarios);
		int posicao = 0;
		while (posicao < 10 && posicao < usuarios.size()) {
			Usuario usuario = usuarios.get(posicao);
			String reputacao = String.format("%.2f", usuario.getReputacao());
			info += posicao + 1 + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|";
			posicao++;
		}
		return info;
	}
}
