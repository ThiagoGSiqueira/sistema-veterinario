package view.access;

import dto.access.CreateUserAccountDTO;
import dto.access.CreateVeterinarianAccountDTO;
import enums.domain.Role;
import model.User;

import java.util.Scanner;

public class CreateAccountView {
    Scanner sc = new Scanner(System.in);
    public CreateUserAccountDTO createAccountUser() {
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.print("Digite seu e-mail: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String password = sc.nextLine();
        System.out.print("Digite seu cargo (Cliente, Veterinario, Admin): ");
        String role = sc.nextLine();

        return new CreateUserAccountDTO(name, email, password, Role.fromString(role));
    }

    public CreateVeterinarianAccountDTO createAccountVeterinarian() {
        System.out.print("Digite seu CRMV (111111SP): ");
        String crmv = sc.nextLine();
        System.out.print("Digite seu número: ");
        String numero = sc.nextLine();

        return new CreateVeterinarianAccountDTO(crmv, numero, null);
    }

    public void showLoginSucess (User user) {
        System.out.println("Sua conta foi criada!");
        System.out.println("Seja bem vindo - " + user.getName() + "!");
    }
}
