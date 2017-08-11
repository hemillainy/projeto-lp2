package principal.user;

/**
 * Classe que representa a identificacao de um usuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class IdUsuario {

	String nome;
	String telefone;

	/**
	 * Construtor de idUsuario.
	 * 
	 * @param nome
	 *            do usuario.
	 * @param telefone
	 *            do usuario.
	 */
	public IdUsuario(String nome, String telefone) {
		this.nome = nome;
		this.telefone = telefone;
	}

	/**
	 * Metodo que gera a representacao toString do idUsuario.
	 * 
	 * @return o toString do idUsuario.
	 */
	public String toString() {
		return this.nome + " " + this.telefone;
	}

	/**
	 * HashCode que se baseia no nome e no telefone do usuario.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Equals que se baseia no nome e no telefone do usuario.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdUsuario other = (IdUsuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
