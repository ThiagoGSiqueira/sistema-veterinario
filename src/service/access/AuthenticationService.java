package service.access;

import dao.UserDAO;
import dto.access.AuthenticationDTO;
import model.User;

import java.sql.SQLException;

public class  AuthenticationService {
    public User authenticate(AuthenticationDTO authenticationDTO) throws SQLException {
        UserDAO userDAO = new UserDAO();
        return userDAO.findByEmailAndPassword(authenticationDTO.getEmail(), authenticationDTO.getPassword());
    }
}
