import controller.acess.InitialMenuController;
import dao.UserDAO;
import enums.domain.Role;
import model.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        InitialMenuController initialMenuController = new InitialMenuController();
        initialMenuController.start();
    }
}