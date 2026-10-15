package br.com.pagamentos.pagamento;

import java.math.BigDecimal;

public abstract class MetodoPagamento {
    private final String idTransacao;
    private final BigDecimal valor;

    public MetodoPagamento(String idTransacao, BigDecimal valor){
        this.idTransacao = idTransacao;
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public abstract void processarPagamento();
}
