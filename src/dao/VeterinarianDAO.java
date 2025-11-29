package dao;

import model.Veterinarian;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDAO {

    public int save(Veterinarian veterinarian) throws SQLException {
        String sql = "INSERT INTO veterinarian(crmv, phone_number, user_id) VALUES (?,?,?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, veterinarian.getCrmv());
            ps.setString(2, veterinarian.getPhoneNumber());
            ps.setInt(3, veterinarian.getUserId());

            return ps.executeUpdate();
        }
    }

    public List<Veterinarian> findAll() throws SQLException {
        String sql = "SELECT * FROM veterinario";
        List<Veterinarian> veterinarians = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Veterinarian veterinarian = new Veterinarian(
                        rs.getString("crmv"),
                        rs.getString("telefone"),
                        rs.getInt("id_usuario")
                );

                veterinarians.add(veterinarian);
            }
        }
        return veterinarians;
    }

    public Veterinarian findById(int userId) throws SQLException {
        String sql = "SELECT * FROM veterinarian WHERE id_usuario = ?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new Veterinarian(
                        rs.getString("crmv"),
                        rs.getString("phone_number"),
                        rs.getInt("user_id")
                );
            }
        }
        return null;
    }

    public int update(Veterinarian veterinarian, int userId) throws SQLException {
        String sql = "UPDATE veterinario SET crmv=?, phone_number=? WHERE user_id=?";
        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, veterinarian.getCrmv());
            ps.setString(2, veterinarian.getPhoneNumber());
            ps.setInt(3, userId);
            return ps.executeUpdate();
        }
    }

    public int deleteById(int userId) throws SQLException {
        String sql = "DELETE FROM veterinario WHERE user_id=?";

        try(Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, userId);
            return ps.executeUpdate();
        }
    }
}
