package com.example.entidades;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Agencia {
    private int numero;
    private String cidade;
    private Banco banco;
    private List<Cliente> clientList = new ArrayList<>();

    public Agencia(int numero, String cidade, Banco banco){
        this.numero = numero;
        this.cidade = cidade;
        this.banco = banco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void getClientList() {
        for (Cliente cliente : clientList) {
            System.out.println(cliente.getIdade());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getSexo());
            System.out.println("################################");
        }
    }

    public void setClientList(List<Cliente> clientList) {
        this.clientList = clientList;
    }

    public void addClient(Cliente cliente) {
        this.clientList.add(cliente);
    }
    
}
