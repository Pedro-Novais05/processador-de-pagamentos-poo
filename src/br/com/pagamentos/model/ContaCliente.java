package br.com.pagamentos.model;

import br.com.pagamentos.exception.SaldoInsuficienteException;

import java.math.BigDecimal;

public class ContaCliente {
    private int id;
    private String nome;
    private BigDecimal saldo;
    private BigDecimal limiteCredito;

    public ContaCliente(int id, String nome, BigDecimal saldo, BigDecimal limiteCredito) {
        this.id = id;
        this.nome = nome;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
    }
    public int getId () {
        return id;
    }

    public String getNome () {
        return nome;
    }

    public BigDecimal getSaldo () {
        return saldo;
    }

    public BigDecimal getLimiteCredito () {
        return limiteCredito;
    }

    public void depositar (BigDecimal valor){
       if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
           throw new IllegalArgumentException("O valor deve ser maior que zero");
        }

       this.saldo = this.saldo.add(valor);
    }

    public void debitar (BigDecimal valor){
      if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
          throw new IllegalArgumentException("O valor do débito deve ser maior que 0.");
      }

      BigDecimal saldoTotal = this.saldo.add(this.limiteCredito);

      if (saldoTotal.compareTo(valor) < 0) {
          throw new SaldoInsuficienteException("Saldo ou limite insuficiente na conta.");
      }
      this.saldo = this.saldo.subtract(valor);
    }
}
