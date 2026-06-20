package SistemaBancario.model;
import java.util.ArrayList;
public class Banco {

    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;
    private int contadorId;
    private int contadorConta;

    public Banco(){
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
        this.contadorId = 1;
        this.contadorConta = 1001;
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }


 
    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
            
        }
    
    public Cliente buscarClientePorId(int id){
        for (Cliente cliente : clientes) {
        if(cliente.getId() == id){
            return cliente;
        }    
    }
        return null;
    }

    public Conta buscarContaPorNumero(int id){
        for (Conta conta : contas) {
        if(conta.getNumeroConta() == id){
            return conta;
        }
    }
        return null;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public ArrayList<Conta> getContas() {
        return contas;
    }
    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    public int getContadorId() {
        return contadorId;
    }
    public void setContadorId(int contadorId) {
        this.contadorId = contadorId;
    }
    public int getContadorConta() {
        return contadorConta;
    }
    public void setContadorConta(int contadorConta) {
        this.contadorConta = contadorConta;
    }




}
