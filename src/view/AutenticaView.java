package view;

import dto.AutenticaDTO;
import model.Usuario;

import java.util.Scanner;

public class AutenticaView {

    Scanner sc = new Scanner(System.in);

    public AutenticaDTO autenticaMenu() {
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite seu senha: ");
        String senha = sc.nextLine();

        return new AutenticaDTO(email, senha);
    }

    public void usuarioLogado(Usuario usuario) {
        if (usuario != null) {
            System.out.println(usuario.getNome() + ", seja bem-vindo!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
