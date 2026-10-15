package br.com.pagamentos.exception;

public class PagamentoInvalidoException extends RuntimeException{
    public PagamentoInvalidoException (String mensagem){
        super(mensagem);
    }

}
