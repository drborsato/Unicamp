package br.unicamp.ic.caixaautomatico.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import br.unicamp.ic.caixaautomatico.exceptions.ObterExtratoException;
import br.unicamp.ic.caixaautomatico.exceptions.ObterSaldoException;
import br.unicamp.ic.caixaautomatico.spec.IConta;

public abstract class ContaBase implements IConta {

	public static int ATIVA = 1;
	public static int ENCERRADA = 2;
	
	protected int estado; // 1=Ativa, 2=Encerrada
	protected String titular; // nome do titular
	protected int numConta; // número da conta
	protected int senha; // senha
	protected float saldoAnterior; // saldo anterior
	protected float limite;
//	protected String historico[]; // históricos e
//	protected float valorLanc[]; // valores dos últimos
	// lançamentos > 0 p/ créditos; < 0 p/ débitos
//	protected int ultLanc; // topo dos vetores acima
	List<Historico> historico;
	protected float saldoAtual; // saldo atual da conta
	

	public float getLimite() {
		return limite;
	}
	
	public ContaBase(String titular, float saldoAtual, int numConta, int senha) {
		this.estado = ContaCor.ATIVA; // A conta se torna ativa, podendo receber
										// lançamentos.
		this.titular = titular;
		this.saldoAtual = saldoAtual;
		this.numConta = numConta;
		this.senha = senha;

//		this.ultLanc = 0; // A conta sem nenhum lançamento.
//		this.historico = new String[11]; // cria vetores ...
//		this.valorLanc = new float[11]; // ... com 11 elementos
		this.historico = new LinkedList<Historico>();
		
	}

	@Override
	public float obterSaldo(int pwd) throws ObterSaldoException{
		// A conta deve estar ativa
		if (estado != ContaCor.ATIVA)
			throw new ObterSaldoException("A conta deve estar ativa");
		// A senha de entrada deve ser igual à senha da conta
		if (pwd != senha)
			throw new ObterSaldoException("A senha de entrada deve ser igual à senha da conta");
		return (saldoAtual); // retorna o saldo atual
	}

	@Override
	public String obterExtrato(int pwd) throws ObterExtratoException{
		// A conta deve estar ativa
		if (estado != ContaCor.ATIVA)
			throw new ObterExtratoException("A conta deve estar ativa");
		// A senha de entrada deve ser igual à senha da conta
		if (pwd != senha)
			throw new ObterExtratoException("A senha de entrada deve ser igual à senha da conta");
		String log = null;
		
		log.concat("\n");
		log.concat("Cliente: " + titular);
		log.concat("\n");
		log.concat("Conta: " + numConta);
		log.concat("\n");
		log.concat("\n");
		
		for (Historico historico2 : historico) {
			log.concat(historico2.getData());
			log.concat(" - ");
			log.concat(historico2.getOperacao());
			log.concat(" - ");
			log.concat(Float.toString(historico2.getValor()));
			log.concat("\n");
		}
		
		log.concat("\n");
		log.concat("SALDO: " + saldoAtual);
		
		return log;
	}
	
	public void atualizarHistorico(float valor){
		
		Date data = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Historico hist = new Historico(df.format(data),valor);

		historico.add(hist);
		if(historico.size() > 10){
			historico.remove(0);
		}
			
	}

}
