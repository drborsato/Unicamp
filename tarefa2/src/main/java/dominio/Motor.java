package dominio;

/*
 * A classe Motor deve guardar informação indicando se o motor está ou não ligado. 
 */
public class Motor {

	protected boolean power;
	
	protected boolean isLigado() {
		return this.power;
	}

	protected void ligar() {
		this.power = true;
	}

	protected void desligar() {
		this.power = false;
	}

	public Motor() {
		this.desligar();
	}
	

}
