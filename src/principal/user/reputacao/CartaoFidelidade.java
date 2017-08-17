package principal.user.reputacao;

/**
 * Classe Responsavel pela logica do cartao fidelidade de um usuario.
 * 
 * Projeto de Laboratorio de Progamacao 2 - 2017.1 (TT - Tracking things)
 * 
 * @author Cassio Cordeiro - 116210038 Geovane Silva - 116211149 Hemillainy
 *         Santos - 116210802
 *
 */
public class CartaoFidelidade {
	private Fidelidade fidelidade;
	private double reputacao;
	private int quantidadeItens;

	/**
	 * Construtor da classe. Inicializa os parametros. Um novo cartao fidelidade
	 * eh sempre inicialmente como Noob
	 */
	public CartaoFidelidade() {
		this.fidelidade = new FreeRyder(0);
		this.reputacao = 0;
		this.quantidadeItens = 0;
	}

	/**
	 * Retorna a string que representa a categoria do cartao fidelidade
	 * 
	 * @return string que representa um cartao fidelidade.
	 */
	public String getFidelidade() {
		return fidelidade.getStatusFidelidade();
	}

	/**
	 * Altera o valor da reputacao do usuario.
	 * 
	 * @param valor
	 *            o valor a ser adicionado a reputacao do usuario. O valor pode
	 *            ser positivo ou negativo.
	 */
	public void setReputacao(double valor) {
		this.reputacao += valor;
		setFidelidade();

	}

	/**
	 * Metodo auxiliar que altera o tipo de fidelidade do cartao.
	 */
	private void setFidelidade() {
		double reputacao = this.reputacao;
		if (reputacao < 0) {
			this.fidelidade = new Caloteiro(reputacao);
		} else if (reputacao >= 0 && reputacao <= 100 && hasItens()) {
			this.fidelidade = new Noob(reputacao);
		} else if (reputacao > 100) {
			this.fidelidade = new BomAmigo(reputacao);
		} else if (reputacao >= 0 && !hasItens()) {
			this.fidelidade = new FreeRyder(reputacao);
		}
	}

	/**
	 * 
	 * @return o valor da reputacao do usuario.
	 */
	public double getReputacao() {
		return fidelidade.getReputacao();
	}

	/**
	 * 
	 * @return true se a fidelidade do usuario permite que ele possa pegar itens
	 *         emprestados ou false em caso contrario.
	 */
	public boolean podePegarEmprestado() {
		return fidelidade.podePegarEmprestado();
	}

	/**
	 * 
	 * @return o periodo de que um usuario pode passar com um item emprestado.
	 */
	public int getPeriodo() {
		return fidelidade.getPeriodo();
	}

	/**
	 * Incrementa na variavel quantidadeItens
	 */
	public void addItem() {
		this.quantidadeItens++;
	}

	/**
	 * Decrementa na variavel quantidadeItens
	 */
	public void tiraItem() {
		this.quantidadeItens--;
	}

	/**
	 * Metodo auxilia que verifica se o usuario tem itens para emprestar.
	 * 
	 * @return true caso o usuario tenha itens ou false em caso contrario.
	 */
	private boolean hasItens() {
		return this.quantidadeItens > 0 ? true : false;
	}
}