package dao;

import model.Usuario;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    //Criar usuário // ADMIN & Cliente
    //Autenticar usuário // ADMIN & Cliente
    //Listar contas //ADMIN -> Retorna apenas usuarios do tipo Cliente
    //Remover usuario //ADMIN
    public Usuario criarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha, cargo) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getCargo());
            int linhasAfetadas = ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
            }

            if (linhasAfetadas > 0) {
                System.out.println("Usuário de ID: " + usuario.getIdUsuario() + " & Nome:" + usuario.getNome() + " foi criado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return usuario;
    }

    public Usuario autenticar(String email, String senha) {
        String sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            Usuario usuario = null;

            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                System.out.println("Autenticado!");
                return usuario;
            }
            System.out.println("Esse usuário não existe");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuario WHERE cargo = 'CLIENTE'";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id_usuario"));
                System.out.println(rs.getString("nome"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("senha"));
                System.out.println(rs.getString("cargo"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerUsuario(int idUsuario) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuario deletado!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
