package principal.user.reputacao;

public class BomAmigo extends CartaoFidelidade {

	public BomAmigo() {
		this.podePegarEmprestado = true;
		this.periodo = 14;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}
