package model;

import java.time.LocalDate;

public class Consultation {
    private int consultationId;
    private int petId;
    private LocalDate consultationDate;
    private String reason;
    private String diagnosis;
    private double price;
    private String status;
    private int userClientId;
    private int userVeterinarianId;


    public Consultation(int petId, LocalDate consultationDate, String reason, String diagnosis,
                        double price, String status, int userClientId, int userVeterinarianId) {
        this.petId = petId;
        this.consultationDate = consultationDate;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.price = price;
        this.status = status;
        this.userClientId = userClientId;
        this.userVeterinarianId = userVeterinarianId;
    }

    public Consultation(int petId, LocalDate consultationDate, String reason, String diagnosis,
                        double price, String status, int userClientId, int userVeterinarianId, int consultationId) {
        this(petId, consultationDate, reason, diagnosis, price, status, userClientId, userVeterinarianId);
        this.consultationId = consultationId;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int idPet) {
        this.petId = petId;
    }

    public LocalDate getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(LocalDate consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserClientId() {
        return userClientId;
    }

    public void setUserClientId(int userClientId) {
        this.userClientId = userClientId;
    }

    public int getUserVeterinarianId() {
        return userVeterinarianId;
    }

    public void setUserVeterinarianId(int userVeterinarianId) {
        this.userVeterinarianId = userVeterinarianId;
    }
}
