package enums;

public enum StatusEmprestado {
	EMPRESTADO("Emprestado"), 
	NAO_EMPRESTADO("Nao emprestado");
	
	private final String valor;
	
	StatusEmprestado(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}

}
