package Homework.Homework7.service;


import Homework.Homework7.model.Defender;
import Homework.Homework7.model.GoalKeeper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GoalkeeperService implements GeneralStatistics, GoalkeeperStatistics {

    @Override
    public int appearanceScore(boolean appearance) {
        return appearance ? 1 : 0;
    }

    @Override
    public int minutesPlayed60PlusScore(boolean minutesPlayed) {
        return minutesPlayed ? 2 : 0;
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
        return yellowCard ? -1 : 0;
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
        return redCard ? -3 : 0;
    }

    @Override
    public int penaltiesEarnedScore(int penaltiesEarned) {
        return penaltiesEarned * 2;
    }

    @Override
    public int cleanSheetScore(boolean cleanSheet) {
        return cleanSheet ? 4 : 0;
    }

    @Override
    public int concededGoalsScore(int concededGoals) {
        return (concededGoals / 2) * -1;
    }

    @Override
    public int penaltyKickSavesScore(int penaltyKickSaves) {
        return penaltyKickSaves * 5;
    }

    @Override
    public int savesScore(int saves) {
        return saves / 3;
    }

    public void writeToFile(String path, GoalKeeper goalKeeper) throws IOException {
        Files.write(Paths.get(path), (goalKeeper.getFirstName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getLastName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.isAppeared() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.isMinutesPlayed60Plus() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getAssists() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getPenaltiesEarned() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.hasYellowCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.hasRedCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getPenaltiesConceded() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getOwnGoal() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.isCleanSheet() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getPenaltyKickSaves() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getSaves() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getConcededGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }
}


