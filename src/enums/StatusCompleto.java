package enums;

public enum StatusCompleto {
	COMPLETO("COMPLETO"),
	INCOMPLETO("COM PECAS PERDIDAS");
	
	private final String valor;
	
	private StatusCompleto(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}

}



