package view;

import enums.MenuOpcao;

import java.util.Scanner;

public class MenuInicialView {
    Scanner sc = new Scanner(System.in);

    public MenuOpcao exibeMenu() {
        System.out.println("Bem vindo -- Escolha uma opção:");
        System.out.println("[ 1 ] Autenticar");
        System.out.println("[ 2 ] Criar Conta");
        System.out.println("[ 3 ] Sair");
        System.out.print(">>> ");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                return MenuOpcao.AUTENTICAR;
            case 2:
                return MenuOpcao.CRIAR_CONTA;
            case 3:
                return MenuOpcao.SAIR;
            default:
                return null;
        }
    }
}
