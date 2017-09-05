package br.unicamp.ic.caixaautomatico.impl;

import br.unicamp.ic.caixaautomatico.exceptions.DebitarValorException;
import br.unicamp.ic.caixaautomatico.exceptions.EfetuarSaqueException;
import br.unicamp.ic.caixaautomatico.exceptions.ObterExtratoException;
import br.unicamp.ic.caixaautomatico.exceptions.ObterSaldoException;
import br.unicamp.ic.caixaautomatico.exceptions.RecarregarCaixaException;
import br.unicamp.ic.caixaautomatico.spec.IConta;
import br.unicamp.ic.caixaautomatico.spec.IControladorCaixa;

public class ControladorCaixa implements IControladorCaixa {
	// Atributos
	private CadastroContas dbContas; // Banco de dados das contas
	private Caixa caixa;

	// Operacoes

	public ControladorCaixa(int senhaCaixa) {
		dbContas = new CadastroContas();
		caixa = new Caixa(senhaCaixa);
	}

	@Override
	public float consultarSaldo(int num, int pwd) throws ObterSaldoException {
		IConta cta;
		cta = dbContas.buscaConta(num); // obtem referencia para o objeto que
										// representa a conta 'num'
		if (cta == null)
			throw new ObterSaldoException("Número de conta inválido");

		return cta.obterSaldo(pwd); // efetua consulta
	}

	@Override
	public boolean efetuarSaque(int num, int pwd, float val) throws EfetuarSaqueException, DebitarValorException{
		IConta cta;
		
		if(val<0)
			throw new EfetuarSaqueException("Valor Saque dever ser maior que 0");
		if((val % 10) != 0 )
			throw new EfetuarSaqueException("Valor Saque dever ser múltiplo de 10 (10, 20, 30 ...)");
		if(val > caixa.obterSaldoCaixa())
			throw new EfetuarSaqueException("Valor Saque dever ser menor que " + caixa.obterSaldoCaixa());
		
		cta = dbContas.buscaConta(num); // obtem a referencia para o objeto que
										// representa a conta 'num'
		if (cta == null) 
			throw new EfetuarSaqueException("Número de conta inválido " + num);
		if (cta.debitarValor("Saque Automatico", val, pwd) == false) 
			throw new DebitarValorException("Valor Saque dever ser menor que valor disponível do caixa " + caixa.obterSaldoCaixa());
		
		caixa.liberarNotas((int) (val / 10)); // libera pagamento
		return (true);
	}

	@Override
	public void recarregar(int pwd) throws RecarregarCaixaException{
		caixa.recarregar(pwd); // caixa recarregado
	}

	@Override
	public boolean validarSenha(int pwd) {
		return caixa.validarSenha(pwd);
	}

	@Override
	public String consultaExtrato(int numeroConta, int pwd) throws ObterExtratoException {

		IConta cta;
		cta = dbContas.buscaConta(numeroConta); // obtem referencia para o
												// objeto que representa a conta
												// 'num'
		if (cta == null)
			throw new ObterExtratoException("Número de conta inválido");
		
		return cta.obterExtrato(pwd); // efetua consulta

	}

}
