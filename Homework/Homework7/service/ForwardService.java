package Homework.Homework7.service;

import Homework.Homework7.model.Forward;
import Homework.Homework7.model.Midfielder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ForwardService implements GeneralStatistics {

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
        return goals * 4;
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
        return redCard ? -1 : 0;
    }

    @Override
    public int penaltiesEarnedScore(int penaltiesEarned) {
        return penaltiesEarned * 2;
    }

    public void writeToFile(String path, Forward forward) throws IOException {
        Files.write(Paths.get(path), (forward.getFirstName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getLastName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.isAppeared() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.isMinutesPlayed60Plus() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getAssists() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getPenaltiesEarned() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.hasYellowCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.hasRedCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getPenaltiesConceded() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getOwnGoal() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (forward.getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }
}
