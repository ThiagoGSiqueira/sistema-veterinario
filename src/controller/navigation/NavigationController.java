package controller.navigation;

import controller.management.AdminMenuController;
import controller.management.UserMenuController;
import controller.management.VeterinarianMenuController;
import enums.domain.Role;
import model.User;

import java.sql.SQLException;

public class NavigationController {
    public void routeToMenuByRole(User loggedUser) throws SQLException {
        if (Role.CLIENT.equals(loggedUser.getRole())) {
            UserMenuController userMenuController = new UserMenuController();
            userMenuController.start(loggedUser);
        } else if  (Role.ADMIN.equals(loggedUser.getRole())) {
            AdminMenuController adminMenuController = new AdminMenuController();
            adminMenuController.start(loggedUser);
        } else if (Role.VETERINARIAN.equals(loggedUser.getRole())) {
            VeterinarianMenuController veterinarianMenuController = new VeterinarianMenuController();
            veterinarianMenuController.start(loggedUser);
        }
    }
}
