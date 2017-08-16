package principal.user.reputacao;

public class Caloteiro extends CartaoFidelidade {
	
	public Caloteiro() {
		this.podePegarEmprestado = false;
		this.periodo = 0;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}
