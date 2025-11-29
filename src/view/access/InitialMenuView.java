package view.access;

import enums.menu.MenuOption;

import java.util.Scanner;

public class InitialMenuView {
    Scanner sc = new Scanner(System.in);

    public MenuOption showMenu() {
        System.out.println("Bem vindo -- Escolha uma opção:");
        System.out.println("[ 1 ] Autenticar");
        System.out.println("[ 2 ] Criar Conta");
        System.out.println("[ 3 ] Sair");
        System.out.print(">>> ");

        int option = sc.nextInt();

        switch (option) {
            case 1:
                return MenuOption.AUTHENTICATE;
            case 2:
                return MenuOption.CREATE_ACCOUNT;
            case 3:
                return MenuOption.EXIT;
            default:
                return null;
        }
    }
}
