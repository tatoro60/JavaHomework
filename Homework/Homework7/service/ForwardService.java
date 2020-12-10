package Homework.Homework7.service;

import Homework.Homework7.model.Forward;
import Homework.Homework7.model.Midfielder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ForwardService  {

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
