package Homework.Homework7.service;

public class Forward implements GeneralStatistics {

    @Override
    public int appearanceScore(boolean appearance) {
        if (appearance) {
            return 1;
        }
        return 0;
    }

    @Override
    public int minutesPlayed60PlusScore(boolean minutesPlayed) {
        if (minutesPlayed) {
            return 2;
        }
        return 0;
    }

    @Override
    public int goalsScore(int goals) {
        return goals * 4;
    }

    @Override
    public int assistScore(int assists) {
        return 3 * assists;
    }

    @Override
    public int yellowCardScore(boolean yellowCard) {
        if (yellowCard) {
            return -1;
        }
        return 0;
    }

    @Override
    public int penaltiesConcededScore(int penaltiesConceded) {
        return penaltiesConceded * -1;
    }

    @Override
    public int ownGoalsScore(int ownGoals) {
        return ownGoals * -2;
    }

    @Override
    public int redCardScore(boolean redCard) {
        if (redCard) {
            return -3;
        }
        return 0;
    }

    @Override
    public int penaltiesEarnedScore(int penaltiesEarned) {
        return penaltiesEarned * 2;
    }

}
