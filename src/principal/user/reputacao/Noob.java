package principal.user.reputacao;

public class Noob extends CartaoFidelidade {
	
	public Noob() {
		this.podePegarEmprestado = true;
		this.periodo = 7;
	}
	
	public int getPeriodo() {
		return periodo;
	}
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
}
