package SistemaBancario.model;

import java.sql.*;

public class ContaDAO {
    
    public void salvar(Conta conta) {
        String sql = "INSERT INTO contas (numeroConta, saldo, tipoConta, idCliente) VALUES (?, ?, ?, ?)";
            try{
                PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);
                stmt.setInt(1, conta.getNumeroConta());
                stmt.setDouble(2, conta.getSaldo());
                stmt.setString(3, conta.getTipoConta());
                stmt.setInt(4, conta.getTitular().getId());
                stmt.execute();
                } catch (SQLException e){
                    throw new RuntimeException("Erro  ao salvar conta: " + e.getMessage());
                }
    }

    public Conta buscarPorConta(int numeroConta){
        String sql = "SELECT * FROM contas WHERE numeroConta = ?";
        try{
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);
            stmt.setInt(1, numeroConta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ClienteDAO clienteDAO = new ClienteDAO();
                Cliente titular = clienteDAO.buscarPorId(rs.getInt("idCliente"));
                String tipo = rs.getString("tipoConta");
                if (tipo.equals("corrente")) {
                return new ContaCorrente(
                rs.getInt("numeroConta"), 
                rs.getDouble("saldo"),   
                tipo, titular, 500.00);  
            
                } else {
                return new ContaPoupanca(
                rs.getInt("numeroConta"),
                rs.getDouble("saldo"),
                tipo, titular);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar conta: " + e.getMessage());
        }
        return null;
    }

    public void atualizarSaldo(int numeroConta, double novoSaldo) {
        String sql = "UPDATE contas SET saldo = ? WHERE numeroConta = ?";
        try{
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);
            stmt.setDouble(1, novoSaldo);
            stmt.setInt(2, numeroConta);
            stmt.execute();
            }catch (SQLException e){
                throw new RuntimeException("Erro ao atualizar saldo: " + e.getMessage());
            }     
    }
}
