package dominio;
/*
 * Agregue a essa classe um tanque de combustível, duas turbinas e um compartimento de carga.
 * Inclua em Aviao um construtor sem parâmetros que inicializa seus atributos com
 * valores padrão. 
 * 
 * obs: é razoável considerar que as turbinas funcionam sempre com a mesma potência e 
 * são sempre ligadas e desligadas ao mesmo tempo.
 */

public class Aviao {

	private TanqueCombustivel tanque;
	private Turbina turbinaDireita;
	private Turbina turbinaEsquerda;
	private CompartimentoCarga compartimentoCarga;

	public void ligarTurbinas() {
		this.turbinaDireita.ligar();
		this.turbinaEsquerda.ligar();
	}

	public void desligarTurbinas() {
		this.turbinaDireita.desligar();
		this.turbinaEsquerda.desligar();
	}

	public boolean isTurbinasLigadas() {
		return (turbinaDireita.isLigado() && turbinaEsquerda.isLigado());
	}

	public int nivelPotenciaTurbinas() {
		return turbinaDireita.getNivelPotencia();
	}

	public void aumentarPotenciaTurbinas() {
		// obs: aumenta 5 %
		this.turbinaDireita.aumentarPotencia(5);
		this.turbinaEsquerda.aumentarPotencia(5);
	}

	public void diminuirPotenciaTurbinas() {
		// obs: diminui 5 %
		this.turbinaDireita.diminuirPotencia(5);
		this.turbinaEsquerda.diminuirPotencia(5);
	}

	public void abastecer(double value) {
		this.tanque.abastecer(value);
	}

	public void consumir(double value) {
		this.tanque.consumir(value);
	}

	public double getCapacidadeTotalCombustivel() {
		return this.tanque.getCapacidadeTotal();
	}

	public double getQntdAtualCombustivel() {
		return this.tanque.getQntAtual();
	}

	public void carregarCarga(int value) {
		this.compartimentoCarga.carregarCarga(value);
	}

	public int getCapacidadeTotalCarga() {
		return this.compartimentoCarga.getCapacidadeTotal();
	}

	public int getQntdAtualCarga() {
		return this.compartimentoCarga.getQntAtual();
	}

	public Aviao() {

		this.tanque = new TanqueCombustivel();
		this.compartimentoCarga = new CompartimentoCarga();
		this.turbinaDireita = new Turbina();
		this.turbinaEsquerda = new Turbina();

	}

}
