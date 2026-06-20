package SistemaBancario.controller;
import SistemaBancario.model.Banco;
import SistemaBancario.model.Cliente;
import SistemaBancario.model.ClienteDAO;
public class ClienteController {
    private Banco banco;
    private ClienteDAO ClienteDAO;

    public ClienteController(Banco banco) {
        this.banco = banco;
        this.ClienteDAO = new ClienteDAO();
        }        
    

    public Cliente cadastrarCliente(String nome, String cpf, String email, String senha){
        for (int i = 0; i < nome.length(); i++ ) {
            char c = nome.charAt(i);
            if (Character.isDigit(c)) {
            
            throw new IllegalArgumentException(" NOME NÃO PODE CONTER NUMEROS!");                
            }
        }

        for(int o = 0; o < cpf.length(); o++ ){
            char d = cpf.charAt(o);
            if (Character.isLetter(d)){
                throw new IllegalArgumentException("CPF NÃO PODE CONTER LETRAS!");
            }
        }
        if (!email.contains("@")){
            throw new IllegalArgumentException("EMAIL PRECISA TER @");
        }

          if (senha.length() <= 8){
           throw new IllegalArgumentException("SENHA PRECISA TER NO MINIMO 8 DIGITOS"); 
        }
        boolean temMaiuscula = false;
        boolean temNumero = false;

        for(int iSenha = 0; iSenha < senha.length(); iSenha++){
            char cSenha = senha.charAt(iSenha);

 
            if (Character.isUpperCase(cSenha)) {
            temMaiuscula = true;
        }

        if(Character.isDigit(cSenha)){
            temNumero = true;
        }
        }
         if (!temMaiuscula) {
            throw new IllegalArgumentException ("A SENHA PRECISA TER PELOMENOS 1 LETRA MAIUSCULA!");
        }

        if (!temNumero) {
            throw new IllegalArgumentException("A SENHA PRECISA TER PELOMENOS 1 NÚMERO!");
        }

       
        int id = banco.getContadorId();
        Cliente cliente = new Cliente(id, nome, cpf, senha, email);
        banco.adicionarCliente(cliente);
        ClienteDAO.salvar(cliente);
        banco.setContadorId(id + 1);
        return cliente;
    }

    public Cliente buscarCliente(int id){
        Cliente cliente = banco.buscarClientePorId(id);
            if(cliente == null){
                throw new IllegalArgumentException("Cliente não encontrado!");
            } else {
                return cliente;
            }
        
    }   

    public Cliente autenticarCliente(int id, String senha){
    Cliente cliente = buscarCliente(id);
    if (!cliente.getSenha().equals(senha)) {
        throw new IllegalArgumentException("Senha incorreta!"); 
    }
    return cliente;
    }

    public void atualizarCliente(int id, String novoNome, String novoEmail){
        Cliente cliente = buscarCliente(id);
        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);

    }

    public void removerCliente(int id){
        Cliente cliente = buscarCliente(id);
        banco.getClientes().remove(cliente);
        ClienteDAO.remover(id);
    }
}

