package dto.access;

public class CreateVeterinarianAccountDTO {
    private String crmv;
    private String phoneNumber;
    private Integer userId;

    public CreateVeterinarianAccountDTO(String crmv, String phoneNumber, Integer userId) {
        this.crmv = crmv;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public String getCrmv() {
        return crmv;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }
}
