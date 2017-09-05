package br.unicamp.ic.caixaautomatico.impl;

public class Historico {
	private String data;
	private float valor;
	private String operacao;

	public Historico(String data, float valor) {
		this.data = data;
		this.valor = valor;
		
		if(valor<0)
			operacao = "Débito";
		else if(valor>0)
			operacao = "Crédito";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getOperacao() {
		return operacao;
	}

}
