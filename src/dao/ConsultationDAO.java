package dao;

import model.Consultation;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDAO {

    public int save(Consultation consultation) throws SQLException {
        String sql = "INSERT INTO consultation (pet_id, consultation_date, reason, diagnosis, " +
                "price, status, client_user_id, veterinarian_user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, consultation.getPetId());
            ps.setDate(2, java.sql.Date.valueOf(consultation.getConsultationDate()));
            ps.setString(3, consultation.getReason());
            ps.setString(4, consultation.getDiagnosis());
            ps.setDouble(5, consultation.getPrice());
            ps.setString(6, consultation.getStatus());
            ps.setInt(7, consultation.getUserClientId());
            ps.setInt(8, consultation.getUserVeterinarianId());

            return ps.executeUpdate();
        }
    }


    public List<Consultation> findByUserId(int userId) throws SQLException {
        List<Consultation> consultations = new ArrayList<>();
        String sql = "SELECT * FROM consultation WHERE client_user_id=? OR veterinarian_user_id=? ";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consultation consultation = new Consultation(
                        rs.getInt("pet_id"),
                        rs.getDate("consultation_date").toLocalDate(),
                        rs.getString("reason"),
                        rs.getString("diagnosis"),
                        rs.getDouble("price"),
                        rs.getString("status"),
                        rs.getInt("client_user_id"),
                        rs.getInt("veterinarian_user_id"),
                        rs.getInt("consultation_id")
                );
                consultations.add(consultation);
            }
            return consultations;
        }
    }

    public List<Consultation> findAll() throws SQLException {
        List<Consultation> consultations = new ArrayList<>();
        String sql = "SELECT * FROM consultation";
        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consultation consultation = new Consultation(
                        rs.getInt("pet_id"),
                        rs.getDate("consultation_date").toLocalDate(),
                        rs.getString("reason"),
                        rs.getString("diagnosis"),
                        rs.getDouble("price"),
                        rs.getString("status"),
                        rs.getInt("client_user_id"),
                        rs.getInt("veterinarian_user_id"),
                        rs.getInt("consultation_id")
                );
                consultations.add(consultation);
            }
            return consultations;
        }
    }

    public int reschedule(int consultationId, LocalDate newDate) throws SQLException {
        String sql = "UPDATE consultation SET data_consulta=? WHERE id_consulta=?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(newDate));
            ps.setInt(2, consultationId);

            return ps.executeUpdate();
        }
    }

    public int deleteById(int consultationId) throws SQLException {
        String sql = "DELETE FROM consultation WHERE id_consulta=?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, consultationId);
            return ps.executeUpdate();
        }
    }
}
