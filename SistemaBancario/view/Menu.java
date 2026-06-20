package SistemaBancario.view;

import java.util.Scanner;
import SistemaBancario.controller.ClienteController;
import SistemaBancario.controller.ContaController;
import SistemaBancario.model.Banco;
import SistemaBancario.model.Cliente;
import SistemaBancario.model.Conta;
import SistemaBancario.model.BancoDB;

public class Menu {
    private Scanner scanner;
    private ClienteController clienteController;
    private ContaController contaController;

    public Menu(ClienteController clienteController, ContaController contaController) {
        this.clienteController = clienteController;
        this.contaController = contaController;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BancoDB.criarTabelas();
        Banco banco = new Banco();
        ClienteController clienteController = new ClienteController(banco);
        ContaController contaController = new ContaController(banco);
        Menu menu = new Menu(clienteController, contaController);
        menu.exibirMenu();

    }

public void exibirMenu(){
    while (true) {
  
        System.out.println("\n1 - Cadastrar cliente ");

        System.out.println("2 - Buscar cliente ");

        System.out.println("3 - Abrir conta");

        System.out.println("4 - Sacar");

        System.out.println("5 - Depositar");
    
        System.out.println("6 - Transferir");
       
        System.out.println("7 - Consultar saldo");
    
        System.out.println("8 - Sair");
   
        int opcao = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcao) {

            case 1:
              
            try{
            System.out.println(" \n Digite seu nome");
            String nome = scanner.nextLine();
            System.out.println("Digite seu CPF");
            String cpf = scanner.next();
            System.out.println("Digite seu email");
            String email = scanner.next();
            System.out.println("Digite sua senha");
            String senha = scanner.next();
            Cliente novo = clienteController.cadastrarCliente(nome, cpf, email, senha); 
            System.out.println(" \n Cliente cadastrado com sucesso, seu novo ID é: " + novo.getId());
            } catch (IllegalArgumentException e) {

                System.out.println("*************************");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("*************************");
            }

            
            break;
        
        
            case 2:
            try{
            System.out.println("Digite o Id do cliente que deseja encontrar");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();
            clienteController.autenticarCliente(id, senha);
            Cliente c = clienteController.buscarCliente(id);
            String[] partes = c.getNome().split(" ");
            String nomeExibido = partes[0];
            if (partes.length > 1) nomeExibido += " " + partes[1];
            String ultimosDigitos = c.getCpf().substring(c.getCpf().length() - 3);
            System.out.println("Cliente encontrado!");
            System.out.println("Nome: " + nomeExibido);
            System.out.println("CPF: ***.***.**" + ultimosDigitos);
            } catch (IllegalArgumentException e){
            System.out.println("*************************");
            System.out.println("Erro: " + e.getMessage());
            System.out.println("*************************");
            }
            break;

            case 3: 
            try{
            System.out.println("Digite seu dígito de cliente");
            int idCliente = scanner.nextInt();
            Cliente cliente = clienteController.buscarCliente(idCliente);
            System.out.println("Escolha o itpo de conta: corrente ou poupanca");
            String tipoConta = scanner.next();
            Conta novaConta = contaController.abrirConta(cliente, tipoConta);
            System.out.println("Conta aberta, o número da sua conta é: " + novaConta.getNumeroConta());
            } catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
            }
            break;

            case 4: 
            try{
            System.out.println("Digite o seu ID");
            int idCliente = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite sua senha");
            String senha = scanner.nextLine();
            clienteController.autenticarCliente(idCliente, senha);
            System.out.println("Digite o número de sua conta");
            int numConta = scanner.nextInt();
            System.out.println("Digite o valor do saque que deseja realizar");
            double sacar = scanner.nextDouble();
            contaController.sacar(numConta, sacar);
            System.out.println("Operação realizada com sucesso. Seu novo saldo é " + contaController.consultarSaldo(numConta));
            } catch (IllegalArgumentException e) {
                System.out.println("*************************");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("*************************"); 
            }
            break;

            case 5:
            try{
            System.out.println("Digite seu ID");
            int idCliente = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite sua senha");
            String senha = scanner.nextLine(); 
            clienteController.autenticarCliente(idCliente, senha);
           System.out.println("Digite o número da sua conta");
            int numConta = scanner.nextInt();
            System.out.println("Digite o valor que deseja depositar");
            double valor = scanner.nextDouble();
            contaController.depositar(numConta, valor);
            System.out.println("Operação realizada com sucesso. Seu novo saldo é " + contaController.consultarSaldo(numConta));
            } catch(IllegalArgumentException e){
                System.out.println("*************************");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("*************************");
            }
                break;
            
             case 6:
            try{
            System.out.println("Digite seu digito");
            int idCliente1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite sua senha");
            String senha = scanner.nextLine();
            clienteController.autenticarCliente(idCliente1, senha);
             System.out.println("Digite o número de sua conta");
            int contaOrigem = scanner.nextInt();
            System.out.println("Digite o número  da conta que você deseja transferir");
            int contaDestino = scanner.nextInt();
            System.out.println("Digite o valor que você deseja transferir");
            double valor = scanner.nextDouble();
            contaController.transferir(contaOrigem, contaDestino, valor);
            double saldoAtual = contaController.consultarSaldo(contaOrigem);
            System.out.println("transferência realizada com sucesso!");
            System.out.println("Operação realizada com sucesso. Seu novo saldo é " + saldoAtual);
            } catch(IllegalArgumentException e){
                System.out.println("*************************");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("*************************");
            }
                break;

            case 7: 
            try{
            System.out.println("Digite o número da sua conta para consultar seu saldo");
            int numeroConta = scanner.nextInt();
            double saldoAtual = contaController.consultarSaldo(numeroConta);
            System.out.println("Seu saldo atual é: R$ " + saldoAtual);
            } catch(IllegalArgumentException e){
                System.out.println("*************************");
                System.out.println("Erro: " + e.getMessage());
                System.out.println("*************************");
            }
                break;
            
            case 8:
                System.out.println("Saindo...");
                return;


            default:
                System.out.println("Opção inválida!");
                break;
    
        }
    }
}
}