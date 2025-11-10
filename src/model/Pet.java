package model;

import java.time.LocalDateTime;

public class Pet {
    private int idPet;
    private String nome;
    private String porte;
    private String especie;
    private LocalDateTime data_nascimento;
    private int idUsuario;

    public Pet (String nome, String porte, String especie, LocalDateTime data_nascimento, int idUsuario) {
        this.nome = nome;
        this.porte = porte;
        this.especie = especie;
        this.data_nascimento = data_nascimento;
        this.idUsuario = idUsuario;
    }

    public Pet(int idPet, String nome, String porte, String especie, LocalDateTime data_nascimento, int idUsuario) {
        this(nome, porte, especie, data_nascimento, idUsuario);
        this.idPet = idPet;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDateTime getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDateTime data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
