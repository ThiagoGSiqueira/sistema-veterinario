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
    //Buscar usuario por id, retorna um usuario
    public int criarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nome, email, senha, cargo) VALUES (?, ?, ?, ?)";
        int linhasAfetadas = 0;

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getCargo());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
            }
            return usuario.getIdUsuario();
        }
    }

    public Usuario autenticar(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ? and  senha = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            Usuario usuario = null;

            ps.setString(1, email);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                return usuario;
            }
            return null;
        }
    }

    public Usuario buscarUsuarioPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        Usuario u = null;
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                u = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cargo")
                );
            }
            return u;
        }
    }

    public List<Usuario> buscarUsuarios() throws SQLException {
        String sql = "SELECT * FROM usuario WHERE cargo = 'CLIENTE' OR cargo = 'VETERINARIO'";
        List<Usuario> usuarios = new ArrayList<>();


        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cargo")
                );
                usuarios.add(usuario);
            }
            return usuarios;
        }
    }

    public int removerUsuario(int idUsuario) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        int linhasAfetadas = 0;
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            linhasAfetadas = ps.executeUpdate();

            return linhasAfetadas;

        }
    }
}
