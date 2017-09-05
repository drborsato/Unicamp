package br.unicamp.ic.caixaautomatico.impl;

import br.unicamp.ic.caixaautomatico.exceptions.ObterSaldoException;
import br.unicamp.ic.caixaautomatico.exceptions.RecarregarCaixaException;
import br.unicamp.ic.caixaautomatico.spec.ICaixa;

public class Caixa implements ICaixa {
	// Atributos
	private float saldoCaixa; // saldo no caixa, em R$
	private int senhaCaixa;

	// Operacoes
	public Caixa(int senhaCaixa) {
		this.senhaCaixa = senhaCaixa;
		this.saldoCaixa = 0;
	}

	@Override
	public void recarregar(int pwd) throws RecarregarCaixaException {

		if (pwd != senhaCaixa)
			throw new RecarregarCaixaException("Senha incorreta!");

		this.saldoCaixa = 1000; // caixa recarregado (R$ 1000,00)
		System.out.println("Caixa recarregado!");
	}

	@Override
	public void liberarNotas(int qtd) {
		this.saldoCaixa -= qtd * 10; // notas de R$10
		while (qtd-- > 0) {
			System.out.println("===/ R$10,00 /===>");
		}
	}

	@Override
	public float obterSaldoCaixa() {
		return this.saldoCaixa;
	}

	@Override
	public boolean validarSenha(int pwd) {
		if (this.senhaCaixa == pwd) {
			return true;
		} else {
			return false;
		}
	}
}
