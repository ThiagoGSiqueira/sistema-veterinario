import dao.PetDAO;
import dao.UsuarioDAO;
import model.Pet;
import model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        PetDAO petDAO = new PetDAO();

        Usuario a1 = new Usuario("Admin", "admin@pet.com", "admin", "ADMIN");
        Usuario u1 = new Usuario("Thiago", "thiago@gmail.com", "thiago123", "Cliente");
        Usuario u2 = new Usuario("Riane", "riane@gmail.com", "riane123", "Cliente");

        Pet p1 = new Pet("Morgana", "pequeno", "gato", LocalDate.of(2025, 5, 12), 3);
        Pet p2 = new Pet("Dracula", "pequeno", "gato", LocalDate.of(2025, 5, 12), 3);
        Pet p3 = new Pet("Meg", "Médio", "Cachorro", LocalDate.of(2020, 3, 12), 2);

        try {

            List<Usuario> usuarios = usuarioDAO.listarUsuarios();

            for (Usuario u : usuarios) {
                u.setPets(petDAO.listarPetsPorDono(u.getIdUsuario()));

                System.out.println(u);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

    }
}