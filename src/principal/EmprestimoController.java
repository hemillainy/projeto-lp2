package principal;

import java.util.HashMap;
import java.util.Map;

import principal.emprestimo.Emprestimo;
import principal.emprestimo.IdEmprestimo;

public class EmprestimoController {
	private Map<IdEmprestimo, Emprestimo> emprestimos;

	public EmprestimoController() {
		this.emprestimos = new HashMap<>();

	}

}
