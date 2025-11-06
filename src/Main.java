import dao.UsuarioDAO;
import model.Usuario;
import resources.DatabaseConfig;
import util.DatabaseConnection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UsuarioDAO uDAO = new UsuarioDAO();

        uDAO.listarUsuarios();

        System.out.println("Logar usuário.");
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = sc.nextLine();



        Usuario usuariologado = uDAO.autenticar(email, senha);



        if (usuariologado != null) {
            if (usuariologado.getCargo().equals("ADMIN")) {
                System.out.println("Logado como administrador");

            } else {
                System.out.println("Logado como cliente");
            }
        } else {
            System.out.println("Credenciais invalidas");
        }


    }
}