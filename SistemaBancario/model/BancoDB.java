package SistemaBancario.model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;


public class BancoDB {
    public static void criarTabelas(){
        String sqlClientes = "CREATE TABLE IF NOT EXISTS clientes ("
        + "id integer primary key,"
        + "nome text not null,"
        + "cpf text not null,"
        + "email text not null,"
        + "senha text not null)";
     

    String sqlContas = "CREATE TABLE IF NOT EXISTS contas ("
        + "numeroConta integer primary key,"
        + "saldo REAL not null,"
        + "tipoConta text not null,"
        + "idCliente integer," 
        + "foreign key (idCliente) references clientes(id))";

    try {
        Connection conn = ConexaoDB.getConexao();
        Statement stmt = conn.createStatement();
        stmt.execute(sqlContas);
        stmt.execute(sqlClientes);
        System.out.println("Tabelas criadas com sucesso!");
               } catch (SQLException e) {
        throw new RuntimeException("Erro ao criar tabela: " + e.getMessage());
               }
            }
}
