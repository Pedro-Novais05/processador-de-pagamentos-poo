package br.com.pagamentos.pagamento;

import br.com.pagamentos.exception.PagamentoInvalidoException;

import java.math.BigDecimal;

public class PagamentoCartaoCredito extends MetodoPagamento{
    private String numeroCartao;
    private int numeroParcelas;

    public PagamentoCartaoCredito (String idTransacao, BigDecimal valor, String numeroCartao, int numeroParcelas){
        super(idTransacao, valor);
        this.numeroCartao = numeroCartao;
        this.numeroParcelas = numeroParcelas;
    }

    @Override
    public void processarPagamento() {
        if (numeroCartao == null || numeroCartao.trim().isEmpty()){
            throw new PagamentoInvalidoException("Cartão recusado: número inválido ou não informado.");
        }
        if (numeroParcelas <=0 || numeroParcelas >12) {
            throw new PagamentoInvalidoException("Número de parcelas inválido: Permitido de 1 a 12.");
        }
    }
}
