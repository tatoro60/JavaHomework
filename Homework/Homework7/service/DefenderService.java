package Homework.Homework7.service;


import Homework.Homework7.model.Defender;
import Homework.Homework7.model.GoalKeeper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class DefenderService  {

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
