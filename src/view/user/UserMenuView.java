package view.menu;

import enums.menu.MainMenuUser;
import model.User;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenuView {

    Scanner sc = new Scanner(System.in);

    public MainMenuUser getUserMenuChoice(User loggedUser) {
        System.out.println("===========================");
        System.out.println("Bem vindo(a), " + loggedUser.getName());
        System.out.println("===========================");
        System.out.println();

        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1 - Gerenciar Conta");
        System.out.println("2 - Gerenciar Pet");
        System.out.println("3 - Gerenciar Consultas");
        System.out.println("0 - Sair");

        System.out.print("Selecione uma opção: ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                return MainMenuUser.MANAGE_ACCOUNT;
            case 2:
                return MainMenuUser.MANAGE_PET;
            case 3:
                return MainMenuUser.MANAGE_CONSULTATION;
            case 0:
                return MainMenuUser.EXIT;
            default:
                return null;
        }
    }
}
