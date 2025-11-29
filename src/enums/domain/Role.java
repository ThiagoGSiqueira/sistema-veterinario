package enums.domain;

public enum Role {
    CLIENT,
    VETERINARIAN,
    ADMIN;

    public static Role fromString(String role) {
        return Role.valueOf(role.toUpperCase());
    }
}
