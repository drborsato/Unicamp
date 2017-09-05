package tarefa4;

import static org.junit.Assert.*;

import org.junit.Test;

import br.unicamp.ic.caixaautomatico.exceptions.CreditarValorException;
import br.unicamp.ic.caixaautomatico.exceptions.DebitarValorException;
import br.unicamp.ic.caixaautomatico.exceptions.ObterSaldoException;
import br.unicamp.ic.caixaautomatico.impl.ContaBase;
import br.unicamp.ic.caixaautomatico.impl.ContaCor;
import br.unicamp.ic.caixaautomatico.impl.ContaEsp;


/**
 * 
 * @author esoft17
 */
public class Testes {

    public static final String SENHA_INCORRETA_MESSAGE = "A senha de entrada deve ser igual à senha da conta";
    public static final String LANCAMENTO_MENOR_0_MESSAGE = "O valor do lançamento deve ser maior que zero";
    public static final String VALOR_MULTIPLO_10_MESSAGE = "O valor do lançamento deve ser multiplo de 10";
    public static final String VALOR_MAIOR_QUE_LIMITE_MESSAGE = "O valor do lançamento deve ser menor que o limite permitido";
    public static final String CONTA_ATIVA_MESSAGE = "A conta deve estar ativa";
    public static final String VALOR_MAIOR_QUE_SALDO_MESSAGE = "O valor do lançamento não pode ser superior ao saldo";

    @Test
    public void passwordIncorreto() {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        try {
            instance.obterSaldo(123);
            fail();
        } catch (ObterSaldoException e) {
            assertEquals(true, e.getMessage().equals(SENHA_INCORRETA_MESSAGE));
        }
    }

    @Test
    public void passwordCorreto() {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        try {
            instance.obterSaldo(1234);
            assertEquals(true, true);
        } catch (ObterSaldoException e) {
            fail();
        }
    }

    @Test
    public void creditarValorContaCorrente() throws CreditarValorException, ObterSaldoException {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        instance.creditarValor("", 200);
        assertEquals(1200, instance.obterSaldo(1234), 0);
    }

    @Test
    public void creditarValorMenorQueZeroContaCorrente() {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        try {
            instance.creditarValor("", -200);
            fail();
        } catch (CreditarValorException e) {
            assertEquals(true, e.getMessage().equals(LANCAMENTO_MENOR_0_MESSAGE));
        }
    }

    @Test
    public void debitarValorContaCorrente() throws DebitarValorException, ObterSaldoException {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        instance.debitarValor("", 200, 1234);
        assertEquals(800, instance.obterSaldo(1234), 0);
    }

    @Test
    public void debitarValorMenorQueZeroContaCorrente() {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        try {
            instance.debitarValor("", -200, 1234);
            fail();
        } catch (DebitarValorException e) {
            assertEquals(true, e.getMessage().equals(LANCAMENTO_MENOR_0_MESSAGE));
        }
    }

    @Test
    public void debitarValorMaiorQueLimiteContaCorrente() {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        try {
            instance.debitarValor("", 300, 1234);
            fail();
        } catch (DebitarValorException e) {
            assertEquals(true, e.getMessage()
                    .equals(VALOR_MAIOR_QUE_LIMITE_MESSAGE + ": " + instance.getLimite()));
        }
    }

    @Test
    public void debitarValorNaoMultiploDezContaCorrente() {
        ContaCor instance = new ContaCor("Douglas", 1000, 1, 1234);
        try {
            instance.debitarValor("", 313, 1234);
            fail();
        } catch (DebitarValorException e) {
            assertEquals(true, e.getMessage().equals(VALOR_MULTIPLO_10_MESSAGE));
        }
    }

    @Test
    public void creditarValorContaEspecial() throws CreditarValorException, ObterSaldoException {
        ContaEsp instance = new ContaEsp("Douglas", 1000, 1, 1234);
        instance.creditarValor("", 200);
        assertEquals(1200, instance.obterSaldo(1234), 0);
    }

    @Test
    public void creditarValorMenorQueZeroContaEspecial() {
        ContaEsp instance = new ContaEsp("Douglas", 1000, 1, 1234);
        try {
            instance.creditarValor("", -200);
            fail();
        } catch (CreditarValorException e) {
            assertEquals(true, e.getMessage().equals(LANCAMENTO_MENOR_0_MESSAGE));
        }
    }

    @Test
    public void debitarValorContaEspecial() throws DebitarValorException, ObterSaldoException {
        ContaEsp instance = new ContaEsp("Douglas", 1000, 1, 1234);
        instance.debitarValor("", 200, 1234);
        assertEquals(800, instance.obterSaldo(1234), 0);
    }

    @Test
    public void debitarValorMenorQueZeroContaEspecial() {
        ContaEsp instance = new ContaEsp("Douglas", 1000, 1, 1234);
        try {
            instance.debitarValor("", -200, 1234);
            fail();
        } catch (DebitarValorException e) {
            assertEquals(true, e.getMessage().equals(LANCAMENTO_MENOR_0_MESSAGE));
        }
    }

    @Test
    public void debitarValorMaiorQueLimiteContaEspecial() {
        ContaEsp instance = new ContaEsp("Douglas", 1000, 1, 1234);
        try {
            instance.debitarValor("", 600, 1234);
            fail();
        } catch (DebitarValorException e) {
            assertEquals(true, e.getMessage()
                    .equals(VALOR_MAIOR_QUE_LIMITE_MESSAGE + ": " + instance.getLimite()));
        }
    }

    @Test
    public void debitarValorNaoMultiploDezContaEspecial() {
        ContaEsp instance = new ContaEsp("Douglas", 1000, 1, 1234);
        try {
            instance.debitarValor("", 313, 1234);
            fail();
        } catch (DebitarValorException e) {
            assertEquals(true, e.getMessage().equals(VALOR_MULTIPLO_10_MESSAGE));
        }
    }

    @Test
    public void testePolimorfismo() {
        assertEquals(true, ContaCor.class.getSuperclass().equals(ContaBase.class));
    }

    @Test
    public void testePolimorfismo2() {
        assertEquals(true, ContaEsp.class.getSuperclass().equals(ContaBase.class));
    }
}
