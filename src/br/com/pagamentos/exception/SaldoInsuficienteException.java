package br.com.pagamentos.exception;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException (String mensagem){
        super(mensagem);
    }
}
