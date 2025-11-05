package util;

import resources.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConexao() {
        Connection conn = null;

        try {
            System.out.println("Conectando com o banco de dados");
            conn = DriverManager.getConnection(DatabaseConfig.getUrl(), DatabaseConfig.getUsername(), DatabaseConfig.getPassword());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco. " + e.getMessage());
        }

        return conn;
    }
}
