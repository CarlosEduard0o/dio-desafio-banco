package com.example.entidades;

import lombok.Data;

@Data
public abstract class Conta {
    private static int QUANTIDADE_CONTAS;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente){
        this.QUANTIDADE_CONTAS++;
        this.saldo = 0.0;
        this.cliente = cliente;
    }

    public void sacar(double valor){
        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void transferir(double valor, Conta contaDestino){
        if (this.saldo >= valor) {
            sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void exibirQuantidadeDeContas(){
        System.out.println("Quantidade de contas: " + QUANTIDADE_CONTAS);
    }
}
