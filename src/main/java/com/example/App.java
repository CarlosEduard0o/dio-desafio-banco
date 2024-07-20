package com.example;

import java.util.Scanner;

import com.example.entidades.Agencia;
import com.example.entidades.Banco;
import com.example.entidades.Cliente;
import com.example.entidades.Conta;
import com.example.entidades.ContaCorrente;
import com.example.entidades.ContaPoupanca;


public class App 
{
    public static void main( String[] args )
    {
        App.run();
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome do banco: ");
        String nomeBanco = sc.nextLine();
        System.out.println("Digite o codigo do banco: ");
        int codigoBanco = sc.nextInt();
        Banco banco = new Banco(nomeBanco, codigoBanco);

        System.out.println("Digite o número da agência: ");
        int numeroAgencia = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a cidade onde se localiza a agência: ");
        String cidadeAgencia = sc.nextLine();
        Agencia agencia = new Agencia(numeroAgencia, cidadeAgencia, banco);

        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.println("Digite a idade do cliente: ");
        int idadeCliente = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o sexo do cliente: ");
        String sexoCliente = sc.nextLine();
        Cliente cliente = new Cliente(agencia, nomeCliente, idadeCliente, sexoCliente);

        Conta contaCorrente = new ContaCorrente(cliente);
        Conta contaPoupanca = new ContaPoupanca(cliente);


        // Cliente cliente1 = new Cliente(agencia, "Leandro", 18, "Masculino");
        // Cliente cliente2 = new Cliente(agencia, "Rosana", 39, "Feminino");
        // Cliente cliente3 = new Cliente(agencia, "Jose", 55, "Masculino");

        // Conta contaCorrente1 = new ContaCorrente(cliente1);
        // Conta contaCorrente2 = new ContaCorrente(cliente2);
        // Conta contaPoupanca1 = new ContaPoupanca(cliente3);

        agencia.addClient(cliente);

        // agencia.addClient(cliente1);

        // agencia.addClient(cliente2);

        // agencia.addClient(cliente3);

        contaCorrente.sacar(500);
        contaCorrente.transferir(500.0, contaPoupanca);
        contaCorrente.depositar(1500.0);
        contaCorrente.sacar(500);
        contaCorrente.transferir(500.0, contaPoupanca);

        contaPoupanca.depositar(1000.00);
        contaPoupanca.sacar(500.0);
        contaPoupanca.transferir(100.0, contaCorrente);

        exibirDados(contaCorrente, contaPoupanca, agencia);
    }

    private static void exibirDados(Conta contaCorrente, Conta contaPoupanca, Agencia agencia) {
        contaCorrente.exibirQuantidadeDeContas();

        System.out.println("########################################################################");

        System.out.println("CONTA CORRENTE");
        System.out.println("Saldo da conta: " + contaCorrente.getSaldo());
        System.out.println("Nome do cliente: " + contaCorrente.getCliente().getNome());
        System.out.println("Idade do cliente: " + contaCorrente.getCliente().getIdade());
        System.out.println("Sexo do cliente: " + contaCorrente.getCliente().getSexo());
        System.out.println("Cidade da agencia: " + contaCorrente.getCliente().getAgencia().getCidade());
        System.out.println("Numero da agencia: " + contaCorrente.getCliente().getAgencia().getNumero());
        System.out.println("Nome do banco: " + contaCorrente.getCliente().getAgencia().getBanco().getNome());
        System.out.println("Codigo do banco: " + contaCorrente.getCliente().getAgencia().getBanco().getCodigo());

        System.out.println("########################################################################");

        System.out.println("CONTA POUPANCA");
        System.out.println("Saldo da conta: " + contaPoupanca.getSaldo());
        System.out.println("Nome do cliente: " + contaPoupanca.getCliente().getNome());
        System.out.println("Idade do cliente: " + contaPoupanca.getCliente().getIdade());
        System.out.println("Sexo do cliente: " + contaPoupanca.getCliente().getSexo());
        System.out.println("Cidade da agencia: " + contaPoupanca.getCliente().getAgencia().getCidade());
        System.out.println("Numero da agencia: " + contaPoupanca.getCliente().getAgencia().getNumero());
        System.out.println("Nome do banco: " + contaPoupanca.getCliente().getAgencia().getBanco().getNome());
        System.out.println("Codigo do banco: " + contaPoupanca.getCliente().getAgencia().getBanco().getCodigo());

        System.out.println("#######################Lista de clientes#######################");

        agencia.getClientList();
        
    }
}
