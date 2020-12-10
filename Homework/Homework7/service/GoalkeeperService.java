package Homework.Homework7.service;


import Homework.Homework7.model.GoalKeeper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GoalkeeperService {

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
        Files.write(Paths.get(path), (goalKeeper.wasCleanSheet() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getPenaltyKickSaves() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getSaves() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getConcededGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (goalKeeper.getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }
}


