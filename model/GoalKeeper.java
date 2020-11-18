package model;

public class GoalKeeper extends Footballer implements GoalkepperStatistics {
    protected int cleanSheets;
    protected int concededGoals;
    protected int saves;
    public GoalKeeper() {
        cleanSheets = 0;
    }

    public int getCleanSheets() {
        return cleanSheets;
    }

    public void setCleanSheets(int cleanSheets) {
        this.cleanSheets = cleanSheets;
    }

    @Override
    public double ratioOfCleanSheets() {
        return 1.0 * cleanSheets / playedGames;
    }

    @Override
    public double concededGoalPerMatch() {
        return 1.0 * concededGoals / playedGames;
    }

    @Override
    public double savesPerMatch() {
        return 1.0 * saves / playedGames;
    }
}
