package dao;

import model.Consulta;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    //Marcar uma consulta (Criar)
    //Listar consultas
    //Atualizar data da consulta (remarcar)
    //Para um veterinário, todas as consultas referentes a ele
    //Para um cliente, todas as consultas referente a ele
    //Para um adminstrador, pensar em filtros, talvez por id de veterinario ou por id de cliente ou todas as consultas
    //Desmarcar consulta (Remover)


    public int marcarConsulta(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta (id_pet, data_consulta, motivo, diagnostico, " +
                "valor, status, id_usuario_cliente, id_usuario_veterinario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, consulta.getIdPet());
            ps.setDate(2, java.sql.Date.valueOf(consulta.getDataConsulta()));
            ps.setString(3, consulta.getMotivo());
            ps.setString(4, consulta.getDiagnostico());
            ps.setDouble(5, consulta.getValor());
            ps.setString(6, consulta.getStatus());
            ps.setInt(7, consulta.getIdUsuarioCliente());
            ps.setInt(8, consulta.getIdUsuarioVeterinario());

            return ps.executeUpdate();
        }
    }


    public List<Consulta> buscaConsultasPorUsuario(int idUsuario) throws SQLException {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta WHERE id_usuario_cliente=? OR id_usuario_veterinario=? ";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.setInt(2, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta(
                        rs.getInt("id_pet"),
                        rs.getDate("data_consulta").toLocalDate(),
                        rs.getString("motivo"),
                        rs.getString("diagnostico"),
                        rs.getDouble("valor"),
                        rs.getString("status"),
                        rs.getInt("id_usuario_cliente"),
                        rs.getInt("id_usuario_veterinario"),
                        rs.getInt("id_consulta")
                );
                consultas.add(consulta);
            }
            return consultas;
        }
    }

    public List<Consulta> buscaTodasConsultas() throws SQLException {
        List<Consulta> consultas = new ArrayList<>();
        String sql =  "SELECT * FROM consulta";
        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta(
                        rs.getInt("id_pet"),
                        rs.getDate("data_consulta").toLocalDate(),
                        rs.getString("motivo"),
                        rs.getString("diagnostico"),
                        rs.getDouble("valor"),
                        rs.getString("status"),
                        rs.getInt("id_usuario_cliente"),
                        rs.getInt("id_usuario_veterinario"),
                        rs.getInt("id_consulta")
                );
                consultas.add(consulta);
            }
            return consultas;
        }
    }

    public int atualizarConsulta(int idConsulta, LocalDate novaData) throws SQLException {
        String sql = "UPDATE consulta SET data_consulta=? WHERE id_consulta=?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(novaData));
            ps.setInt(2, idConsulta);

            return ps.executeUpdate();
        }
    }

    public int desmarcarConsulta(int idConsulta) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id_consulta=?";

        try (Connection conn = DatabaseConnection.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idConsulta);
            return ps.executeUpdate();
        }
    }
}
