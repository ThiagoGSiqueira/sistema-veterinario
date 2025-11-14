package dao;

import com.mysql.cj.jdbc.result.UpdatableResultSet;
import model.Pet;
import model.Usuario;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    //Adicionar pet
    //Remover pet
    //Listar TODOS os pets
    //Listar pet por dono
    //Atualizar pet

    public int criarPet(Pet pet) throws SQLException {
        String sql = "INSERT INTO pet (nome, porte, especie, data_nascimento, id_usuario) VALUES (?, ?, ?, ?, ?)";
        int linhasAfetadas = 0;

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pet.getNome());
            ps.setString(2, pet.getPorte());
            ps.setString(3, pet.getEspecie());
            ps.setDate(4, java.sql.Date.valueOf(pet.getData_nascimento()));
            ps.setInt(5, pet.getIdUsuario());
            linhasAfetadas = ps.executeUpdate();

            return linhasAfetadas;
        }
    }

    public int removerPet(int idPet) throws SQLException {
        String sql = "DELETE FROM pet WHERE id_pet = ?";
        int linhasAfetadas = 0;
        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPet);
            linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas;
        }
    }

    public List<Pet> listarPetsPorDono(int idUsuario) throws SQLException {

        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT * FROM pet WHERE id_usuario = ?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet p = new Pet(
                        rs.getInt("id_pet"),
                        rs.getString("nome"),
                        rs.getString("porte"),
                        rs.getString("especie"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getInt("id_usuario")
                );
                pets.add(p);
            }
            return pets;
        }
    }

    public List<Pet> listarPets() throws SQLException {
        String sql = "SELECT * FROM pet";
        List<Pet> pets = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {

           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
               Pet pet = new Pet(
                       rs.getInt("id_pet"),
                       rs.getString("nome"),
                       rs.getString("porte"),
                       rs.getString("especie"),
                       rs.getDate("data_nascimento").toLocalDate(),
                       rs.getInt("id_usuario")
               );
           }
            return pets;
        }
    }

    public int atualizarPet(int idPet, Pet pet) throws SQLException {
        String sql = "UPDATE pet SET nome=? WHERE id_pet = ?";
        int linhasAfetadas = 0;

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pet.getNome());
            ps.setInt(2, idPet);

            linhasAfetadas = ps.executeUpdate();
            return linhasAfetadas;
        }
    }
}
