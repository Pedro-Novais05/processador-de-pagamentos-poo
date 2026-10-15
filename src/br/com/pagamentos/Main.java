package br.com.pagamentos;

import br.com.pagamentos.exception.PagamentoInvalidoException;
import br.com.pagamentos.exception.SaldoInsuficienteException;
import br.com.pagamentos.model.ContaCliente;
import br.com.pagamentos.pagamento.MetodoPagamento;
import br.com.pagamentos.pagamento.PagamentoCartaoCredito;
import br.com.pagamentos.pagamento.PagamentoPix;
import br.com.pagamentos.service.ProcessadorDeVendas;
import br.com.pagamentos.util.FormatadorMoeda;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        ContaCliente cliente1 = new ContaCliente(1, "Pedro Henrique", BigDecimal.valueOf(500),BigDecimal.valueOf(200));
        ProcessadorDeVendas processador = new ProcessadorDeVendas();

        MetodoPagamento pix = new PagamentoPix("TX1001", BigDecimal.valueOf(150), "0000-0000");
        MetodoPagamento cartao = new PagamentoCartaoCredito("TX1002", BigDecimal.valueOf(30), "1234-5678", 3);
        MetodoPagamento cartaoInvalido = new PagamentoCartaoCredito("TX1003", BigDecimal.valueOf(50), "2345-6789", 15);

        realizarVenda(processador, cliente1, pix);
        realizarVenda(processador, cliente1, cartao);
        realizarVenda(processador, cliente1, cartaoInvalido);

        BigDecimal valorDeposito = BigDecimal.valueOf(100);
        cliente1.depositar(valorDeposito);
        System.out.println("\nDepósito realizado no valor de: " + FormatadorMoeda.formatar(valorDeposito) );
        System.out.println("\nSaldo após depósito: " + FormatadorMoeda.formatar (cliente1.getSaldo()));

    }

    private static void realizarVenda (ProcessadorDeVendas processador, ContaCliente conta, MetodoPagamento pagamento){
        try {
            processador.executarVenda(conta, pagamento);
            System.out.println("\nVenda realizada com sucesso! \nSaldo restante: " + FormatadorMoeda.formatar(conta.getSaldo()));
        } catch (PagamentoInvalidoException | SaldoInsuficienteException e){
            System.out.println("\nFalha na venda: " + e.getMessage());
        }
    }
}
