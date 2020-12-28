package Homework.Homework7.Constants;

public enum Role {
    USER("user"),
    ADMIN("admin"),
    END("end");
    private String role;

    Role(String pos) {
        this.role = pos;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String pos) {
        this.role = pos;
    }

    public static Role fromString(String role) {
        for (Role rol : Role.values()) {
            if (rol.getRole().equalsIgnoreCase(role)) {
                return rol;
            }
        }
        return null;
    }
}
