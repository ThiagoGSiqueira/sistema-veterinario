package dto;

public class AutenticaDTO {
    private String email;
    private String senha;

    public AutenticaDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
