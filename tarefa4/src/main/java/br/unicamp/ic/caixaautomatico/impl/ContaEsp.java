package br.unicamp.ic.caixaautomatico.impl;

import br.unicamp.ic.caixaautomatico.exceptions.CreditarValorException;
import br.unicamp.ic.caixaautomatico.exceptions.DebitarValorException;

public class ContaEsp extends ContaBase {

	public ContaEsp(String titular, float saldoAtual, int numConta, int senha) {
		super(titular, saldoAtual, numConta, senha);
		this.limite = 500;
//		LIMITE_SAQUE = 500;
	}

	@Override
	public boolean debitarValor(String hist, float valor, int pwd) throws DebitarValorException {
		// A conta deve estar ativa
		if (estado != ContaCor.ATIVA)
			throw new DebitarValorException("A conta deve estar ativa");
		// A senha de entrada deve ser igual à senha da conta
		if (pwd != senha)
			throw new DebitarValorException("A senha de entrada deve ser igual à senha da conta");
		// O valor do lançamento deve ser maior que zero
		if (valor <= 0)
			throw new DebitarValorException("O valor do lançamento deve ser maior que zero");
		// O valor do lançamento não pode ser superior ao saldo
		if (valor > saldoAtual)
			throw new DebitarValorException("O valor do lançamento não pode ser superior ao saldo");
		// O valor do lançamento não pode ser superior ao limite de saque
		if (valor > limite)
			throw new DebitarValorException("O valor do lançamento deve ser menor que o limite permitido: " + getLimite());
		if((valor % 10) != 0 )
			throw new DebitarValorException("O valor do lançamento deve ser multiplo de 10");

		// if (ultLanc == 10) {// Se há 10 lançamentos na lista
		// saldoAnterior += valorLanc[1]; // atualiza saldo anterior
		// for (int i = 1; i < 10; i++) { // remove o primeiro da lista
		// historico[i] = historico[i + 1];
		// valorLanc[i] = valorLanc[i + 1];
		// }
		// } else
		// ultLanc++;
		// historico[ultLanc] = hist; // guarda histórico ...
		// valorLanc[ultLanc] = -valor; // ... e valor do lançamento
		// (com sinal negativo)
		saldoAtual -= valor; // debita valor do saldo atual
		super.atualizarHistorico(-valor);
		if (saldoAtual == 0) // se zerou o saldo ...
			estado = 2; // ... torna a conta inativa
		return (true);
	}

	@Override
	public boolean creditarValor(String hist, float val) throws CreditarValorException{
		// A conta deve estar ativa
		if (estado != 1)
			throw new CreditarValorException("A conta deve estar ativa");
		// O valor do lançamento deve ser maior que zero.
		if (val <= 0)
			throw new CreditarValorException("O valor do lançamento deve ser maior que zero");
		// if (ultLanc == 10) { // Se há 10 lançamentos na lista
		// saldoAnterior += valorLanc[1]; // atualiza saldo anterior
		// for (int i = 1; i < 10; i++) { // remove o primeiro da lista
		// historico[i] = historico[i + 1];
		// valorLanc[i] = valorLanc[i + 1];
		// }
		// } else
		// ultLanc++;
		// historico[ultLanc] = hist; // guarda histórico ...
		// valorLanc[ultLanc] = val; // ... e valor do lançamento
		saldoAtual += val; // credita valor ao saldo atual
		super.atualizarHistorico(val);
		return (true); // operação terminada com sucesso
	}

}
