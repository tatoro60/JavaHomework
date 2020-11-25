package Homework.Homework7.service;

public interface GeneralStatistics {
    int appearanceScore(boolean appearance);
    int minutesPlayed60PlusScore(boolean minutesPlayed);
    int goalsScore(int goals);
    int assistScore(int assists);
    int yellowCardScore(boolean yellowCard);
    int penaltiesConcededScore(int penaltiesConceded);
    int ownGoalsScore(int ownGoals);
    int redCardScore(boolean redCard);
    int penaltiesEarnedScore(int penaltiesEarned);
}
