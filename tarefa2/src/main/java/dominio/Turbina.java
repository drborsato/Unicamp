package dominio;

/*
 * A classe turbina funciona como um motor, mas inclui informação adicional que 
 * indica o nível de potência (em percentagem) com o qual a turbina está funcionando, 
 * dado que ela está ligada. 
 */
public class Turbina extends Motor {

	private int potencia;
	private final int potenciaMaxima = 100;
	private final int potenciaMinima = 0;

	@Override
	protected void ligar() {
		// obs: potência inicial 5%
		super.ligar();
		this.potencia = 5;
	}

	@Override
	protected void desligar() {
		super.desligar();
		this.potencia = 0;
	}

	void aumentarPotencia(int aumento) {
		if (this.power) {
			if (aumento + potencia > potenciaMaxima)
				this.potencia = potenciaMaxima;
			else
				this.potencia += aumento;
		}
	}

	void diminuirPotencia(int diminuicao) {
		if (this.power) {
			if (potencia - diminuicao < potenciaMinima)
				this.potencia = potenciaMinima;
			else
				this.potencia -= diminuicao;
		}
	}

	int getNivelPotencia() {
		return this.potencia;
	}

	public Turbina() {
		this.desligar();
	}

}
