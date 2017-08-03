package itens.jogos;

public enum Status {
	EMPRESTADO("Emprestado"), 
	NAO_EMPRESTADO("Nao emprestado"),
	COMPLETO("SEM PECAS PERDIDAS"),
	INCOMPLETO(" PECAS PERDIDAS");
	
	private final String valor;
	
	Status(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}

}
