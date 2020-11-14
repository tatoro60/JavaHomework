package model;

public class GoalKeeper extends Footballer {
    protected int cleanSheets;
    public GoalKeeper(){
        cleanSheets = 0;
    }
    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }
}
