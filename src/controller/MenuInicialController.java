package controller;

import dto.AutenticaDTO;
import dto.CriarContaUsuarioDTO;
import dto.CriarVeterinarioDTO;
import enums.MenuOpcao;
import model.Usuario;
import service.AutenticaService;
import service.CriarContaService;
import view.AutenticaView;
import view.CriarContaView;
import view.MenuInicialView;

import java.sql.SQLException;
import java.util.Locale;

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
                CriarContaView criarContaView = new CriarContaView();
                CriarContaUsuarioDTO usuarioDTO = criarContaView.criarContaUsuario();
                CriarVeterinarioDTO vetDTO = null;
                if ("veterinario".equalsIgnoreCase(usuarioDTO.getCargo())) {
                    vetDTO = criarContaView.criarContaVeterinario();
                };

                CriarContaService criarContaService = new CriarContaService();
                usuarioLogado = criarContaService.criarConta(usuarioDTO, vetDTO);
                criarContaView.contaCriada(usuarioLogado);
                break;
            case MenuOpcao.SAIR:
                return;
        }
    }
}
