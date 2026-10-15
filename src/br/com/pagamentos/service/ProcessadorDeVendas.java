package br.com.pagamentos.service;

import br.com.pagamentos.model.ContaCliente;
import br.com.pagamentos.pagamento.MetodoPagamento;

public class ProcessadorDeVendas {

    public void executarVenda(ContaCliente contaCliente, MetodoPagamento metodoPagamento) {
        metodoPagamento.processarPagamento();
        contaCliente.debitar(metodoPagamento.getValor());
    }
}
