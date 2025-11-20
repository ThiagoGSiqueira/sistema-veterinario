package model;

public class Veterinario {

    private String nome;
    private String crmv;
    private String telefone;
    private int idUsuario;

    public Veterinario(String nome, String crmv, String telefone) {
        this.nome = nome;
        this.crmv = crmv;
        this.telefone = telefone;
    }

    public Veterinario(String nome, String crmv, String telefone, int idUsuario) {
        this(nome, crmv, telefone);
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
