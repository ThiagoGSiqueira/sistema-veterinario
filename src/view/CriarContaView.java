package view;

import dto.CriarContaUsuarioDTO;
import dto.CriarVeterinarioDTO;
import model.Usuario;

import java.util.Scanner;

public class CriarContaView {
    Scanner sc = new Scanner(System.in);
    public CriarContaUsuarioDTO criarContaUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu e-mail: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();
        System.out.print("Digite seu cargo (Cliente, Veterinario, Admin): ");
        String cargo = sc.nextLine();

        return new CriarContaUsuarioDTO(nome, email, senha, cargo);
    }

    public CriarVeterinarioDTO criarContaVeterinario() {
        System.out.print("Digite seu CRMV (111111SP): ");
        String crmv = sc.nextLine();
        System.out.print("Digite seu número: ");
        String numero = sc.nextLine();

        return new CriarVeterinarioDTO(crmv, numero, null);
    }

    public void contaCriada(Usuario usuario) {
        System.out.println("Sua conta foi criada!");
        System.out.println("Seja bem vindo - " + usuario.getNome() + "!");
    }
}
