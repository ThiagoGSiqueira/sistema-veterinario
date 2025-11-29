package dao;

import model.Pet;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    public int save(Pet pet) throws SQLException {
        String sql = "INSERT INTO pet (name, size, species, birth_date, user_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pet.getName());
            ps.setString(2, pet.getSize());
            ps.setString(3, pet.getSpecie());
            ps.setDate(4, java.sql.Date.valueOf(pet.getBirthDate()));
            ps.setInt(5, pet.getIdUsuario());
            return ps.executeUpdate();

        }
    }

    public int deleteById(int petId) throws SQLException {
        String sql = "DELETE FROM pet WHERE pet_id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, petId);
            return ps.executeUpdate();
        }
    }

    public List<Pet> findByUserId(int userId) throws SQLException {

        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT * FROM pet WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pet pet = new Pet(
                        rs.getInt("pet_id"),
                        rs.getString("name"),
                        rs.getString("size"),
                        rs.getString("species"),
                        rs.getDate("birth_date").toLocalDate(),
                        rs.getInt("user_id")
                );
                pets.add(pet);
            }
            return pets;
        }
    }

    public List<Pet> findAll() throws SQLException {
        String sql = "SELECT * FROM pet";
        List<Pet> pets = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql)) {

           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
               Pet pet = new Pet(
                       rs.getInt("pet_id"),
                       rs.getString("name"),
                       rs.getString("size"),
                       rs.getString("species"),
                       rs.getDate("birth_date").toLocalDate(),
                       rs.getInt("user_id")
               );
               pets.add(pet);
           }
            return pets;
        }
    }
}
