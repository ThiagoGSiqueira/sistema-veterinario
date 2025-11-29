package service.access;

import dao.UserDAO;
import dao.VeterinarianDAO;
import dto.access.CreateUserAccountDTO;
import dto.access.CreateVeterinarianAccountDTO;
import model.User;
import model.Veterinarian;

import java.sql.SQLException;

public class CreateAccountService {

    public User createAccount(CreateUserAccountDTO userDTO, CreateVeterinarianAccountDTO veterinarianDTO) throws SQLException {
        UserDAO userDAO = new UserDAO();
        VeterinarianDAO veterinarianDAO = new VeterinarianDAO();

        User user = new User(
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
        );

        int userId = userDAO.save(user);
        user.setIdUsuario(userId);

        if (veterinarianDTO != null) {
            Veterinarian veterinarian = new Veterinarian(veterinarianDTO.getCrmv(), veterinarianDTO.getPhoneNumber(), userId);
            veterinarianDAO.save(veterinarian);
        }
        return user;
    }
}
