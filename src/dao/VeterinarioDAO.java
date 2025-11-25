package dao;

import model.Veterinario;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO {
    //Criar Veterinario
    //Listar Veterinarios & Veterinario por id
    //Atualizar Veterinario
    //Remover Veterinario

    public int criarVeterinario(Veterinario veterinario) throws SQLException {
        String sql = "INSERT INTO veterinario(crmv, telefone, id_usuario) VALUES (?,?,?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, veterinario.getCrmv());
            ps.setString(2, veterinario.getTelefone());
            ps.setInt(3, veterinario.getIdUsuario());

            return ps.executeUpdate();
        }
    }

    public List<Veterinario> buscarVeterinarios() throws SQLException {
        String sql = "SELECT * FROM veterinario";
        List<Veterinario> veterinarios = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Veterinario veterinario = new Veterinario(
                        rs.getString("crmv"),
                        rs.getString("telefone"),
                        rs.getInt("id_usuario")
                );

                veterinarios.add(veterinario);
            }
        }
        return veterinarios;
    }

    public Veterinario buscarVeterinarioPorId(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM veterinario WHERE id_usuario = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Veterinario veterinario = new Veterinario(
                        rs.getString("crmv"),
                        rs.getString("telefone"),
                        rs.getInt("id_usuario")
                );
                return veterinario;
            }
        }
        return null;
    }

    public int atualizarVeterinario(Veterinario vet, int idUsuario) throws SQLException {
        String sql = "UPDATE veterinario SET crmv=?, telefone=? WHERE idUsuario=?";
        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, vet.getCrmv());
            ps.setString(2, vet.getTelefone());
            ps.setInt(3, idUsuario);
            return ps.executeUpdate();
        }
    }

    public int removerVeterinario(int idUsuario) throws SQLException {
        String sql = "DELETE FROM veterinario WHERE idUsuario=?";

        try(Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idUsuario);
            return ps.executeUpdate();
        }
    }
}
