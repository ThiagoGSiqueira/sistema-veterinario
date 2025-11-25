package service;

import dao.UsuarioDAO;
import dao.VeterinarioDAO;
import dto.CriarContaUsuarioDTO;
import dto.CriarVeterinarioDTO;
import model.Usuario;
import model.Veterinario;

import java.sql.SQLException;

public class CriarContaService {

    public Usuario criarConta(CriarContaUsuarioDTO usuarioDTO, CriarVeterinarioDTO vetDTO) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        VeterinarioDAO veterinarioDAO = new VeterinarioDAO();
        int idUsuario = usuarioDAO.criarUsuario(new Usuario(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getSenha(), usuarioDTO.getCargo()));

        if (vetDTO != null) {
            Veterinario veterinario = new Veterinario(vetDTO.getCrmv(), vetDTO.getNumero(), idUsuario);
            veterinarioDAO.criarVeterinario(veterinario);
        }
        return usuarioDAO.buscarUsuarioPorId(idUsuario);
    }
}
