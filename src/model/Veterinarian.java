package model;

public class Veterinarian {

    private String crmv;
    private String phoneNumber;
    private int userId;

    public Veterinarian(String crmv, String phoneNumber) {
        this.crmv = crmv;
        this.phoneNumber = phoneNumber;
    }

    public Veterinarian(String crmv, String phoneNumber, int userId) {
        this(crmv, phoneNumber);
        this.userId = userId;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
