package Homework.Homework7.model;


public class GoalKeeper extends Footballer  {
    private boolean cleanSheet ;
    private int penaltyKickSaves;
    private int concededGoals;
    private int saves;
    public  GoalKeeper(){
        cleanSheet =true;
    }
    public boolean wasCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(boolean cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public int getPenaltyKickSaves() {
        return penaltyKickSaves;
    }

    public void setPenaltyKickSaves(int penaltyKickSaves) {
        this.penaltyKickSaves = penaltyKickSaves;
    }

    public int getConcededGoals() {
        return concededGoals;
    }

    public void setConcededGoals(int concededGoals) {
        this.concededGoals = concededGoals;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }
    

}
