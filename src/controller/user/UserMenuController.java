package controller.management;

import enums.menu.MainMenuUser;
import model.User;
import view.menu.UserMenuView;

import java.sql.SQLException;

public class UserMenuController {
    public void start(User loggedUser) throws SQLException {
        UserMenuView userMenuView = new UserMenuView();
        MainMenuUser mainMenuUser = userMenuView.getUserMenuChoice(loggedUser);

        switch (mainMenuUser) {
            case MainMenuUser.MANAGE_ACCOUNT:
                System.out.println("Gerenciar conta");
                break;
            case MainMenuUser.MANAGE_PET:
                System.out.println("Gerenciar pet");
            case MainMenuUser.MANAGE_CONSULTATION:
                System.out.println("Gerenciar consulta");
            case MainMenuUser.EXIT:
                System.out.println("Sair");
        }

    }
}
