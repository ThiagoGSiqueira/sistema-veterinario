package controller.acess;

import controller.navigation.NavigationController;
import dto.access.CreateUserAccountDTO;
import dto.access.CreateVeterinarianAccountDTO;
import enums.domain.Role;
import enums.menu.MenuOption;
import model.User;
import service.access.AuthenticationService;
import service.access.CreateAccountService;
import view.access.AuthenticationView;
import view.access.CreateAccountView;
import view.access.InitialMenuView;

import java.sql.SQLException;

public class InitialMenuController {

    public void start() throws SQLException {
        User loggedUser = null;
        InitialMenuView menu = new InitialMenuView();
        NavigationController navigationController = new NavigationController();

        MenuOption option = menu.showMenu();

        switch (option) {
            case MenuOption.AUTHENTICATE:
                AuthenticationService authenticationService = new AuthenticationService();
                AuthenticationView authenticationView = new AuthenticationView();
                loggedUser = authenticationService.authenticate(authenticationView.authenticateMenu());
                authenticationView.showAuthenticateSucess(loggedUser);

                navigationController.routeToMenuByRole(loggedUser);

                break;
            case MenuOption.CREATE_ACCOUNT:
                CreateAccountView createAccountView = new CreateAccountView();
                CreateUserAccountDTO userDTO = createAccountView.createAccountUser();
                CreateVeterinarianAccountDTO veterinarianDTO = null;
                if (Role.VETERINARIAN.equals(userDTO.getRole())) {
                    veterinarianDTO = createAccountView.createAccountVeterinarian();
                }

                CreateAccountService createAccountService = new CreateAccountService();
                loggedUser = createAccountService.createAccount(userDTO, veterinarianDTO);
                createAccountView.showLoginSucess(loggedUser);
                navigationController.routeToMenuByRole(loggedUser);
                break;
            case MenuOption.EXIT:
                return;
        }
    }
}
