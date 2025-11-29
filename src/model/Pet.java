package model;

import java.time.LocalDate;

public class Pet {
    private int petId;
    private String name;
    private String size;
    private String specie;
    private LocalDate birthDate;
    private int userId;

    public Pet (String name, String size, String specie, LocalDate birthDate, int userId) {
        this.name = name;
        this.size = size;
        this.specie = specie;
        this.birthDate = birthDate;
        this.userId = userId;
    }

    public Pet(int petId, String name, String size, String specie, LocalDate data_nascimento, int userId) {
        this(name, size, specie, data_nascimento, userId);
        this.petId = petId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate data_nascimento) {
        this.birthDate = birthDate;
    }

    public int getIdUsuario() {
        return userId;
    }

    public void setIdUsuario(int idUsuario) {
        this.userId = idUsuario;
    }


}
