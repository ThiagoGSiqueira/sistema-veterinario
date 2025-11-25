package dto;

public class CriarVeterinarioDTO {
    private String crmv;
    private String numero;
    private Integer idUsuario;

    public CriarVeterinarioDTO(String crmv, String numero, Integer idUsuario) {
        this.crmv = crmv;
        this.numero = numero;
        this.idUsuario = idUsuario;
    }

    public String getCrmv() {
        return crmv;
    }

    public String getNumero() {
        return numero;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }
}
