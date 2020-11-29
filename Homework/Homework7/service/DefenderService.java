package Homework.Homework7.service;


import Homework.Homework7.model.Defender;
import Homework.Homework7.model.GoalKeeper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DefenderService implements GeneralStatistics {

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
        return goals * 6;
    }

    @Override
    public int assistScore(int assists) {
        return 3 * assists;
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

    public int cleanSheetScore(boolean cleanSheet) {
        return cleanSheet?4:0;
    }

    public void writeToFile(String path, Defender defender) throws IOException {
        Files.write(Paths.get(path), (defender.getFirstName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getLastName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.isAppeared() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.isMinutesPlayed60Plus() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getAssists() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getPenaltiesEarned() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.hasYellowCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.hasRedCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getPenaltiesConceded() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getOwnGoal() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.isCleanSheet() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (defender.getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }
}
