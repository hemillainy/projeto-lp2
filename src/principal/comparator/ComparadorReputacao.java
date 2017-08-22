package principal.comparator;

import java.util.Comparator;

import principal.user.Usuario;

public class ComparadorReputacao implements Comparator<Usuario> {

	@Override
	public int compare(Usuario usuario1, Usuario usuario2) {
		if (usuario1.getReputacao() < usuario2.getReputacao()) {
			return 1;
		} else if (usuario1.getReputacao() > usuario2.getReputacao()) {
			return -1;
		}
		return 0;
	}

}
