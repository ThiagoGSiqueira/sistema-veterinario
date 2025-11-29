package view.access;

import dto.access.AuthenticationDTO;
import model.User;

import java.util.Scanner;

public class AuthenticationView {

    Scanner sc = new Scanner(System.in);

    public AuthenticationDTO authenticateMenu() {
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite seu senha: ");
        String senha = sc.nextLine();

        return new AuthenticationDTO(email, senha);
    }

    public void showAuthenticateSucess(User usuario) {
        if (usuario != null) {
            System.out.println(usuario.getName() + ", seja bem-vindo!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
