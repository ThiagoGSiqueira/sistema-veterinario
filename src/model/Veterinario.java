package model;

public class Veterinario {

    private String crmv;
    private String telefone;
    private int idUsuario;

    public Veterinario(String crmv, String telefone) {
        this.crmv = crmv;
        this.telefone = telefone;
    }

    public Veterinario(String crmv, String telefone, int idUsuario) {
        this(crmv, telefone);
        this.idUsuario = idUsuario;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
