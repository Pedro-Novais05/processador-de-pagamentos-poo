package br.com.pagamentos.pagamento;

import br.com.pagamentos.exception.PagamentoInvalidoException;

import java.math.BigDecimal;

public class PagamentoPix extends MetodoPagamento {
    private String chavePix;

    public PagamentoPix(String idTransacao, BigDecimal valor, String chavePix) {
        super(idTransacao, valor);
        this.chavePix = chavePix;
    }

    @Override
    public void processarPagamento() {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Pix recusado: Chave Pix inválida ou não informada.");
        }
    }
}
