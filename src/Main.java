import dao.UsuarioDAO;
import model.Usuario;
import util.DatabaseConnection;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Quando for criar o fluxo, padronizar o cargo passado pelo usuario, por exemplo, mudar medio para Médio
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        Usuario usuario = new Usuario("Kennedy", "kennedy@email.com", "kennedy123", "admin");

        usuarioDAO.criarConta(usuario);

    }
}