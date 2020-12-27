package Homework.Homework7.enums;

public enum FOOTBALLERS_Position {
    GOALKEEPER("GK"),
    DEFENDER("DF"),
    MIDFIELDER("MF"),
    FORWARD("FW");
    private String pos;

    FOOTBALLERS_Position(String pos) {
        this.pos = pos;
    }

    public String getPosition() {
        return pos;
    }

    public void setPosition(String pos) {
        this.pos = pos;
    }

    public static FOOTBALLERS_Position fromString(String positionName) {
        for (FOOTBALLERS_Position position : FOOTBALLERS_Position.values()) {
            if (position.getPosition().equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        return null;
    }
}
