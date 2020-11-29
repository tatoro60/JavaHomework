package Homework.Homework7.service;


import Homework.Homework7.model.Defender;
import Homework.Homework7.model.Midfielder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MidfielderService implements GeneralStatistics {

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
        return goals * 5;
    }

    @Override
    public int assistScore(int assists) {
        return 3 * assists;
    }

    @Override
    public int yellowCardScore(boolean yellowCard) {
        return yellowCard?-1:0;
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
        return redCard?-1:0;
    }

    @Override
    public int penaltiesEarnedScore(int penaltiesEarned) {
        return penaltiesEarned * 2;
    }

    public void writeToFile(String path, Midfielder midfielder) throws IOException {
        Files.write(Paths.get(path), (midfielder.getFirstName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getLastName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.isAppeared() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.isMinutesPlayed60Plus() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getAssists() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getPenaltiesEarned() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.hasYellowCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.hasRedCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getPenaltiesConceded() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getOwnGoal() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (midfielder.getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }

}
