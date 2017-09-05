package br.unicamp.ic.caixaautomatico;

import br.unicamp.ic.caixaautomatico.impl.TrmCxAut;

public class Principal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Instanciacao do caixa automatico
		TrmCxAut meuCaixaAut = new TrmCxAut(123,TrmCxAut.MODO_SUPERVISOR);
		
		//utilizacao do caixa
		meuCaixaAut.iniciarOperacao();

	}

}
