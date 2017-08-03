package enums;

public enum StatusCompleto {
	COMPLETO("SEM PECAS PERDIDAS"),
	INCOMPLETO("COM PECAS PERDIDAS");
	
	private final String valor;
	
	private StatusCompleto(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}

}



