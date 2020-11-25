package Homework.Homework7.service;


public class GoalkeeperService implements GeneralStatistics, GoalkeeperStatistics {

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
        return goals * 8;
    }

    @Override
    public int assistScore(int assists) {
        return 5 * assists;
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

    @Override
    public int cleanSheetScore(boolean cleanSheet) {
        if (cleanSheet) {
            return 4;
        }
        return 0;
    }

    @Override
    public int concededGoalsScore(int concededGoals) {
        return (concededGoals / 2) * -1;
    }

    @Override
    public int penaltyKickSavesScore(int penaltyKickSaves) {
        return penaltyKickSaves*5;
    }

    @Override
    public int savesScore(int saves) {
        return saves/3;
    }
}
