package SistemaBancario.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
    private static final String URL = "jdbc:sqlite:banco.db";
    private static Connection conexao;

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection(URL);
                System.out.println("Banco de dados conectado!");
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver não encontrado: " + e.getMessage());
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        try {
            if (conexao != null) conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar: " + e.getMessage());
        }
    }
}