package Homework.Homework7.enums;

public enum ROLE {
    USER("user"),
    ADMIN("admin"),
    END("end");
    private String role;

    ROLE(String pos) {
        this.role = pos;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String pos) {
        this.role = pos;
    }

    public static ROLE fromString(String role) {
        for (ROLE rol : ROLE.values()) {
            if (rol.getRole().equalsIgnoreCase(role)) {
                return rol;
            }
        }
        return null;
    }
}
