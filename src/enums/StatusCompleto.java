package enums;

public enum StatusCompleto {
	COMPLETO("SEM PECAS PERDIDAS"),
<<<<<<< HEAD:src/enums/StatusCompleto.java
	INCOMPLETO("COM PECAS PERDIDAS");
=======
	INCOMPLETO(" PECAS PERDIDAS");
	
>>>>>>> 685b12e2f81ce6c47005256ead7197d0399a7660:src/itens/jogos/Status.java
	private final String valor;
	
	private StatusCompleto(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}

}



