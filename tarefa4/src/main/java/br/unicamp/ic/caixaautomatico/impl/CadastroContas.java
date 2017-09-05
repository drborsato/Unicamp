package br.unicamp.ic.caixaautomatico.impl;

import java.util.LinkedList;
import java.util.List;

import br.unicamp.ic.caixaautomatico.spec.ICadastroContas;
import br.unicamp.ic.caixaautomatico.spec.IConta;

public class CadastroContas implements ICadastroContas {
	// Atributos
	private List<IConta> c; // vetor de contas

	// Operacoes
	public CadastroContas() { // método construtor
		c = new LinkedList<IConta>();
	}

	@Override
	public IConta buscaConta(int numeroConta) {
		return c.get(numeroConta-1);
	}

	@Override
	public IConta criarContaCorrente(String titular, float saldoAtual, int senha) {

		ContaCor conta = new ContaCor(titular, saldoAtual, c.size()+1, senha);
		c.add(conta);
		return conta;
	}

	@Override
	public IConta criarContaEspecial(String titular, float saldoAtual, int senha) {
		ContaEsp conta = new ContaEsp(titular, saldoAtual, c.size()+1, senha);
		c.add(conta);
		return conta;
	}

}
