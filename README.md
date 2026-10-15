# Processador de Pagamentos em Java

Um sistema de vendas com diferentes formas de pagamento desenvolvido em Java, focado em Programação Orientada a Objetos e tratamento de erros com exceções customizadas.

## 🚀 Sobre o Projeto

Este projeto simula o processamento de vendas com **Pix** e **Cartão de Crédito**. Cada forma de pagamento tem sua própria regra de validação, mas o processador de vendas trabalha com qualquer uma delas sem precisar saber qual é, graças ao uso de herança e polimorfismo.

## 🛠️ Funcionalidades

- **Pagamento via Pix:** Valida se a chave Pix foi informada antes de aprovar a venda.
- **Pagamento via Cartão de Crédito:** Valida o número do cartão e permite parcelamento de 1 a 12 vezes.
- **Débito com limite de crédito:** A venda é aprovada se o saldo somado ao limite da conta cobrir o valor.
- **Depósito:** Adiciona saldo à conta, bloqueando valores nulos ou negativos.
- **Tratamento de erros:** Exceções customizadas (`PagamentoInvalidoException` e `SaldoInsuficienteException`) informam o motivo exato da falha.
- **Formatação de moeda:** Valores exibidos no padrão brasileiro (`R$ 1.234,56`).

## 📋 Tecnologias Utilizadas

- Java 21
- Orientação a Objetos (POO)
- Classe abstrata e herança
- `BigDecimal` para valores monetários
- Exceções customizadas (`RuntimeException`)
- `NumberFormat` e `Locale` para formatação de moeda
- Organização em pacotes (`model`, `pagamento`, `service`, `exception`, `util`)

## 💡 O que foi exercitado

- **Abstração:** classe `MetodoPagamento` com método abstrato `processarPagamento()`.
- **Herança:** `PagamentoPix` e `PagamentoCartaoCredito` estendem a classe base.
- **Polimorfismo:** `ProcessadorDeVendas` recebe qualquer `MetodoPagamento`.
- **Encapsulamento:** atributos privados e alterados apenas por métodos com validação.
- **Separação de responsabilidades:** as classes de domínio lançam exceções e apenas o `Main` imprime mensagens.
