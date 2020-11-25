package Homework.Homework7.service;

public interface GoalkeeperStatistics {
    int cleanSheetScore(boolean cleanSheet);
    int concededGoalsScore(int concededGoals);
    int penaltyKickSavesScore(int penaltyKickSaves);
    int savesScore(int saves);

}
