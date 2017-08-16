package principal.user.reputacao;

public class FreeRyder extends CartaoFidelidade {

	public FreeRyder() {
		this.podePegarEmprestado = true;
		this.periodo = 5;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}
