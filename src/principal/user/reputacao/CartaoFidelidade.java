package principal.user.reputacao;

import enums.Fidelidade;

public abstract class CartaoFidelidade {
	protected Fidelidade fidelidade;
	protected boolean podePegarEmprestado;
	

	public CartaoFidelidade() {
		this.fidelidade = Fidelidade.NOOB;
	}

	
	public String getReputacao() {
		return fidelidade.getValor();
	}
	

}
