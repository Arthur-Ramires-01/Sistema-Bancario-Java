package SistemaBancario.controller;
import SistemaBancario.model.Banco;
import SistemaBancario.model.Cliente;
import SistemaBancario.model.ContaCorrente;
import SistemaBancario.model.ContaPoupanca;
import SistemaBancario.model.Conta;
import SistemaBancario.model.ContaDAO;


public class ContaController {
    private Banco banco;
    private ContaDAO ContaDAO;

    public ContaController(Banco banco) {
    this.banco = banco; 
    this.ContaDAO = new ContaDAO();   
    }

    public Conta abrirConta(Cliente cliente, String tipoConta) {
    int numeroConta = banco.getContadorConta();
    Conta conta = null;
    double saldo = 1500.00;
    if (tipoConta.equals("corrente")){
        conta = new ContaCorrente(numeroConta, saldo, tipoConta, cliente, 500);
    } else if (tipoConta.equals("poupanca")){
        conta = new ContaPoupanca(numeroConta, saldo, tipoConta, cliente);
    } else {
        throw new IllegalArgumentException ("Tipo de conta inválido");
    }
    banco.adicionarConta(conta);
    ContaDAO.salvar(conta);
    banco.setContadorConta(numeroConta + 1);
    return conta; 
}
    public void sacar(int numeroConta, double valor){
        Conta conta = banco.buscarContaPorNumero(numeroConta);
        if (conta == null) {
    
            throw new IllegalArgumentException("Conta não encontrada");

        }
        conta.sacar(valor);
        ContaDAO.atualizarSaldo(numeroConta, conta.getSaldo());
    }

    public void depositar(int numeroConta, double valor){
        Conta conta = banco.buscarContaPorNumero(numeroConta);
        if (conta == null){

            throw new IllegalArgumentException("Conta não encontrada");
        }
        conta.depositar(valor);
        ContaDAO.atualizarSaldo(numeroConta, conta.getSaldo());
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor){
        Conta contaOrigem = banco.buscarContaPorNumero(numeroContaOrigem);
        if (contaOrigem == null){

            throw new IllegalArgumentException("Conta de origem não encontrada");
        }
        Conta contaDestino = banco.buscarContaPorNumero(numeroContaDestino);
        if (contaDestino == null){

            throw new IllegalArgumentException("Conta de destino não encontrada");
        }
        contaOrigem.sacar(valor);
        ContaDAO.atualizarSaldo(numeroContaDestino, contaOrigem.getSaldo());
        contaDestino.depositar(valor);
        ContaDAO.atualizarSaldo(numeroContaDestino, contaDestino.getSaldo());
    }

    public double consultarSaldo(int numeroConta){
        Conta conta = banco.buscarContaPorNumero(numeroConta);
        if(conta == null){

            throw new IllegalArgumentException("Conta não encontrada");
        }
        return conta.getSaldo();

    }
}