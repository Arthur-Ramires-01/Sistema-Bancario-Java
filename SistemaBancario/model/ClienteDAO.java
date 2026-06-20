package SistemaBancario.model;

import java.sql.*;
public class ClienteDAO {

    public void salvar(Cliente cliente){
    String sql = "INSERT INTO clientes (id, nome, cpf, email, senha) VALUES ( ?, ?, ?, ?, ?)";
    try {
        PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);
        stmt.setInt(1, cliente.getId());
        stmt.setString(2, cliente.getNome());
        stmt.setString(3, cliente.getCpf());
        stmt.setString(4, cliente.getEmail());
        stmt.setString(5, cliente.getSenha());
        stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    public Cliente buscarPorId(int id){
        String sql = "SELECT * FROM clientes WHERE id =  ?";
        try{
        PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Cliente(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("cpf"),
            rs.getString("senha"),
            rs.getString("email"));
        } 

            }catch(SQLException e){
                throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
            }      
            return null;
    }
    public void remover (int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            PreparedStatement stmt = ConexaoDB.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            }catch(SQLException e){
                throw new RuntimeException("Erro ao remover cliente: " + e.getMessage());
            }
    }
}