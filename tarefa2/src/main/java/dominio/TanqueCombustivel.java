package dominio;

/*
 * A classe TanqueCombustivel deve guardar a quantidade de combustível disponível e a 
 * sua capacidade máxima (1000), sendo que a quantidade disponível nunca pode ser
 * maior que a capacidade máxima.
 */
public class TanqueCombustivel {

	private final double capacidadeMaxima = 1000;
	private double quantidadeDisponivel;

	public double getCapacidadeTotal() {
		return this.capacidadeMaxima;
	}

	public double getQntAtual() {
		return this.quantidadeDisponivel;
	}

	public boolean abastecer(double value) {
		double quantidadeRestante = this.capacidadeMaxima - this.quantidadeDisponivel;
		if (value > quantidadeRestante) {
			this.quantidadeDisponivel = this.capacidadeMaxima;
			return false;
		}
		this.quantidadeDisponivel += value;
		return true;
	}

	public boolean consumir(double value) {
		if (value > this.quantidadeDisponivel)
			return false;
		this.quantidadeDisponivel -= value;
		return true;
	}

	public TanqueCombustivel() {
		this.quantidadeDisponivel = 0;
	}

}
