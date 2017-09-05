package dominio;

/*
 * A classe compartimento de carga define a sua capacidade máxima (1000) e a 
 * quantidade atual, sendo que a quantidade atual jamais ultrapassa a capacidade máxima.
 */
public class CompartimentoCarga {

	private final int capacidadeMaxima = 1000;
	private int quantidadeAtual;

	public int getCapacidadeTotal() {
		return this.capacidadeMaxima;
	}

	public int getQntAtual() {
		return this.quantidadeAtual;
	}

	public boolean carregarCarga(int value) {
		int quantidadeRestante = this.capacidadeMaxima - this.quantidadeAtual;
		if(value > quantidadeRestante)
			return false;
		this.quantidadeAtual += value;
		return true;
	}

	public CompartimentoCarga() {
		this.quantidadeAtual = 0;
	}

}
