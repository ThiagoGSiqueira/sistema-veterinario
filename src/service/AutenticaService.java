package service;

import dao.UsuarioDAO;
import dto.AutenticaDTO;
import model.Usuario;

import java.sql.SQLException;

public class AutenticaService {
    public Usuario autenticar(AutenticaDTO autenticaDTO) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.autenticar(autenticaDTO.getEmail(), autenticaDTO.getSenha());
    }
}
