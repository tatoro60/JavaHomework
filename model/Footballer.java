package model;

public class Footballer extends Sportsman implements GeneralStatistics {
    protected int transferValue;
    protected int playedGames;
    protected int goals;
    protected int assists;

    public Footballer() {
        playedGames = 1;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        if (goals >= 0) {
            this.goals = goals;
        }
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        if (transferValue >= 0) {
            this.playedGames = playedGames;
        }
    }

    public int getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(int transferValue) {
        if (transferValue >= 0) {
            this.transferValue = transferValue;
        }
    }

    @Override
    public double ratioOfGoals() {
        return 1.0 * goals / playedGames;
    }

    @Override
    public double assistsPerMatch() {
        return 1.0 * assists / playedGames;
    }
}
