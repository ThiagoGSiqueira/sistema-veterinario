package controller;

import dto.AutenticaDTO;
import enums.MenuOpcao;
import model.Usuario;
import service.AutenticaService;
import view.AutenticaView;
import view.MenuInicialView;

import java.sql.SQLException;

public class MenuInicialController {
    public void inicia() throws SQLException {
        Usuario usuarioLogado = null;
        MenuInicialView menu = new MenuInicialView();

        MenuOpcao opcao = menu.exibeMenu();

        switch (opcao) {
            case MenuOpcao.AUTENTICAR:
                AutenticaService autenticaService = new AutenticaService();
                AutenticaView autenticaView = new AutenticaView();
                usuarioLogado = autenticaService.autenticar(autenticaView.autenticaMenu());
                autenticaView.usuarioLogado(usuarioLogado);
                break;
            case MenuOpcao.CRIAR_CONTA:
                ///
            case MenuOpcao.SAIR:
                return;
        }
    }
}
