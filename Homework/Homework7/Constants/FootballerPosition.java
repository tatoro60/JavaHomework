package Homework.Homework7.Constants;

public enum FootballerPosition {
    GOALKEEPER("GK"),
    DEFENDER("DF"),
    MIDFIELDER("MF"),
    FORWARD("FW");
    private String pos;

    FootballerPosition(String pos) {
        this.pos = pos;
    }

    public String getPosition() {
        return pos;
    }

    public void setPosition(String pos) {
        this.pos = pos;
    }

    public static FootballerPosition fromString(String positionName) {
        for (FootballerPosition position : FootballerPosition.values()) {
            if (position.getPosition().equalsIgnoreCase(positionName)) {
                return position;
            }
        }
        return null;
    }
}
