package Homework.Homework7;

public enum Position {
    GOALKEEPER("GK"),
    DEFENDER("DF"),
    MIDFIELDER("MF"),
    FORWARD("FW");
    private String val;
    Position(String val){
        this.val = val;
    }
}
